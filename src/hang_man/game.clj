(ns hangman.game)
;; Creates a dictionary using the dictionary class
(def the-Dictionary)

;; Number of guesses user has --> initially set at run time
(def number-of-guess (int 0))

;; The secret word --> created by requesting word from dictionary
(def secret-word "")

;; Set of made guesses
(def made-guesses ) 

;; Vector representing the clue --> should be initialized to the template
(def clue [])

(defn update-game 
	"Takes a guess as an argument and runs through an iteration of hangman"
	[the-guess])

(defn check-guess
	"Returns a true false answer after determining if guess is in secret word"
	[the-guess]
	(contans? secret-word the-guess))

(defn game-over
	"Determines if the game is over"
	)

(defn wrong-guess
	"Handle a wrong guess event by updating game accordingly")

(defn decrease-guesses-left
	"Decreases number of guess for wrong answer iff the guess isn't already in the set")

(defn update-clue
	"Updates the clue after a guess was made")
