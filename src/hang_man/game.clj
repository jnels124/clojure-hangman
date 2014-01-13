(ns hang-man.game
  (:use [hang-man.dictionary :as dictionary])
  (:import [hang_man.console_ui ConsoleUI]))

(defn update-clue
  "Updates the clue after a guess was made"
  [character game]
  (loop [idx (- (count (game :secret-word)) 1)]
    (if (= -1 idx)
      :done
      (if (= character (aget (game :clue) idx))
        (aset (game :clue) idx character)
        (recur (dec idx)))
      )) (game :clue))

(defn check-guess
  "Returns logically true answer or nil after determining if guess is in secret word"
  [the-guess game]
  (some #{the-guess} (game :secret-word) ))


(defn game-over
  "Determines if the game is over"
  [game]
  (or (= 0 @(game :num-guesses))
      (= (game :secret-word) (apply str (map char (into [] (game :clue)))))))

(declare update-game)

(defn right-guess
  "Handle a right guess event by updating the game map accordingly"
  [character game]
  (swap! (game :guesses) conj character)
  (update-clue character game)
  (if (game-over)
    (.game_won (game :interface))
    (update-game (.show_game (game :interface)
                             (str "You are getting closer! " character " is correct" )
                             game)
                 game)))

(defn decrease-guesses-left
  "Decreases number of guess for wrong answer iff the guess isn't already in the set"
  [character game]
  (if (complement (some #{character} @(game :guesses)))
    (swap! (game :num-guesses) dec)
    nil))

(defn wrong-guess
  "Handle a wrong guess event by updating game accordingly"
  [character game]
  (swap! (game :guesses) conj character)
  (decrease-guesses-left character game)
  (if (game-over)
    (.game_lost (game :interface))
    (update-game (.show_game (game :interface)
                             (str character " is incorrect")
                             game)
                 game)))

(defn update-game
  "Takes a guess as an argument and runs through an iteration of hangman"
  [the-guess game]
  (if (check-guess the-guess game)
    (right-guess the-guess game)
    (wrong-guess the-guess game)))

(defn new-game
  [interface-type]
  (let [dict (dictionary/read-in-dictionary (.dictionary_set_up interface-type))
        num-guesses (.number_of_guesses interface-type)
        length (.word_length interface-type)
        obj {:interface interface-type
             :num-guesses (atom num-guesses)
             :secret-word (dictionary/randWord length dict)
             :guesses (atom (sorted-set))
             :clue (char-array length \_)}]
    obj))
