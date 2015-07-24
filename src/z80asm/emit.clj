(ns z80asm.emit
  (require [clojure.string :as str]))

(def tab "        ")

(defn- symbol-addr-arg?
  [arg]
  (and (vector? arg)
       (= (count arg) 1)
       (keyword? (first arg))))

(defn- number-addr-arg?
  [arg]
  (and (vector? arg)
         (= (count arg) 1)
         (number? (first arg))))

(defn- indexed-arg?
  [arg]
  (and (vector? arg)
         (= (count arg) 2)
         (keyword? (first arg))
         (number? (second arg))))

(defn- emit-arg
  [arg]
  (cond
    (keyword? arg)
    (name arg)

    (string? arg)
    (str "\"" arg "\"")

    (symbol-addr-arg? arg)
    (str "(" (name (first arg)) ")")

    (number-addr-arg? arg)
    (str "(" (first arg) ")")

    (indexed-arg? arg)
    (str "(" (name (first arg))
         (when (> (second arg) 0) "+")
         (second arg) ")")

    (number? arg)
    (str arg)

    :else
    (throw (Exception. "parsing error"))))

(defn- emit-args
  [args]
  (str/join "," (map emit-arg args)))

(defn emit-inst
  [opcode & args]
  (str/trimr
   (str tab
        (name opcode) " "
        (emit-args args))))

(defn emit-label
  [label]
  (str (name label) ":"))

(declare emit-lines)

(defn emit-line
  [line]
  (cond
    (string? line)
    line

    (= (first line) :label)
    (emit-label (second line))

    :else
    (apply emit-inst line)))

(defn emit-lines
  [lines]
  (str/join "\n" (map emit-line lines)))
