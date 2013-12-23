(ns hang-man.dictionary
	(:require [clojure.java.io :as io]))

(def max-word-length (int 29))
(def min-word-length (int 2))
(def lowest-character (char \A))
(def highest-character (char \z))
;; Not working yet
;; 
(defn read-in-dictionary 
	"Reads in dictionary from file and returns data structure with contents"
	[filename]
	(into []
		(line-seq (io/reader filename)))) 

(defn all-words-in-dictionary
	"Returns all words in the dictionary with a given size"
	[word-size the-dictionary]
	(filter (partial string?) 
		(map #(if (= word-size (count %)) % 0)
			the-dictionary)))

;;Return random word with given size from the dictionary
(defn randWord
	"Returns a random word from the dictionary with the given word length"
	[word-size the-dictionary] 
	(let [candidates (all-words-in-dictionary word-size the-dictionary)]
		(candidates (rand-int (count candidates) ))))

(defn new-dictionary-with-added-word
	"Creates and returns new dictionary with the added word"
	[the-word the-dictionary]
	(cons the-word the-dictionary )) ;;Need to insert in order
 
 (defn contains-char?
 	"This is a helper function to determine if a character is contained" 
 	"in a string.Nil is returned if the character is not contained in the string."
 	[the-word the-char]
 	(some #(= the-char %) the-word))