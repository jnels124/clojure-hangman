(ns hang-man.dictionary
  (:require [clojure.java.io :as io]))

(def max-word-length (int 29))
(def min-word-length (int 2))
(def defualt-dictionary "DefaultDictionary.txt")
(def lowest-character (char \A))
(def highest-character (char \z))
(def dictionary-words '()) 
;; Not working yet
;; 
(defn read-in-dictionary 
	"Reads in dictionary from file and returns data structure with contents"
  [filename]
  #_(slurp (str "resources/DefaultDictionary.txt"))
  (with-open [rdr (io/reader "resources/DefaultDictionary.txt")]
    (doseq [line (line-seq rdr)]
      (println line))))

;;Return random word with given size from the dictionary
(defn randWord
    "Returns a random word from the dictionary with the given word length"
     [word-size] )

(defn all-words-in-dictionary
	"Returns all words in the dictionary with a given size"
	[word-size]
	)

(defn new-dictionary-with-added-word
	"Creates and returns new dictionary with the added word"
	[word-size])