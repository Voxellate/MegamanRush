import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/*
 * Created by JFormDesigner on Fri May 12 08:54:00 AEST 2017
 */



/**
 * @author Lucas Dugdale
 */
public class window {
    public window() {
        initComponents();
        frame.setVisible(true);
    } 

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Lucas Dugdale
        frame = new JFrame();
        layerPane = new JLayeredPane();
        player = new JLabel();
        enemy = new JLabel();
        background = new JLabel();

        //======== frame ========
        {
            frame.setResizable(false);
            Container frameContentPane = frame.getContentPane();

            //======== layerPane ========
            {

                //---- player ----
                player.setIcon(new ImageIcon(getClass().getResource("/img/MM_Idle.png")));
                layerPane.add(player, JLayeredPane.DEFAULT_LAYER);
                player.setBounds(275, 360, 76, 96);

                //---- enemy ----
                enemy.setIcon(new ImageIcon(getClass().getResource("/img/Enemy.png")));
                layerPane.add(enemy, JLayeredPane.DEFAULT_LAYER);
                enemy.setBounds(815, 380, 68, 76);

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
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Lucas Dugdale
    private JFrame frame;
    private JLayeredPane layerPane;
    private JLabel player;
    private JLabel enemy;
    private JLabel background;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
