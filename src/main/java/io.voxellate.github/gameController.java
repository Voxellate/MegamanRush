package io.voxellate.github;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class gameController {

    /* The gameController class manages the game logic, such as score and health and when to play animations. The gameController class may
    * call other classes to complete tasks such as generating the word to guess, drawing the frame, etc.*/

    private int health = 10;    //Integer that contains the player's current health
    private int score = 0;      //Integer that contains the player's current score
    private String playerName;  //String that contains the player's name
    static boolean ready = true;    //Boolean that, when false, prevents the program from accepting input when an animation is being played
    private ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();   //Executor that runs a task after a wait period
    private frameCreator gameWindow;    //An instance of the frameCreator class
    private spriteManager spriteManager;    //An instance of the spriteManager class
    private wordManager wordManager;    //An instance of the wordManager class
    private soundManager soundManager;  //An instance of the soundManager class
    private List<Character> guesses;

    gameController() {  //Class constructor - called when the class is instantiated
        gameWindow = new frameCreator();    //creates a new instance of the frameCreator class, names it gameWindow, and calls its constructor
        playerName = gameWindow.dialog();   //calls gameWindow's dialog() method to render the name dialog
        soundManager = new soundManager();  //creates a new instance of soundManager and names it soundManager
        soundManager.playSound("game", "bgMusic", true);    //calls soundManager's playSound() method, giving variables as needed
        levelStart();   //Calls the levelStart() method

        gameWindow.guessLabel.addKeyListener(new KeyAdapter() { //Defines a keyListener event for the guessLabel attribute of gamwWindow
            @Override   //This class overrides the java library class of the same name
            public void keyReleased(KeyEvent e) {   //Adds a keyListener to the guessLabel attribute in gameWindow
                charsKeyPressed(e); //calls the charsKeyPressed() method when a key is pressed, and provides information about the event
            }
        });

        gameWindow.restartLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {    //Adds a mouseListener to the restartLabel attribute
                restartMouseClicked();  //Calls the restartMouseClicked() method when the label is clicked
            }
        });

        for (int x = 0; x < gameWindow.chars.length; x++) { //For each element in the chars[] array (see frameCreator)
            int finalX = x;     //Declares a finalX integer that is needed to pass through x to charsMouseClicked
            gameWindow.chars[x].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {    //Adds the mouseListener event to each char label in chars[]
                    charsMouseClicked(finalX);  //Calls the charsMouseClicked() method when the key is pressed and gives the value of x
                }
            });
        }
    }

    private void restartMouseClicked(){ //Called when the restart label is clicked
        gameWindow.frame.dispose(); //Terminates the current gameWindow
        new gameController();   //Instantiates a new gameController method. The old instance will eventually be destroyed by the garbage collector
    }

    private void charsMouseClicked(int x){  //Called when a char label is clicked
        inputEvent(x);  //Calls the inputEvent() method and gives the value of x (the array index of the label that was clicked)
    }

    private void charsKeyPressed(KeyEvent e) {  //Called when a key is pressed
        if (e.getKeyCode() >= 65 && e.getKeyCode() <= 90) { //If the keyCode matches the key of an A - Z character...
            inputEvent(e.getKeyCode() - 65);    //subtract 65 from the keyCode value (because A is keyCode 65 but chars[] array index 0)
        } else if (e.getKeyCode() == 27) {System.exit(0);}  //If the key is Esc, terminate the program
    }

    private void inputEvent(int x){ //Method used to interpret label clicks and keystrokes. Called by charsMouseClicked and charsKeyPressed
        if (ready) {    //If the class is not currently processing another input or playing an animation...
            char l =((char)(x + 65));   //Add 65 to x and cast it as a char. This gives the letter that the label/key represents
            if (guesses.contains(l)){return;}   //If the letter has already been guessed, stop executing code in this method
            ready = false;  //set ready to false, preventing input from being accepted by the method
            guesses.add(l); //add the letter to the list of guessed letters
            gameWindow.notifyLabel.setVisible(false);   //Sets the notifyLabel (which currently shows the tutorial) to be invisible
            gameWindow.chars[x].setVisible(false);  //Hides the label of the letter that was guessed
            if (wordManager.wordCompare(l)) {   //If the wordManager.wordCompare() method returns true...
                score = score + 20; //Add 20 to the player's score
                gameWindow.scoreLabel.setText(String.valueOf(score));   //Update the scoreLabel to show the new score
                spriteManager.animate(gameWindow.playerLabel, "player", "attack", 600); //Display animation for the player firing
                soundManager.playSound("player", "attack", false);  //Play sound for player firing
                Runnable task = () -> { //Create a task for the executor
                    spriteManager.animate(gameWindow.enemyLabel, "enemy", "hurt", 400); //Display animation for enemy taking damage
                    soundManager.playSound("enemy", "hurt", false); //Play sound for enemy taking damage
                };
                executor.schedule(task, 200, TimeUnit.MILLISECONDS);    //Execute the task after 200 milliseconds
            } else {    //If the wordManager.wordCompare() method returns false...
                            spriteManager.animate(gameWindow.enemyLabel, "enemy", "attack", 600);   //Show animation for enemy attacking
                soundManager.playSound("enemy", "attack", false);   //Play sound for enemy attacking
                health--;    //Decrease the player's health by 1
                spriteManager.change(gameWindow.healthLabel, "health", Integer.toString(health));   //Update the healthLabel with new health
                if (health == 0) {gameOver(); return;}  //If health is 0, call the gameOver() method
                Runnable task = () -> { //Create a task for the executor
                    spriteManager.animate(gameWindow.playerLabel, "player", "hurt", 400); //Show animation for player getting hurt
                    soundManager.playSound("player", "hurt", false);    //Play sound for player taking damage
                };
                executor.schedule(task, 200, TimeUnit.MILLISECONDS);    //Execute the task after 200 milliseconds
            }
            if (wordManager.wordCheck()){   //If the wordManager.wordCheck() method returns true...
                score = score + 100;    //Add 100 to the player's score
                gameWindow.scoreLabel.setText(String.valueOf(score));   //Update the scoreLabel with the new score
                soundManager.playSound("game", "correct", false);   //play sound for guessing the correct word
                health = health + 5;    //Add 5 to the player's health
                if (health > 10) {health = 10;} //If health is greater than 10, set it to 10
                spriteManager.change(gameWindow.healthLabel, "health", Integer.toString(health));   //Update healthLabel with new health
                ready = false;  //Set ready to be false
                Runnable task = () -> { //Create a new task for the executor
                    gameWindow.resetComponents();   //Call the gameWindow.resetComponents() method
                    levelStart();   //Call levelStart()
                    ready = true;   //Set ready to true, allowing the class to process another input
                };
                executor.schedule(task, 2, TimeUnit.SECONDS);   //Run the task after a 2 minute delay
            }
        }
    }


    private void levelStart() { //Method to generate a new word for the player
        wordManager = new wordManager(gameWindow.guessLabel);    //Instantiates a new wordManager object, which selects a word
        spriteManager = new spriteManager();    //Instantiates spriteManager
        guesses = new ArrayList<>();    //Creates a new ArrayList in guesses
    }

    private void gameOver(){    //Called when the player has run out of health
        soundManager.stopSound();   //calls stopSound()
        spriteManager.change(gameWindow.playerLabel, "player", "dead"); //Changes the playerLabel to the dead sprite
        gameWindow.guessLabel.setText(wordManager.selectedWord);    //Sets the text of guessLabel to the selected word
        soundManager.playSound("player", "dead", false);    //Plays the player dead sound
        gameWindow.notifyLabel.setText("GAME OVER, " + playerName + "! YOUR SCORE WAS" + score);    //Sets the notify label to show the score
        gameWindow.notifyLabel.setVisible(true);    //Makes the notifyLabel visible
        gameWindow.restartLabel.setVisible(true);   //Makes the restartLabel visible
        ready = false;  //Sets ready to false
        executor.shutdown();    //Shuts down the executor
    }
}
