(ns z80asm.emit-test
  (:require  [midje.sweet :refer :all]
             [z80asm.emit :refer :all]))

(fact "asm-inst"
      (emit-inst :xor :a) => "        xor a"
      (emit-label :test) => "test:"
      (emit-inst :ld :hl 0) => "        ld hl,0"
      (emit-inst :ld [:hl] 1) => "        ld (hl),1"
      (emit-inst :ld [:ix 2] :a) => "        ld (ix+2),a"
      (emit-inst :ld [:ix -3] :a) => "        ld (ix-3),a"
      (emit-lines [[:xor :a] [:ret]]) => "        xor a\n        ret"
      (emit-lines [[:label :test] [:ret]]) => "test:\n        ret")
