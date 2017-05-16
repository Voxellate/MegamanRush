package io.voxellate.github;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class soundManager {

    void playSound(String path) {

        try {

            File soundFile = new File(getClass().getResource("sounds/MegaMan.wav").toURI());
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream( soundFile );
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(-1);
            clip.start();//This plays the audio
        } catch (LineUnavailableException | IOException | URISyntaxException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }

            /*
            ClassLoader cl = this.getClass().getClassLoader();
            InputStream failSound = getClass().getResource("").toURI();
            AudioStream as = new AudioStream(failSound);
            AudioPlayer.player.start(as);

            } catch (IOException e2) {
            e2.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }*/


        /*
        File f = new File(soundFile);
        AudioInputStream audioIn;
        Clip clip;
        try {
            audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
            clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }*/


    }
}
