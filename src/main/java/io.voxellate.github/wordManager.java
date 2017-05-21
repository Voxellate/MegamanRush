package io.voxellate.github;

import javax.swing.*;
import java.util.*;

class wordManager {

    String selectedWord;
    private static StringBuilder censoredWord = new StringBuilder();
    private static JLabel wordLabel;

    wordManager (JLabel label) {
        selectedWord = null;

        Scanner sc = new Scanner(getClass().getResourceAsStream("files/wordList.txt"));
        List<String> lines = new ArrayList<>();
        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }
        String[] wordList = lines.toArray(new String[0]);
        selectedWord = wordList[new Random().nextInt(wordList.length)];
        System.out.println(selectedWord);

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
        boolean b = false;
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

