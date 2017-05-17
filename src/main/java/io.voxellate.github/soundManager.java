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
            InputStream audioSrc = getClass().getResourceAsStream("sounds/"+ sprite + "_" + state +".wav");
            InputStream bufferedIn = new BufferedInputStream(audioSrc);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            if (loop) {clip.loop(-1);}
            clip.start();
            if (Objects.equals(state, "bgMusic")){bgMusic = clip;}
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

    void stopSound(){
        bgMusic.stop();
    }
}
