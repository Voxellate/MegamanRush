package io.voxellate.github;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

class frameCreator {
    void resetComponents() {
        for (int x = 0; x < 26; x++) {
            chars[x].setVisible(true);
        }
        guessLabel.setText(null);
    }

    frameCreator() {
        try {
            mmFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("fonts/megaman_2.ttf"));
            mmFont = mmFont.deriveFont(22f);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        guessLabel = new JLabel();
        chars = new JLabel[26];
        JPanel charPanel = new JPanel();
        scoreLabel = new JLabel();

        //======== frame ========
        notifyLabel = new JLabel();
        restartLabel = new JLabel();
        enemyLabel = new JLabel();
        playerLabel = new JLabel();
        healthLabel = new JLabel();
        JLabel background = new JLabel();
        JLabel scorebgLabel = new JLabel();
        JLayeredPane layerPane = new JLayeredPane();
        frame = new JFrame();
        {
            frame.setResizable(false);
            frame.setFocusable(false);
            Container frameContentPane = frame.getContentPane();
            //======== layerPane ========
            {
                //---- notifyLabel ----
                notifyLabel.setText("<html>TRY TO GUESS THE WORD!<br>USE BUTTONS OR KEYBOARD</html>");
                notifyLabel.setFont(mmFont);
                notifyLabel.setHorizontalAlignment(SwingConstants.CENTER);
                notifyLabel.setForeground(new Color(204, 204, 204));
                notifyLabel.setVisible(true);
                layerPane.add(notifyLabel, JLayeredPane.DEFAULT_LAYER);
                notifyLabel.setBounds(320, 170, 600, 45);

                //---- restartLabel ----
                restartLabel.setText("CLICK TO RESTART");
                restartLabel.setFont(mmFont);
                restartLabel.setHorizontalAlignment(SwingConstants.CENTER);
                restartLabel.setForeground(new Color(204, 204, 204));
                restartLabel.setVisible(false);
                layerPane.add(restartLabel, JLayeredPane.DEFAULT_LAYER);
                restartLabel.setBounds(420, 220, 400, 45);

                //======== charPanel ========
                {
                    charPanel.setLayout(new GridLayout(2, 0, 10, 10));
                    for (int x = 0; x < 26; x++) {
                        char y = ((char) (x + 65));
                        chars[x] = new JLabel();
                        chars[x].setText(String.valueOf(y));
                        chars[x].setFont(mmFont);
                        chars[x].setFocusable(false);
                        chars[x].setHorizontalTextPosition(SwingConstants.CENTER);
                        charPanel.add(chars[x]);
                    }
                }
                layerPane.add(charPanel, JLayeredPane.DEFAULT_LAYER);
                layerPane.setFocusable(false);
                charPanel.setBounds(10, 555, 600, 95);
                charPanel.setFocusable(false);

                //---- healthLabel ----
                healthLabel.setIcon(new ImageIcon(getClass().getResource("img/health_10.png")));
                layerPane.add(healthLabel, JLayeredPane.DEFAULT_LAYER);
                healthLabel.setBounds(20, 20, 56, 200);
                healthLabel.setFocusable(false);

                //---- scoreLabel ----
                scoreLabel.setText("0");
                scoreLabel.setFont(mmFont);
                scoreLabel.setHorizontalAlignment(SwingConstants.LEFT);
                scoreLabel.setForeground(new Color(204, 204, 204));
                scoreLabel.setVisible(true);
                layerPane.add(scoreLabel, JLayeredPane.DEFAULT_LAYER);
                scoreLabel.setBounds(1020, 19, 200, 60);

                //---- scorebgLabel
                scorebgLabel.setIcon(new ImageIcon(getClass().getResource("img/score.png")));
                layerPane.add(scorebgLabel, JLayeredPane.DEFAULT_LAYER);
                scorebgLabel.setBounds(820, 20, 400, 60);
                scorebgLabel.setFocusable(false);

                //---- playerLabel ----
                playerLabel.setIcon(new ImageIcon(getClass().getResource("img/player_idle.png")));
                playerLabel.setHorizontalAlignment(SwingConstants.CENTER);
                layerPane.add(playerLabel, JLayeredPane.DEFAULT_LAYER);
                playerLabel.setBounds(275, 300, 116, 112);
                playerLabel.setFocusable(false);

                //---- enemyLabel ----
                enemyLabel.setIcon(new ImageIcon(getClass().getResource("img/enemy_idle.png")));
                enemyLabel.setHorizontalAlignment(SwingConstants.CENTER);
                layerPane.add(enemyLabel, JLayeredPane.DEFAULT_LAYER);
                enemyLabel.setBounds(800, 320, 84, 92);
                enemyLabel.setFocusable(false);

                //---- background ----
                background.setIcon(new ImageIcon(getClass().getResource("img/background.png")));
                layerPane.add(background, JLayeredPane.DEFAULT_LAYER);
                background.setBounds(0, 0, 1260, 550);
                background.setFocusable(false);

                //---- guessLabel ----
                guessLabel.setFont(mmFont);
                guessLabel.setHorizontalAlignment(SwingConstants.CENTER);
                layerPane.add(guessLabel, JLayeredPane.DEFAULT_LAYER);
                guessLabel.setBounds(570, 585, 675, 31);
                guessLabel.setText("Loading...");
                guessLabel.setFocusable(true);
            }

            GroupLayout frameContentPaneLayout = new GroupLayout(frameContentPane);
            frameContentPane.setLayout(frameContentPaneLayout);
            frameContentPaneLayout.setHorizontalGroup(
                    frameContentPaneLayout.createParallelGroup()
                            .addComponent(layerPane, GroupLayout.DEFAULT_SIZE, 1258, Short.MAX_VALUE)
            );
            frameContentPaneLayout.setVerticalGroup(
                    frameContentPaneLayout.createParallelGroup()
                            .addComponent(layerPane, GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
            );
            frame.setSize(1260, 690);
            frame.setTitle("Mega Man Rush");
            frame.setLocationRelativeTo(frame.getOwner());
        }
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    String dialog(){
        return JOptionPane.showInputDialog(
                frame,
                "What is your name?",
                "Mega Man Rush",
                JOptionPane.PLAIN_MESSAGE);
    }

    JFrame frame;
    JLabel[] chars;
    JLabel scoreLabel;
    JLabel healthLabel;
    JLabel playerLabel;
    JLabel enemyLabel;
    JLabel guessLabel;
    JLabel restartLabel;
    JLabel notifyLabel;

    private Font mmFont;
}



