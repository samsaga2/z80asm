(ns z80asm.compile
  (require [z80asm.asm :refer [assemble-code]]
           [clojure.java.io :refer :all]
           [clojure.java.shell :refer [sh]]))

(defn save-code-to-file
  [filename]
  (with-open [wrt (writer filename)]
    (.write wrt (assemble-code))))

(defn- print-sh
  [& args]
  (let [p (apply sh args)]
    (println (:out p))
    (zero? (:exit p))))

(defn compile
  [filename]
  (save-code-to-file filename)
  (print-sh "sjasm" "-s" "-j" filename))

(defn run
  [filename]
  (print-sh "openmsx" "-carta" filename))

(defn compile-and-run
  [name]
  (when (compile (str name ".asm"))
    (run (str name ".out"))))
