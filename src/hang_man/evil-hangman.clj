(ns hang-man.evil-hangman)

;; This is a map to hold all values matching a particular set of guesses
;; The key is a string representing a possible clue and the value is a list 
;;  representing possible words associated with clue
(def word-groups #{})
(def template "") ;; Need to create a template string as long as chosen word size at run time

;; Will implement this version after regular hang-man is implemented
