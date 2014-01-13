(ns hang-man.console-ui
  (:require [hang-man.hangman-ui-protocol :refer :all])
  )

(deftype ConsoleUI []
  hangman-ui
  (dictionary-set-up
    [this]
    (println "Provide file path to a dictionary to be used for the game, or hit enter to use the default.")
    (let [response (read-line)]
      (println "before response"response"after-response")
      (if (not= response "")
        response
        :pizza)));;do something to get the default here ...

  (number-of-guesses
    [this]
    (println "How many guesses would you like to allow?")
    (read-string (read-line)))

  (word-length
    [this]
    (println "How long of a word would you like to use?")
    (read-string (read-line)))

  (play-again
    [this]
    (println "Would you like to play again? y/n")
    (= \y (get (read-line) 0)))

  (show-game
    [this message game]
    (println message "\n\n" game "\n\n" "What is your guess?")
    (let [response (read-line)]
      (get response 0)))

  (game-won
    [this game]
    (println "Congratulations you have guessed all of the correct letters " game))

  (game-lost
    [this secret-word game]
    (println "You are out of guesses, you lose!\n\n"
             game
             "\n\nThe correct secret word is "
             secret-word)))
