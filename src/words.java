import javax.swing.*;
import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

class words {

    String[] wordList;
    String selectedWord;
    String censoredWord;

    String wordSelect(){
        try (Stream<String> stream = Files.lines(Paths.get("out/production/MegamanRush/wordList.txt"))) {
            //stream.forEach(System.out::println);
            wordList = stream.toArray(String[]::new);
        } catch (IOException e) {
            e.printStackTrace();
        }
        selectedWord = wordList[(int) (Math.random() * wordList.length)];
        System.out.println(selectedWord);
        return selectedWord;
    }

    void wordCensor(JLabel label) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < selectedWord.length(); i++) {
            String s = selectedWord.substring(i, i + 1);
            if (s.equals(" ") || s.equals(",")) {
                builder.append(s);
            } else {
                builder.append("_");
            }
        }
        censoredWord = builder.toString();
        label.setText(censoredWord);
    }

    /*void wordCompare(String a){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < selectedWord.length(); i++) {
            String s = selectedWord.substring(i, i + 1);
            if (s.equals(a)) {
                builder.append(censoredWord.charAt(i));
            } else {

            }
        }*/
}


