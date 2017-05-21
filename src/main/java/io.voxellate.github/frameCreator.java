package io.voxellate.github;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

class frameCreator {
    void resetComponents() {        // Called to reset the components for a new level / word
        for (JLabel x : chars) {    //For each element in chars[]...
            x.setVisible(true);     //Make the element visible
        }
        guessLabel.setText(null);   //wipe the guessLabel text
    }

    frameCreator() {    //Called when frameCreator is instantiated
        try {   //Attempt to execute this code...
            mmFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("fonts/megaman_2.ttf")); //Create a font from this file
            mmFont = mmFont.deriveFont(22f);    //Make the font size 22
        } catch (IOException | FontFormatException e) { //If the program encounters one of these errors...
            e.printStackTrace();    //print the stack trace to the console for debugging
        }


        //===== frame =====
        frame = new JFrame();   //Create a new JFrame
        {
            frame.setResizable(false);  //Makes the frame non-resizeable
            frame.setFocusable(false);  //Makes the fram non-focusable
            Container frameContentPane = frame.getContentPane();    //Makes the content pane its own variable
            //===== layerPane =====
            JLayeredPane layerPane = new JLayeredPane();    //Creates a new JLayeredPane
            {
                //----- notifyLabel -----
                notifyLabel = new JLabel();     //Creates a new JLabel
                notifyLabel.setFont(mmFont);    //Sets the font of the label
                notifyLabel.setText("USE BUTTONS OR KEYBOARD TO GUESS THE WORD!");  //Sets the text of the label
                notifyLabel.setHorizontalAlignment(SwingConstants.CENTER);     //Centers the text
                notifyLabel.setForeground(new Color(204, 204, 204));    //Sets the colour of the text
                notifyLabel.setVisible(true);   //Makes the label visible
                layerPane.add(notifyLabel, JLayeredPane.DEFAULT_LAYER); //adds the label to the JLayeredPane
                notifyLabel.setBounds(125, 170, 1000, 45);  //Sets the size and location of the label

                //----- restartLabel -----
                restartLabel = new JLabel();
                restartLabel.setText("CLICK TO RESTART");
                restartLabel.setFont(mmFont);
                restartLabel.setHorizontalAlignment(SwingConstants.CENTER);
                restartLabel.setForeground(new Color(204, 204, 204));
                restartLabel.setVisible(false);
                layerPane.add(restartLabel, JLayeredPane.DEFAULT_LAYER);
                restartLabel.setBounds(420, 220, 400, 45);

                //===== charPanel =====
                JPanel charPanel = new JPanel();
                charPanel.setLayout(new GridLayout(2, 0, 10, 10));  //Sets the layout of the JPanel
                {
                    chars = new JLabel[26]; //Creates a new array of JLabels
                    for (int x = 0; x < 26; x++) {  //For each element in the array
                        char y = ((char) (x + 65)); //Add 65 to x and cast it as a char
                        chars[x] = new JLabel();
                        chars[x].setText(String.valueOf(y));    //Set text to the String value of y
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

                //----- healthLabel -----
                healthLabel = new JLabel();
                healthLabel.setIcon(new ImageIcon(getClass().getResource("img/health_10.png")));    //Set the icon of the JLabel
                layerPane.add(healthLabel, JLayeredPane.DEFAULT_LAYER);
                healthLabel.setBounds(20, 20, 56, 200);
                healthLabel.setFocusable(false);

                //----- scoreLabel -----
                scoreLabel = new JLabel();
                scoreLabel.setText("0");
                scoreLabel.setFont(mmFont);
                scoreLabel.setHorizontalAlignment(SwingConstants.LEFT);
                scoreLabel.setForeground(new Color(204, 204, 204));
                scoreLabel.setVisible(true);
                layerPane.add(scoreLabel, JLayeredPane.DEFAULT_LAYER);
                scoreLabel.setBounds(1020, 19, 200, 60);

                //----- scorebgLabel
                JLabel scorebgLabel = new JLabel();
                scorebgLabel.setIcon(new ImageIcon(getClass().getResource("img/score.png")));
                layerPane.add(scorebgLabel, JLayeredPane.DEFAULT_LAYER);
                scorebgLabel.setBounds(820, 20, 400, 60);
                scorebgLabel.setFocusable(false);

                //----- playerLabel -----
                playerLabel = new JLabel();
                playerLabel.setIcon(new ImageIcon(getClass().getResource("img/player_idle.png")));
                playerLabel.setHorizontalAlignment(SwingConstants.CENTER);
                layerPane.add(playerLabel, JLayeredPane.DEFAULT_LAYER);
                playerLabel.setBounds(275, 300, 116, 112);
                playerLabel.setFocusable(false);

                //----- enemyLabel -----
                enemyLabel = new JLabel();
                enemyLabel.setIcon(new ImageIcon(getClass().getResource("img/enemy_idle.png")));
                enemyLabel.setHorizontalAlignment(SwingConstants.CENTER);
                layerPane.add(enemyLabel, JLayeredPane.DEFAULT_LAYER);
                enemyLabel.setBounds(800, 320, 84, 92);
                enemyLabel.setFocusable(false);

                //----- background -----
                JLabel background = new JLabel();
                background.setIcon(new ImageIcon(getClass().getResource("img/background.png")));
                layerPane.add(background, JLayeredPane.DEFAULT_LAYER);
                background.setBounds(0, 0, 1260, 550);
                background.setFocusable(false);

                //----- guessLabel -----
                guessLabel = new JLabel();
                guessLabel.setFont(mmFont);
                guessLabel.setHorizontalAlignment(SwingConstants.CENTER);
                layerPane.add(guessLabel, JLayeredPane.DEFAULT_LAYER);
                guessLabel.setBounds(570, 585, 675, 31);
                guessLabel.setText("Loading...");
                guessLabel.setFocusable(true);
            }

            //This block of code sets the JFrame's layout
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
            frame.setTitle("Mega Man Rush");    //Sets the Title of the window
            frame.setLocationRelativeTo(frame.getOwner());  //Centres the window on the screen
        }
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  //Exits the program when the window is closed
    }

    String dialog(){    //Creates a dialog to get the user's name
        return JOptionPane.showInputDialog( //Create a dialog
                frame,
                "What is your name?",
                "Mega Man Rush",
                JOptionPane.PLAIN_MESSAGE);
    }

    //Defines the attributes of the object
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



