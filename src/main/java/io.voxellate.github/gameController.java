package io.voxellate.github;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class gameController {

    private int health = 10;
    private int score = 0;
    private String playerName;
    static boolean ready = true;
    private ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    private frameCreator gameWindow;
    private spriteManager spriteManager;
    private wordManager wordManager;
    private soundManager soundManager;
    private List<Character> guesses;

    gameController() {
        gameWindow = new frameCreator();
        playerName = gameWindow.dialog();
        soundManager = new soundManager();
        soundManager.playSound("game", "bgMusic", true);
        levelStart();

        gameWindow.guessLabel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                charsKeyPressed(e);
            }
        });

        gameWindow.restartLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                restartMouseClicked();
            }
        });

        for (int x = 0; x < gameWindow.chars.length; x++) {
            int finalX = x;
            gameWindow.chars[x].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    charsMouseClicked(finalX);
                }
            });
        }
    }

    private void restartMouseClicked(){
        gameWindow.frame.dispose();
        new gameController();
    }

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
            char l =((char)(x + 65));
            if (guesses.contains(l)){return;}
            ready = false;
            guesses.add(l);
            gameWindow.notifyLabel.setVisible(false);
            gameWindow.chars[x].setVisible(false);
            if (wordManager.wordCompare(l)) {
                score = score + 20;
                gameWindow.scoreLabel.setText(String.valueOf(score));
                spriteManager.animate(gameWindow.playerLabel, "player", "attack", 600);
                soundManager.playSound("player", "attack", false);
                Runnable task = () -> {
                    spriteManager.animate(gameWindow.enemyLabel, "enemy", "hurt", 400);
                    soundManager.playSound("enemy", "hurt", false);
                };
                executor.schedule(task, 200, TimeUnit.MILLISECONDS);
            } else {
                spriteManager.animate(gameWindow.enemyLabel, "enemy", "attack", 600);
                soundManager.playSound("enemy", "attack", false);
                health = health - 1;
                spriteManager.change(gameWindow.healthLabel, "health", Integer.toString(health));
                if (health == 0) {gameOver(); return;}
                Runnable task = () -> {
                    spriteManager.animate(gameWindow.playerLabel, "player", "hurt", 400);
                    soundManager.playSound("player", "hurt", false);
                };
                executor.schedule(task, 200, TimeUnit.MILLISECONDS);
            }
            if (wordManager.wordCheck()){
                score = score + 100;
                gameWindow.scoreLabel.setText(String.valueOf(score));
                soundManager.playSound("game", "correct", false);
                spriteManager.change(gameWindow.enemyLabel, "enemy", "dead");
                health = health + 5;
                if (health > 10) {health = 10;}
                spriteManager.change(gameWindow.healthLabel, "health", Integer.toString(health));
                ready = false;
                Runnable task = () -> {
                    gameWindow.resetComponents();
                    levelStart();
                    ready = true;
                };
                executor.schedule(task, 2, TimeUnit.SECONDS);
            }
        }
    }


    private void levelStart() {
        wordManager = new wordManager();
        wordManager.wordSelect();
        wordManager.wordCensor(gameWindow.guessLabel);
        spriteManager = new spriteManager();
        guesses = new ArrayList<>();
    }

    private void gameOver(){
        soundManager.stopSound();
        spriteManager.change(gameWindow.playerLabel, "player", "dead");
        gameWindow.guessLabel.setText(wordManager.selectedWord);
        soundManager.playSound("player", "dead", false);
        gameWindow.notifyLabel.setText("<html>GAME OVER,&ensp;" + playerName + "!<br>YOUR SCORE WAS&ensp;" + score + "</html>");
        gameWindow.notifyLabel.setVisible(true);
        gameWindow.restartLabel.setVisible(true);
        ready = false;
        executor.shutdown();
    }
}
