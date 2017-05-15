import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

class frameCreator {

        JLabel[][] labels() {
            return new JLabel[][]{{playerLabel, enemyLabel, healthLabel, guessLabel, gameOverLabel},chars};
        }
        private Font mmFont;

        void resetComponents(){
            for (int x = 0; x < 26; x++) {
                chars[x].setVisible(true);
            }
                guessLabel.setText(null);
            }

        void initComponents() {
            try {
                mmFont = Font.createFont(Font.TRUETYPE_FONT, new File("out/production/MegamanRush/fonts/megaman_2.ttf")).deriveFont(20f);
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("out/production/MegamanRush/fonts/megaman_2.ttf")));
            } catch (IOException | FontFormatException e) {
                e.printStackTrace();
            }

            //======== frame ========
            {
                frame.setResizable(false);
                frame.setFocusable(false);
                Container frameContentPane = frame.getContentPane();
                //======== layerPane ========
                {
                    //---- gameOverLabel ----
                    gameOverLabel.setText("GAME OVER");
                    gameOverLabel.setFont(mmFont);
                    gameOverLabel.setHorizontalAlignment(SwingConstants.CENTER);
                    gameOverLabel.setForeground(new Color(204, 204, 204));
                    gameOverLabel.setVisible(false);
                    layerPane.add(gameOverLabel, JLayeredPane.DEFAULT_LAYER);
                    gameOverLabel.setBounds(475, 170, 305, 45);

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
                    healthLabel.setIcon(new ImageIcon(getClass().getResource("/img/health_10.png")));
                    layerPane.add(healthLabel, JLayeredPane.DEFAULT_LAYER);
                    healthLabel.setBounds(20, 20, 56, 200);
                    healthLabel.setFocusable(false);

                    //---- playerLabel ----
                    playerLabel.setIcon(new ImageIcon(getClass().getResource("/img/player_idle.png")));
                    playerLabel.setHorizontalAlignment(SwingConstants.CENTER);
                    layerPane.add(playerLabel, JLayeredPane.DEFAULT_LAYER);
                    playerLabel.setBounds(275, 300, 108, 112);
                    playerLabel.setFocusable(false);

                    //---- enemyLabel ----
                    enemyLabel.setIcon(new ImageIcon(getClass().getResource("/img/enemy_idle.png")));
                    enemyLabel.setHorizontalAlignment(SwingConstants.CENTER);
                    layerPane.add(enemyLabel, JLayeredPane.DEFAULT_LAYER);
                    enemyLabel.setBounds(800, 320, 84, 92);
                    enemyLabel.setFocusable(false);

                    //---- background ----
                    background.setIcon(new ImageIcon(getClass().getResource("/img/background.png")));
                    layerPane.add(background, JLayeredPane.DEFAULT_LAYER);
                    background.setBounds(0, 0, 1260, 550);
                    background.setFocusable(false);

                    //---- guessLabel ----
                    guessLabel.setFont(mmFont);
                    guessLabel.setHorizontalAlignment(SwingConstants.CENTER);
                    layerPane.add(guessLabel, JLayeredPane.DEFAULT_LAYER);
                    guessLabel.setBounds(570, 585, 675, 31);
                    guessLabel.setText("test");
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
                frame.setLocationRelativeTo(frame.getOwner());
            }
            frame.setVisible(true);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }

    private JFrame frame = new JFrame();
        private JLayeredPane layerPane = new JLayeredPane();
            private JPanel charPanel = new JPanel();
                private JLabel[] chars = new JLabel[26];
            private JLabel background = new JLabel();
            private JLabel healthLabel = new JLabel();
            private JLabel playerLabel = new JLabel();
            private JLabel enemyLabel = new JLabel();
            private JLabel guessLabel = new JLabel();
            private JLabel gameOverLabel = new JLabel();


}



