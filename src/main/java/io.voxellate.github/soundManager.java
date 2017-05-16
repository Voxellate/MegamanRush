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
import java.util.Objects;

public class soundManager {

    private Clip bgMusic;

    void playSound(String sprite, String state, boolean loop) {


        try {
            File soundFile = new File(getClass().getResource("sounds/"+ sprite + "_" + state +".wav").toURI());
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream( soundFile );
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            if (loop) {clip.loop(-1);}
            clip.start();
        } catch (LineUnavailableException | IOException | URISyntaxException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }
}
