    ; public Dictionary dictionarySetUp() throws FileNotFoundException; 
    
    ; /**
    ;  * Gets the number of guesses 
    ;  * 
    ;  * @return Number of guesses User wants to allow
    ;  */
    ; public int numberOfGuesses();
    
    ; /**
    ;  * Gets the length of the word for the game
    ;  * 
    ;  * @return Length of word to be used for game
    ;  */
    ; public int wordLength();
    

    ; /**
    ;  * Checks to see if the user wants to play again  
    ;  * 
    ;  */
    ; public void playAgain(); 
    
    ; /**
    ;  * Shows the current game status to the User
    ;  * 
    ;  * @args Info needed to show the game 
    ;  */ 
    ; public char showGame(String message, Game g);
    
    ; /**
    ;  * Notifies User the game was won
    ;  */
    ; public void gameWon(Game g);
    
    ; /**
    ;  * Notifies User the game was lost
    ;  */
    ; public void gameLost(String secretWord, Game g);
    (ns hang-man.console-ui
        (:require [hang-man.hangman-ui-protocol :refer :all]))
    (defn number-of-guesses 
        "This method will request the number of guesses the user wishes to allow"
        []
        (println "How many guesses would you like to allow?")
        (read-line))
    (defn word-length 
        "This method will request the length of the word to be used in the game"
        []
        (println "How long of a word would you like to use?")
        (read-line)
    )

    (defn play-again
        "Asks the user if they would like to play another game"
        []
        (println "Would you like to play another game?")
        (let [response (read-line)]
            (if (= response "Yes")
                true
                false)))