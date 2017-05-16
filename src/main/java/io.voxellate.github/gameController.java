package io.voxellate.github;
import javax.swing.*;
import java.awt.event.*;
import java.util.concurrent.*;

class gameController {

    private JLabel playerLabel;
    private JLabel enemyLabel;
    private JLabel healthLabel;
    private JLabel guessLabel;
    private int health = 10;
    private JLabel[] chars;
    private frameCreator gameWindow;
    private frameUpdater frameUpdater;
    private wordHandler wordHandler;
    private soundManager soundManager;
    private boolean ready = true;
    private JLabel gameOverLabel;
    private ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    private void charsMouseClicked(int x){
        inputEvent(x);
    }

    private void charsKeyPressed(KeyEvent e) {
        if (e.getKeyCode() >= 65 && e.getKeyCode() <= 90) {
            inputEvent(e.getKeyCode() - 65);
        } else if (e.getKeyCode() == 27) {System.exit(0);}
    }

    private void inputEvent(int x){
        if (ready) {
            chars[x].setVisible(false);
            char l =((char)(x + 65));
            if (wordHandler.wordCompare(l)) {
                frameUpdater.animate(playerLabel, "player", "attack", 400);
                soundManager.playSound("player", "attack", false);
                Runnable task = () -> {
                    frameUpdater.animate(enemyLabel, "enemy", "hurt", 500);
                    soundManager.playSound("enemy", "hurt", false);

                };
                    executor.schedule(task, 200, TimeUnit.MILLISECONDS);
            } else {
                frameUpdater.animate(enemyLabel, "enemy", "attack", 400);
                soundManager.playSound("enemy", "attack", false);
                health = health - 1;
                frameUpdater.change(healthLabel, "health", Integer.toString(health));
                if (health == 0) {gameOver();}

                Runnable task = () -> {
                    frameUpdater.animate(playerLabel, "player", "hurt", 500);
                    soundManager.playSound("player", "hurt", false);
                };
                executor.schedule(task, 200, TimeUnit.MILLISECONDS);
            }
            if (wordHandler.wordCheck()){
                soundManager.playSound("game", "correct", false);
                ready = false;
                Runnable task = () -> {
                    gameWindow.resetComponents();
                    gameStart();
                    ready = true;
                };
                executor.schedule(task, 2, TimeUnit.SECONDS);
            }
        }
    }

    private void getLabels(frameCreator gameWindow) {
        JLabel[][] labels = gameWindow.labels();

        playerLabel = labels[0][0];

        enemyLabel = labels[0][1];
        
        healthLabel = labels[0][2];

        guessLabel = labels[0][3];
        guessLabel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                charsKeyPressed(e);
            }
        });

        gameOverLabel = labels[0][4];

        chars = labels[1];
        for (int x = 0; x < chars.length; x++) {
            int finalX = x;
            chars[x].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    charsMouseClicked(finalX);
                }
            });
        }
    }

    gameController() {
        gameWindow = new frameCreator();
        gameWindow.initComponents();
        getLabels(gameWindow);
        soundManager = new soundManager();
        soundManager.playSound("game", "bgMusic", true);
        gameStart();
    }

    private void gameStart() {
        wordHandler = new wordHandler();
        wordHandler.wordSelect();
        wordHandler.wordCensor(guessLabel);
        frameUpdater = new frameUpdater();
    }

    private void gameOver(){
        frameUpdater.change(playerLabel, "player", "dead");
        guessLabel.setText(wordHandler.selectedWord);
        soundManager.playSound("player", "dead", false);
        gameOverLabel.setVisible(true);
        ready = false;
        executor.shutdown();
    }
}
