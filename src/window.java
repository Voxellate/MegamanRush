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
        layeredPane1 = new JLayeredPane();
        label2 = new JLabel();

        //======== frame ========
        {
            frame.setResizable(false);
            Container frameContentPane = frame.getContentPane();

            //======== layeredPane1 ========
            {

                //---- label2 ----
                label2.setIcon(new ImageIcon(getClass().getResource("/img/background.png")));
                layeredPane1.add(label2, JLayeredPane.DEFAULT_LAYER);
                label2.setBounds(0, 0, 1275, 665);
            }

            GroupLayout frameContentPaneLayout = new GroupLayout(frameContentPane);
            frameContentPane.setLayout(frameContentPaneLayout);
            frameContentPaneLayout.setHorizontalGroup(
                frameContentPaneLayout.createParallelGroup()
                    .addGroup(frameContentPaneLayout.createSequentialGroup()
                        .addComponent(layeredPane1, GroupLayout.DEFAULT_SIZE, 1276, Short.MAX_VALUE)
                        .addContainerGap())
            );
            frameContentPaneLayout.setVerticalGroup(
                frameContentPaneLayout.createParallelGroup()
                    .addGroup(frameContentPaneLayout.createSequentialGroup()
                        .addComponent(layeredPane1, GroupLayout.PREFERRED_SIZE, 720, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
            );
            frame.setSize(1022, 562);
            frame.setLocationRelativeTo(frame.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Lucas Dugdale
    private JFrame frame;
    private JLayeredPane layeredPane1;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
