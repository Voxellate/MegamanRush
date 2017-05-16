package io.voxellate.github;
import javax.swing.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Stream;

class wordHandler {

    String[] wordList;
    static String selectedWord;
    static StringBuilder censoredWord = new StringBuilder();
    static JLabel wordLabel;
    static boolean b;

    String wordSelect() {
        selectedWord = null;
        try (Stream<String> stream = Files.lines(Paths.get(getClass().getResource("files/wordList.txt").toURI()))) {
            wordList = stream.toArray(String[]::new);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        selectedWord = wordList[new Random().nextInt(wordList.length)];
        System.out.println(selectedWord);
        return selectedWord;
    }

    void wordCensor(JLabel label) {
        censoredWord = new StringBuilder();
        wordLabel = label;
        for (int i = 0; i < selectedWord.length(); i++) {
            String s = selectedWord.substring(i, i + 1);
            if (s.equals(" ") || s.equals(",")) {
                censoredWord.append(s);
            } else {
                censoredWord.append("_");
            }
        }
        wordLabel.setText(censoredWord.toString());
    }

    static boolean wordCompare(char a) {
        b = false;
        String l = String.valueOf(a);
        for (int i = 0; i < selectedWord.length(); i++) {
            String s = selectedWord.substring(i, i + 1);
            if (s.equals(l)) {
                censoredWord.replace(i, i + 1, s);
                b = true;
            }
        }
        wordLabel.setText(censoredWord.toString());
        return b;
    }

    static boolean wordCheck(){
        return Objects.equals(censoredWord.toString(), selectedWord);
    }
}

