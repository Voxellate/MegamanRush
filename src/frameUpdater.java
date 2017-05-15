import java.awt.event.*;
import javax.swing.*;

class frameUpdater {

    static void animate(JLabel label, String sprite, String state, int delay) {
        String image1 = "/img/" + sprite + "_" + state + ".png";
        String image2 = "/img/" + sprite + "_idle.png";
        label.setIcon(new ImageIcon(frameUpdater.class.getResource(image1)));
        ActionListener task = evt -> label.setIcon(new ImageIcon(frameUpdater.class.getResource(image2)));
        Timer timer = new Timer(delay, task);
        timer.setRepeats(false);
        timer.start();
    }

    static void change(JLabel label, String sprite, String state){
        String image1 = "/img/" + sprite + "_" + state + ".png";
        label.setIcon(new ImageIcon(frameUpdater.class.getResource(image1)));
    }
}