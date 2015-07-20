(ns z80asm.compile
  (require [z80asm.asm :refer [assemble-code]]
           [clojure.java.io :refer :all]
           [clojure.java.shell :refer [sh]]))

(defn save-code-to-file
  [filename]
  (with-open [wrt (writer filename)]
    (.write wrt (assemble-code))))

(defn compile
  [filename]
  (save-code-to-file filename)
  (sh "sjasm" "-s" "-j" filename))

(defn run
  [filename]
  (sh "openmsx" "-carta" filename))
