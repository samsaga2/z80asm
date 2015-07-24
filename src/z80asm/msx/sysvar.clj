(ns z80asm.msx.sysvar)

;; http://fms.komkon.org/MSX/Docs/SysArea.txt

(def drive   0xf2e1) ;; current drive
(def nmbdrv  0xf347) ;; total number of drivies
(def dpblst  0xf355) ;; list of drive parameters block
(def setrom  0xf368) ;; set disk-basic rom
(def setram  0xf36b) ;; set system ram configuration
(def sltmov  0xf36e) ;; inter slot move
(def rombdos 0xf37d) ;; rom bdos vector
(def rdprim  0xf380) ;; read from basic slot
(def wrprim  0xf385) ;; write to basic slot
(def clprim  0xf38c) ;; call basic slot
(def usrtab  0xf39a) ;; usr function starting addresses
(def linl40  0xf3ae) ;; screen width per line in screen 0
(def linl32  0xf3af) ;; screen width per line in screen 1
(def linlen  0xf3b0) ;; current screen width per line
(def crtcnt  0xf3b1) ;; number of lines of current screen
(def clmlst  0xf3b2) ;; horizontal location in the case that items are divided by commas in print statement
(def txtnam  0xf3b3) ;; pattern name tabte
(def txtcol  0xf3b5) ;; color table
(def txtcgp  0xf3b7) ;; pattern ganarator table
(def txtatr  0xf3b9) ;; unused
(def txtpat  0xf3bb) ;; unused
(def t32nam  0xf3bd) ;; pattern name tabte
(def t32col  0xf3bf) ;; color table
(def t32cgp  0xf3c1) ;; pattern ganarator table
(def t32atr  0xf3c3) ;; sprite attribute table
(def t32pat  0xf3c5) ;; sprite generator table
(def grpnam  0xf3c7) ;; pattern name tabte
(def grpcol  0xf3c9) ;; color table
(def grpcgp  0xf3cb) ;; pattern ganarator table
(def grpatr  0xf3cd) ;; sprite attribute table
(def grppat  0xf3cf) ;; sprite generator table
(def mltnam  0xf3d1) ;; pattern name tabte
(def mltcol  0xf3d3) ;; color table
(def mltcgp  0xf3d5) ;; pattern ganarator table
(def mltatr  0xf3d7) ;; sprite attribute table
(def mltpat  0xf3d9) ;; sprite generator table
(def cliksw  0xf3db) ;; key click switch
(def csry    0xf3dc) ;; y-coordinate of cursor
(def csrx    0xf3dd) ;; x-coordinate of cursor
(def cnsdfg  0xf3de) ;; functon key display switch
(def rg0sav  0xf3df)
(def rg1sav  0xf3e0)
(def rg2sav  0xf3e1)
(def rg3sav  0xf3e2)
(def rg4sav  0xf3e3)
(def rg5sav  0xf3e4)
(def rg6sav  0xf3e5)
(def rg7sav  0xf3e6)
(def statfl  0xf3e7) ;; stores vdp status (msx2- vdp status register 0)
(def trgflg  0xf3e8) ;; stories trigger button status of joystick
(def forclr  0xf3e9) ;; foreground colour
(def bakclr  0xf3ea) ;; background colour
(def bdrclr  0xf3eb) ;; border colour
(def maxupd  0xf3ec) ;; jmp 0000 (used by circle statement)
(def minupd  0xf3ef) ;; jmp 0000 (used by circle statement)
(def atrbyt  0xf3f2) ;; color code in csing graphic
(def queues  0xf3f3) ;; points to queue table at the execution of play st.
(def frcnew  0xf3f5) ;; db 255
(def scncnt  0xf3f6) ;; interval for the key scan
(def repcnt  0xf3f7) ;; delay until the auto-repeat of the key begins
(def putpnt  0xf3f8) ;; dw keybuf points to adress to write in the key buffer
(def getpnt  0xf3fa) ;; dw keybuf points to adress to read from the key buffer
(def cs120   0xf3fc) ;; reading parameters
(def low     0xf406)
(def high    0xf408)
(def header  0xf40a)
(def aspct1  0xf40b) ;; 256/aspect ratio
(def aspct2  0xf40d) ;; 256*aspect ratio
(def endpgm  0xf40f) ;; db ":" dummy program end for resume next st.
(def errflg  0xf414) ;; error number
(def lptpos  0xf415) ;; position of printer head
(def prtflg  0xf416) ;; flag whether to send to printer
(def ntmsxp  0xf417) ;; =0 if msx printer
(def rawprt  0xf418) ;; <>0 if printing is in 'raw mode'
(def vlzadr  0xf419) ;; address of character replaced by val
(def vlzdat  0xf41b) ;; character replaced with 0 by val
(def curlin  0xf41c) ;; current execution line number of basic
(def kbuf    0xf41f) ;; crunch buffer;translated into intermediate language from buf
(def bufmin  0xf55d) ;; used in input st.
(def buf     0xf55e) ;; buffer to store characters typed( in ascii code)
(def endbuf  0xf660) ;; preventoverflow of buf
(def ttypos  0xf661) ;; virtual cursor location internally retained by basic
(def dimflg  0xf662) ;; array flag
(def valtyp  0xf663) ;; type indicator
(def oprtyp  0xf664) ;; store operator number in the extended momentarily before operator application
(def dores   0xf664) ;; indicates whether stored word can be crunched
(def donum   0xf665) ;; flag for crunch
(def contxt  0xf666) ;; text address used by cnrget
(def consav  0xf668) ;; store token of constant after calling chrget
(def contyp  0xf669) ;; type of stored constant
(def conlo   0xf66a) ;; valu of stored constant
(def memsiz  0xf672) ;; highest location in memory used by basic
(def stktop  0xf674) ;; top location to be used for the stack
(def txttab  0xf676) ;; starting address of basic text area
(def temppt  0xf678) ;; starting address of unused area of temporary descriptor
(def tempst  0xf67a) ;; temporary descriptors
(def dsctmp  0xf698) ;; string descriptor wich is the result of string fun.
(def fretop  0xf69b) ;; starting address of unused area of string area
(def temp3   0xf69d) ;; used for garbage collection or by usr function
(def temp8   0xf69f) ;; used for garbage collection
(def endfor  0xf6a1) ;; next address of for st.
(def datlin  0xf6a3) ;; line number of data st.read by read st.
(def subflg  0xf6a5) ;; flag for array for usr fun.
(def usflg   0xf6a6)
(def flginp  0xf6a6) ;; flag for input or read
(def temp    0xf6a7) ;; location for temporary reservation for st.code
(def ptrflg  0xf6a9) ;; =0 if no line number converted to pointers
(def autflg  0xf6aa) ;; auto mode flag
(def autlin  0xf6ab) ;; current line number for auto
(def autinc  0xf6ad) ;; increment for auto
(def savtxt  0xf6af) ;; text pointer for resume
(def savstk  0xf6b1) ;; save stack when error occurs
(def errlin  0xf6b3) ;; line where last error
(def dot     0xf6b5) ;; current line for edit & list
(def errtxt  0xf6b7) ;; text pointer for use by resume
(def onelin  0xf6b9) ;; line to go when error
(def oneflg  0xf6bb) ;; =1 if executing an error trap routine
(def temp2   0xf6bc)
(def oldlin  0xf6be) ;; old line number set up ^c ...
(def oldtxt  0xf6c0) ;; points st. to be executed next
(def vartab  0xf6c2) ;; pointer to start of variable space
(def arytab  0xf6c4) ;; pointer to begging of array table
(def strend  0xf6c6) ;; end of storage in use
(def datptr  0xf6c8) ;; data pointer
(def deftbl  0xf6ca) ;; default valtype for each letter
(def prmstk  0xf6e4) ;; previous definition block on stack
(def prmlen  0xf6e6) ;; number of bytes of objective table
(def parm1   0xf6e8) ;; objective prameter definition table
(def prmprv  0xf74c) ;; pointer to previous parameter block
(def prmln2  0xf74e) ;; size of parameter block
(def parm2   0xf750) ;; for parameter storage
(def prmflg  0xf7b4) ;; flag to indicate whether parm1 was searching
(def aryta2  0xf7b5) ;; end point of search
(def nofuns  0xf7b7) ;; 0 if no function active
(def temp9   0xf7b8) ;; location of temporary storage for garbage collection
(def funact  0xf7ba) ;; count of active functions
(def swptmp  0xf7bc) ;; value of first  variable in swap st.
(def trcflg  0xf7c4) ;; 0 means no trace
(def fbuffr  0xf7c5) ;; buffer for fout
(def dectmp  0xf7f0) ;; used to transform decimal integer to floating point number
(def dectm2  0xf7f2) ;; used at division routine execution
(def deccnt  0xf7f4) ;; used at division routine execution
(def dac     0xf7f6) ;; decimal accumulator
(def hold8   0xf806) ;; registers for decimal multiplication
(def hold2   0xf836)
(def hold    0xf83e)
(def arg     0xf847) ;; area to set the value to be calculate with dac
(def rndx    0xf857) ;; last random number
(def maxfil  0xf85f) ;; high legal file number
(def filtab  0xf860) ;; starting address of of file data area
(def nulbuf  0xf862) ;; points to file 0 buffer ( used in save & load st.)
(def ptrfil  0xf864) ;; points to file data of currently accessing file
(def runflg  0xf866) ;; non-zero for run after load
(def filnam  0xf866) ;; name for files, name & others
(def filnm2  0xf871) ;; second name for name
(def nlonly  0xf87c) ;; <>0 when loading program
(def savend  0xf87d) ;; end address for bsave
(def fnkstr  0xf87f) ;; function key area
(def cgpnt   0xf91f) ;; address to store charecter font in rom
(def chradr  0xf920) ;; address of the character font
(def nambas  0xf922) ;; base address of current pattern name table
(def cgpbas  0xf924) ;; base address of current pattern generator table
(def patbas  0xf926) ;; base address of current sprite generator table
(def atrbas  0xf928) ;; base address of current sprite attribute table
(def cloc    0xf92a)
(def cmask   0xf92c)
(def mindel  0xf92d)
(def maxdel  0xf92f)
(def aspect  0xf931) ;; aspect ratio of the circle; set by <ratio> of circle
(def cencnt  0xf933) ;; end count
(def clinef  0xf935) ;; flag to draw line to centre
(def cnpnts  0xf936) ;; point to be plottted
(def cplotf  0xf938) ;; plot polarity flag
(def cpcnt   0xf939) ;; 1/8 of number of points in circle
(def cpcnt8  0xf93b)
(def crcsum  0xf93d)
(def cstcnt  0xf93f)
(def csclxy  0xf941) ;; scale of x & y
(def csavea  0xf942) ;; reservation area of advgrp
(def csavem  0xf944) ;; reservation area of advgrp
(def cxoff   0xf945) ;; x offset from center
(def cyoff   0xf947) ;; y offset from center
(def lohmsk  0xf949)
(def lohdir  0xf94a)
(def lohadr  0xf94b)
(def lohcnt  0xf94d)
(def skpcnt  0xf94f) ;; skip count
(def movcnt  0xf951) ;; movement count
(def pdirec  0xf953) ;; direction of the paint
(def lfprog  0xf954)
(def rtprog  0xf955)
(def mcltab  0xf956)
(def mclflg  0xf958) ;; play / draw
(def quetab  0xf959)
(def quebak  0xf971)
(def voicaq  0xf975)
(def voicbq  0xf9f5)
(def voiccq  0xfa75)
(def dppage  0xfaf5) ;; display page number
(def acpage  0xfaf6) ;; active page number
(def avcsav  0xfaf7) ;; reserves av control port
(def exbrsa  0xfaf8) ;; sub_rom slot address
(def chrcnt  0xfaf9) ;; character counter in the buffer; used in roman-kana translation
(def roma    0xfafa) ;; area to store character (japan version only)
(def mode    0xfafc) ;; mode svitch for vram size
(def noruse  0xfafd) ;; unused
(def xsave   0xfafe) ;; [10000000 xxxxxxxx]
(def ysave   0xfb00) ;; [*0000000 yyyyyyyy] *-light pen interrupt request
(def logopr  0xfb02) ;; logical operation code data area used by rs-232c or disk drive
(def rstmp   0xfb03)
(def tocnt   0xfb03)
(def rsfcb   0xfb04)
(def rsiqln  0xfb06)
(def mexbih  0xfb07) ;; hook
(def oldstt  0xfb0c) ;; hook
(def oldint  0xfb12) ;; hook
(def devnum  0xfb17)
(def datcnt  0xfb18) ;; hook
(def errors  0xfb1b)
(def flags   0xfb1c)
(def estbls  0xfb1d)
(def commsk  0xfb1e)
(def lstcom  0xfb1f)
(def lstmod  0xfb20)
(def prscnt  0xfb35)
(def savsp   0xfb36)
(def voicen  0xfb38)
(def savvol  0xfb39)
(def mcllen  0xfb3b)
(def mclptr  0xfb3c)
(def queuen  0xfb3e)
(def musicf  0xfb3f)
(def plycnt  0xfb40)
(def vcba    0xfb41)
(def vcbb    0xfb66)
(def vcbc    0xfb8b)
(def enstop  0xfbb0) ;; <>0 if warm start enabled
(def basrom  0xfbb1) ;; <>0 if basic is in rom
(def linttb  0xfbb2) ;; line terminator table
(def fstpos  0xfbca) ;; first position for inlin
(def codsav  0xfbcc) ;; code save area for cursor
(def fnkswi  0xfbcd) ;; indicate which func key is displayed
(def fnkflg  0xfbce) ;; fkey which have subroutine
(def ongsbf  0xfbd8) ;; global event flag
(def clikfl  0xfbd9)
(def oldkey  0xfbda)
(def newkey  0xfbe5)
(def keybuf  0xfbf0) ;; key code buffer
(def bufend  0xfc18) ;; end of key buffer
(def linwrk  0xfc18)
(def patwrk  0xfc40)
(def bottom  0xfc48)
(def himem   0xfc4a)
(def trptbl  0xfc4c)
(def rtycnt  0xfc9a)
(def intflg  0xfc9b)
(def pady    0xfc9c)
(def padx    0xfc9d)
(def jiffy   0xfc9e)
(def intval  0xfca0)
(def intcnt  0xfca2)
(def lowlim  0xfca4)
(def winwid  0xfca5)
(def grphed  0xfca6) ;; flag for graph. char
(def esccnt  0xfca7) ;; escape sequence counter
(def insflg  0xfca8) ;; insert mode flag
(def csrsw   0xfca9) ;; cursor display switch
(def cstyle  0xfcaa) ;; cursor style
(def capst   0xfcab) ;; capital status
(def kanast  0xfcac) ;; russian key status
(def kanamd  0xfcad)
(def flbmem  0xfcae) ;; 0 if loading basic programm
(def scrmod  0xfcaf) ;; screen mode
(def oldscr  0xfcb0) ;; old screen mode
(def casprv  0xfcb1)
(def brdatr  0xfcb2) ;; border color for paint
(def gxpos   0xfcb3)
(def gypos   0xfcb5)
(def grpacx  0xfcb7)
(def grpacy  0xfcb9)
(def drwflg  0xfcbb)
(def drwscl  0xfcbc)
(def drwang  0xfcbd)
(def runbnf  0xfcbe) ;; doing bload bsave or not
(def savent  0xfcbf) ;; start address for bsave
(def exptbl  0xfcc1) ;; flag for expanded slot
(def slttbl  0xfcc5) ;; current expanded slot reg
(def sltatr  0xfcc9)
(def sltwrk  0xfd09)
(def procnm  0xfd89) ;; name of expanded statement
(def device  0xfd99) ;; device id for cartrige 0-3

(def h.keyi  0xfd9a)
(def h.timi  0xfd9f)
(def h.nmi   0xfdd6)
