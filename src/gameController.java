import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class gameController {

    private JLabel playerLabel;
    private JLabel enemyLabel;
    private JLabel healthLabel;
    private JLabel guessLabel;
    private int health = 10;
    private JLabel[] chars;
    String correctWord;
    String censoredWord;

    private void playerLabelMouseClicked() {
        frameUpdater.animate(playerLabel, "player", "attack", 400);
        frameUpdater.animate(enemyLabel, "enemy", "hurt", 400);
    }

    private void enemyLabelMouseClicked() {
        frameUpdater.animate(enemyLabel, "enemy", "attack", 600);
        frameUpdater.animate(playerLabel, "player", "hurt", 600);
        health = health - 1;
        frameUpdater.change(healthLabel, "health", Integer.toString(health));
        if (health == 0) {gameOver();}
    }

    private void charsMouseClicked(int x){
        chars[x].setText("");
        char letter =((char)(x + 65));
        System.out.println(letter);

    }

    private void getLabels(frameCreator gameWindow) {
        JLabel[][] labels = gameWindow.labels();

        playerLabel = labels[0][0];
        playerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                playerLabelMouseClicked();
            }
        });

        enemyLabel = labels[0][1];
        enemyLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                enemyLabelMouseClicked();
            }
        });
        
        healthLabel = labels[0][2];

        guessLabel = labels[0][3];
        guessLabel.setText("test");

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
        wordHandler wordHandler = new wordHandler();
        correctWord = wordHandler.wordSelect();
        frameCreator gameWindow = new frameCreator();
        gameWindow.initComponents();
        getLabels(gameWindow);
        wordHandler.wordCensor(guessLabel);
    }

    private void gameOver(){
        System.exit(0);
    }
}
