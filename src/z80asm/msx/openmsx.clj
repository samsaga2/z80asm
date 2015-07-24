(ns z80asm.msx.openmsx
  (require [z80asm.emit :refer [emit-line]]))

(defn breakpoint
  []
  (emit-line [:out [0x2d] :a]))
