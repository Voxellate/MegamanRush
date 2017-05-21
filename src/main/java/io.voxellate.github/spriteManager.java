package io.voxellate.github;
import java.awt.event.*;
import javax.swing.*;

class spriteManager {

    void animate(JLabel label, String sprite, String state, int delay) {    //Animates a JLabel
        String image1 = "img/" + sprite + "_" + state + ".png"; //Creates a path to an image from given variables
        String image2 = "img/" + sprite + "_idle.png";
        label.setIcon(new ImageIcon(this.getClass().getResource(image1)));  //Sets the icon from the given path
        ActionListener task = evt -> {  //Creates a task
            label.setIcon(new ImageIcon(this.getClass().getResource(image2)));
            gameController.ready = true;    //Allow the gameController to accept another input
        };
        Timer timer = new Timer(delay, task);   //Creates a new timer that executes the task after a delay
        timer.setRepeats(false);    //Fire the timer once
        timer.start();  //Starts the timer
    }

    void change(JLabel label, String sprite, String state){
        String image1 = "img/" + sprite + "_" + state + ".png";
        label.setIcon(new ImageIcon(this.getClass().getResource(image1)));
    }
}
