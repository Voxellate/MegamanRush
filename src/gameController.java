import javax.swing.*;
import java.awt.event.*;

class gameController {

    private JLabel playerLabel;
    private JLabel enemyLabel;
    private JLabel healthLabel;
    private JLabel guessLabel;
    private int health = 10;
    private JLabel[] chars;
    private frameCreator gameWindow;
    private wordHandler wordHandler;
    private boolean ready = true;
    private JLabel gameOverLabel;

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
                frameUpdater.animate(enemyLabel, "enemy", "hurt", 400);
            } else {
                frameUpdater.animate(enemyLabel, "enemy", "attack", 600);
                frameUpdater.animate(playerLabel, "player", "hurt", 600);
                health = health - 1;
                frameUpdater.change(healthLabel, "health", Integer.toString(health));
                if (health == 0) {gameOver();}
            }
            if (wordHandler.wordCheck()){
                gameWindow.resetComponents();
                gameStart();
            }
        }
    }

    private void getLabels(frameCreator gameWindow) {
        JLabel[][] labels = gameWindow.labels();

        playerLabel = labels[0][0];

        enemyLabel = labels[0][1];
        
        healthLabel = labels[0][2];

        guessLabel = labels[0][3];
        guessLabel.setText("test");
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
        gameStart();
    }

    private void gameStart() {
        getLabels(gameWindow);
        wordHandler = new wordHandler();
        wordHandler.wordSelect();
        wordHandler.wordCensor(guessLabel);
    }

    private void gameOver(){
        gameOverLabel.setVisible(true);
        ready = false;
    }
}
