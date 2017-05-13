import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

class window {
    /*public window() {
        initComponents();
        new playerHurt();
    }*/

    private void hurtActionPerformed(ActionEvent e) {
        playerHurt playerHurtIns = new playerHurt();
        playerHurtIns.start();
    }

    static JLabel giveLabel()   {
        return playerLabel;
    }

    void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Lucas Dugdale
        frame = new JFrame();
        layerPane = new JLayeredPane();
        playerLabel = new JLabel();
        enemyLabel = new JLabel();
        hurt = new JButton();
        background = new JLabel();

        //======== frame ========
        {
            frame.setResizable(false);
            Container frameContentPane = frame.getContentPane();

            //======== layerPane ========
            {

                //---- playerLabel ----
                playerLabel.setIcon(new ImageIcon(getClass().getResource("/img/MM_Idle.png")));
                playerLabel.setHorizontalAlignment(SwingConstants.CENTER);
                layerPane.add(playerLabel, JLayeredPane.DEFAULT_LAYER);
                playerLabel.setBounds(260, 355, 112, 112);

                //---- enemyLabel ----
                enemyLabel.setIcon(new ImageIcon(getClass().getResource("/img/Enemy.png")));
                enemyLabel.setHorizontalAlignment(SwingConstants.CENTER);
                layerPane.add(enemyLabel, JLayeredPane.DEFAULT_LAYER);
                enemyLabel.setBounds(790, 370, 112, 100);

                //---- hurt ----
                hurt.setText("hurt");
                hurt.addActionListener(this::hurtActionPerformed);
                layerPane.add(hurt, JLayeredPane.DEFAULT_LAYER);
                hurt.setBounds(new Rectangle(new Point(605, 560), hurt.getPreferredSize()));

                //---- background ----
                background.setIcon(new ImageIcon(getClass().getResource("/img/background.png")));
                layerPane.add(background, JLayeredPane.DEFAULT_LAYER);
                background.setBounds(0, 0, 1260, 665);
            }

            GroupLayout frameContentPaneLayout = new GroupLayout(frameContentPane);
            frameContentPane.setLayout(frameContentPaneLayout);
            frameContentPaneLayout.setHorizontalGroup(
                frameContentPaneLayout.createParallelGroup()
                    .addComponent(layerPane, GroupLayout.DEFAULT_SIZE, 1258, Short.MAX_VALUE)
            );
            frameContentPaneLayout.setVerticalGroup(
                frameContentPaneLayout.createParallelGroup()
                    .addGroup(frameContentPaneLayout.createSequentialGroup()
                        .addComponent(layerPane, GroupLayout.PREFERRED_SIZE, 664, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
            );
            frame.setSize(1260, 690);
            frame.setLocationRelativeTo(frame.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        frame.setVisible(true);
    }



    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Lucas Dugdale
    private JFrame frame;
    private JLayeredPane layerPane;
    private static JLabel playerLabel;
    private JLabel enemyLabel;
    private JButton hurt;
    private JLabel background;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
