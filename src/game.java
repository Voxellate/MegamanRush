import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class game {

    private JLabel playerLabel;
    private JLabel enemyLabel;
    private JLabel healthLabel;
    private int health = 10;
    private JLabel[] chars;

    private void playerLabelMouseClicked(MouseEvent e) {
        spriteUpdate.animate(playerLabel, "player", "attack", 500);
        spriteUpdate.animate(enemyLabel, "enemy", "hurt", 500);
    }

    private void enemyLabelMouseClicked(MouseEvent e) {
        spriteUpdate.animate(enemyLabel, "enemy", "attack", 500);
        spriteUpdate.animate(playerLabel, "player", "hurt", 500);
        health = health - 1;
        spriteUpdate.change(healthLabel, "health", Integer.toString(health));
        if (health == 0) {gameOver();}
    }

    private void charsMouseClicked(MouseEvent e, int x){
        chars[x].setText("");
        System.out.println((char) (x + 65));
    }

    void getLabels(frame gameWindow) {
        JLabel[][] labels = gameWindow.labels();

        playerLabel = labels[0][0];
        playerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                playerLabelMouseClicked(e);
            }
        });

        enemyLabel = labels[0][1];
        enemyLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                enemyLabelMouseClicked(e);
            }
        });
        
        healthLabel = labels[0][2];

        chars = labels[1];
        for (int x = 0; x < chars.length; x++) {
            int finalX = x;
            chars[x].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    charsMouseClicked(e, finalX);
                }
            });
        }
}

    game() {
        frame gameWindow = new frame();
        gameWindow.initComponents();
        getLabels(gameWindow);
    }

    void gameOver(){
        System.exit(0);
    }
}
