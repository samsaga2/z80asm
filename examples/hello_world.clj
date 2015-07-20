(ns hello-world
  (require [z80asm.asm :refer :all]
           [z80asm.compile :refer [compile run]]))

(def chgmod 0x005f)
(def chgclr 0x0062)
(def chput 0x00a2)
(def forclr 0xf3e9)
(def bakclr 0xf3ea)
(def bdrclr 0xf3eb)

(declare main)

(defproc romheader
  [:defpage 0 0x4000 0x2000]
  [:defpage 1 0x8000]
  [:page 0]
  [:db "AB"]
  [:dw main]
  [:dw 0 0 0 0 0 0])

(defproc init
  [:ld :a 0]
  [:call chgmod]
  [:ld :a 15]
  [:ld [forclr] :a]
  [:xor :a]
  [:ld [bakclr] :a]
  [:ld [bdrclr] :a]
  [:call chgclr]
  [:ret])

(defproc print-msg
  [:ld :hl msg]
  [:ld :b [:hl]]
  [:inc :hl]
  (with-djnz
    [:ld :a [:hl]]
    [:inc :hl]
    [:call chput])
  [:ret])

(defproc msg
  [:db 12 "Hello world!"])

(defproc main
  [:call init]
  [:call print-msg]
  (with-label l [:jr l]))

(compile "hello-world.asm")
(run "hello-world.out")
