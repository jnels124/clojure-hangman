(ns hang-man.game-test
  (:require [clojure.test :refer :all])
  (:use [hang-man.game :as game])
  (:import [hang_man.console_ui ConsoleUI]))


(defn reset
  []
  {:interface (ConsoleUI.)
   :num-guesses (atom 7)
   :secret-word "easy"
   :guesses (atom (sorted-set))
   :clue (char-array 4 \_)})

(deftest decrease-guesses-left-test
  (def mock-object (reset))
  (is (= 6 (decrease-guesses-left \p mock-object)))
  (is (= 6 @(:num-guesses mock-object))))

(deftest update-clue-test
  (def mock-object (reset))
  (is (= (into [] (char-array 4 \_)) (into [] (update-clue \p mock-object)))))
