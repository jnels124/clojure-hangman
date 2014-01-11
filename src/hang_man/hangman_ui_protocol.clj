(ns hang-man.hangman-ui-protocol)
(defprotocol hangman-ui
	"Interface to wrap methods needed to interact "
	"with the user via some inteface(i.e web, console, gui, ..."
        (dictionary-set-up [this]
          "Requests dictionary to be used for the game, or uses the default.")
	(number-of-guesses [this]
          "Requests number of guesses from the user).")
	(word-length [this]
          "Requests a word length to be used for the game.")
	(play-again [this]
          "Checks to see if the user wants to play again.")
	(show-game [this message game]
          "Shows current status of the game to user")
	(game-won [this game]
          "Notifiers user game was won and defines state of game ending")
	(game-lost [this secret-word game]
          "Notifiers user game was lost and defines state of game ending"))
