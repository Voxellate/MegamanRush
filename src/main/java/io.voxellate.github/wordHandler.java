package io.voxellate.github;
import sun.misc.IOUtils;

import javax.swing.*;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Stream;

class wordHandler {

    String[] wordList;
    public String selectedWord;
    static StringBuilder censoredWord = new StringBuilder();
    static JLabel wordLabel;
    static boolean b;

    String wordSelect() {
        selectedWord = null;

        Scanner sc = new Scanner(getClass().getResourceAsStream("files/wordList.txt"));
        List<String> lines = new ArrayList<>();
        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }

        String[] wordList = lines.toArray(new String[0]);
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

    boolean wordCompare(char a) {
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

    boolean wordCheck(){
        return Objects.equals(censoredWord.toString(), selectedWord);
    }
}

