(ns z80asm.asm
  (require [z80asm.emit :refer [emit-lines]]
           [clojure.string :as str]))

(defonce procedures (atom (sorted-map)))

(defn clear-procedures!
  []
  (reset! procedures (sorted-map)))

(defn asm
  [label & insts]
  (swap! procedures assoc label
         (emit-lines (cons [:label label] insts))))

(defn symbol->label
  [sym]
  (-> (resolve sym)
      (str)
      (str/replace #"^#'" "_")
      (str/replace #"[^A-Z0-9a-z]" "_")
      (keyword)))

(defmacro decproc
  [name]
  `(def ~name ~(symbol->label name)))

(defmacro defproc
  [name & insts]
  (let [label (symbol->label name)]
    `(do (def ~name ~label)
         (asm ~label ~@insts))))

(defn assemble-code
  []
  (str/join "\n"
            (reverse (map second @procedures))))

(defmacro with-label
  [name & body]
  `(let [~name (keyword (gensym))]
     (emit-lines (vector [:label ~name] ~@body))))

(defmacro with-djnz
  [& body]
  `(with-label l#
     ~@body
     [:djnz l#]))
