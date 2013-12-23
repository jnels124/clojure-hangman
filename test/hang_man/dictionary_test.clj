(ns hang-man.dictionary-test
  (:require [clojure.test :refer :all])
  (:use [hang-man.dictionary :as dictionary]))
(def test-words (dictionary/read-in-dictionary "resources/test-dictionary.txt"))
(deftest read-in-dictionary-test
  (testing "FIXME, I fail."
  	(let [test-dictionary test-words]
  		(is (not-empty test-dictionary))
  		(is (= (class []) (class test-dictionary))) ;; verify value returned is vector
  		(is (= (count test-dictionary) 22))) 
  	))

(deftest all-words-in-dictionary-test
	(def four-letter-words (dictionary/all-words-in-dictionary 4 test-words))
	(is (= 4 (count four-letter-words)))
	(is (some #{"yurt"} four-letter-words))
	(is (some #{"abas"} four-letter-words))
	(is (some #{"ywis"} four-letter-words))
	(is (some #{"bore"} four-letter-words))

	(def five-letter-words (dictionary/all-words-in-dictionary 5 test-words))
	(is (= 3 (count five-letter-words)))
	(is (some #{"abase"} five-letter-words))
	(is (some #{"yurts"} five-letter-words))
	(is (some #{"yurta"} five-letter-words)))
