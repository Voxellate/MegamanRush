import javax.swing.*;
import java.awt.*;

public class frame {

        JLabel[][] labels() {
            JLabel[][] j = {{playerLabel, enemyLabel, healthLabel},chars};
            return j;
        }

        void initComponents() {
            // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
            // Generated using JFormDesigner Evaluation license - Lucas Dugdale
            frame = new JFrame();
            layerPane = new JLayeredPane();
            charPanel = new JPanel();
            healthLabel = new JLabel();
            playerLabel = new JLabel();
            enemyLabel = new JLabel();
            background = new JLabel();


            //======== frame ========
            {
                frame.setResizable(false);
                Container frameContentPane = frame.getContentPane();

                //======== layerPane ========
                {

                    //======== charPanel ========
                    {
                        charPanel.setLayout(new GridLayout(3, 0, 10, 10));
                        for (int x = 0; x < 26; x++) {
                            char y = ((char) (x + 65));
                            chars[x] = new JLabel();
                            chars[x].setText(String.valueOf(y));
                            chars[x].setFont(new Font("MegaMan 2", Font.PLAIN, 18));
                            chars[x].setHorizontalTextPosition(SwingConstants.CENTER);
                            charPanel.add(chars[x]);
                        }
                    }
                    layerPane.add(charPanel, JLayeredPane.DEFAULT_LAYER);
                    charPanel.setBounds(10, 555, 435, 95);

                    //---- healthLabel ----
                    healthLabel.setIcon(new ImageIcon(getClass().getResource("/img/health_10.png")));
                    layerPane.add(healthLabel, JLayeredPane.DEFAULT_LAYER);
                    healthLabel.setBounds(20, 20, 56, 200);

                    //---- playerLabel ----
                    playerLabel.setIcon(new ImageIcon(getClass().getResource("/img/player_idle.png")));
                    playerLabel.setHorizontalAlignment(SwingConstants.CENTER);
                    layerPane.add(playerLabel, JLayeredPane.DEFAULT_LAYER);
                    playerLabel.setBounds(275, 300, 108, 112);

                    //---- enemyLabel ----
                    enemyLabel.setIcon(new ImageIcon(getClass().getResource("/img/enemy_idle.png")));
                    enemyLabel.setHorizontalAlignment(SwingConstants.CENTER);
                    layerPane.add(enemyLabel, JLayeredPane.DEFAULT_LAYER);
                    enemyLabel.setBounds(800, 320, 84, 92);

                    //---- background ----
                    background.setIcon(new ImageIcon(getClass().getResource("/img/background.png")));
                    layerPane.add(background, JLayeredPane.DEFAULT_LAYER);
                    background.setBounds(0, 0, 1260, 550);
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
            // JFormDesigner - End of component initialization  //GEN-END:initComponents
            frame.setVisible(true);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }



        // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
        // Generated using JFormDesigner Evaluation license - Lucas Dugdale
        private JFrame frame;
        private JLayeredPane layerPane;
        private JPanel charPanel;
        private JLabel[] chars = new JLabel[26];
        private JLabel healthLabel;
        private JLabel playerLabel;
        private JLabel enemyLabel;
        private JLabel background;
        // JFormDesigner - End of variables declaration  //GEN-END:variables
}



