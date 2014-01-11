(ns hang-man.console-ui-test
  (:require [clojure.test :refer :all])
  (:import [hang_man.console_ui ConsoleUI])
  )

(def console-test (ConsoleUI.))

(deftest dictionary-set-up-test
  (println "Just hit enter")
  (is (= :pizza (.dictionary_set_up console-test)))
  (println "enter this/is/another/dictionary/path")
  (is (= "this/is/another/dictionary/path" (.dictionary_set_up console-test))))

(deftest number-of-guesses-test
  "This will verify the correct input is recieved"
  (println "Please choose 5")
  (is (=  (.number_of_guesses console-test)  5)))

(deftest word-length-test
  "This will test the correct input is recived"
   (println "Choose word length 8")
   (is (=  (.word_length console-test)  8)))

(deftest play-again-test
  "Verifies the correct boolean is returned"
  (println "Enter y")
  (is (= true (.play_again console-test)))
  (println "Enter n")
  (is (= false (.play_again console-test))))
