(ns hang-man.hangman-ui-protocol)
(defprotocol hangman-ui
	"Interface to wrap methods needed to interact "
	"with the user via some inteface(i.e web, console, gui, ..."
	(number-of-guesses [] "Requests number of guesses from the user).")
	(word-length [] "Requests a word length to be used for the game.")
	(play-again [] "Checks to see if the user wants to play again.")
	(show-game [message game] "Shows current status of the game to user")
	(game-won [game] "Notifiers user game was won and defines state of game ending")
	(game-lost [secretWord game] "Notifiers user game was lost and defines state of game ending")
  )