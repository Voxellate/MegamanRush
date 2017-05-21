package io.voxellate.github;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

class soundManager {

    private Clip bgMusic;

    void playSound(String sprite, String state, boolean loop) {
        try {
            InputStream audioSrc = getClass().getResourceAsStream("sounds/"+ sprite + "_" + state +".wav");     //Read the audio file requested and store them in an input stream
            InputStream bufferedIn = new BufferedInputStream(audioSrc);     //Buffer the input stream
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn); //Turn the buffered input stream into an audio stream
            Clip clip = AudioSystem.getClip();  //Create a new clip object
            clip.open(audioStream);     //Open the audio stream
            if (loop) {clip.loop(-1);}  //If the gameController requests the clip to be looped, set the clip to loop
            clip.start();   //Play the clip
            if (Objects.equals(state, "bgMusic")){bgMusic = clip;}  //If the music to be played is the background music, store the clip in a local attribute
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {    //If any of these errors are encountered...
            e.printStackTrace();    //Print the stack trace to the console for debugging
        }
    }

    void stopSound(){
        bgMusic.stop();
    }   //Stop the background music
}
