(ns hello-world
  (require [z80asm.asm :refer :all]
           [z80asm.compile :refer [compile run]]
           [z80asm.msx.bios :as bios]
           [z80asm.msx.sysvar :as sysvar]
           [z80asm.msx.openmsx :as openmsx]))

(decproc main)

(defproc romheader
  [:defpage 0 0x4000 0x2000]
  [:defpage 1 0x8000]
  [:page 0]
  [:db "AB"]
  [:dw main]
  [:dw 0 0 0 0 0 0])

(defproc init
  [:ld :a 0]
  [:call bios/chgmod]
  [:ld :a 15]
  [:ld [sysvar/forclr] :a]
  [:xor :a]
  [:ld [sysvar/bakclr] :a]
  [:ld [sysvar/bdrclr] :a]
  [:call bios/chgclr]
  [:ret])

(defproc print-string
  [:ld :b [:hl]]
  [:inc :hl]
  (with-djnz
    [:ld :a [:hl]]
    [:inc :hl]
    [:call bios/chput])
  [:ret])

(defproc msg
  [:db 12 "Hello world!"])

(defproc main
  [:call init]
  [:ld :hl msg]
  [:call print-string]
  (with-label l [:jr l]))

(compile "hello-world.asm")
(run "hello-world.out")
