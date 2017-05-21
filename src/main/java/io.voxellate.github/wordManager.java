package io.voxellate.github;

import javax.swing.*;
import java.util.*;

class wordManager {

    String selectedWord;
    private static StringBuilder censoredWord = new StringBuilder();    //Creates a new StringBuilder to contain the censored word
    private static JLabel wordLabel;

    wordManager (JLabel label) {    //Constructor for class
        selectedWord = null;
        Scanner sc = new Scanner(getClass().getResourceAsStream("files/wordList.txt"));     //Receives the contents of the file as an input stream and parses it using a Scanner
        List<String> lines = new ArrayList<>();     //Creates a List of strings
        while (sc.hasNextLine()) {      //Loop through each item in the file scanner
            lines.add(sc.nextLine());   //Add the line to the List as a new element
        }
        String[] wordList = lines.toArray(new String[0]);   //Convert the list to an array
        selectedWord = wordList[new Random().nextInt(wordList.length)]; //Pick a random array element to be the word to guess
        System.out.println(selectedWord);   //Print that word to the console for debugging

        censoredWord = new StringBuilder(); //Create a new string builder, which allows for easy manipulation of strings
        wordLabel = label;  //Make label an attribute so it may be accessed by other methods
        for (int i = 0; i < selectedWord.length(); i++) {   //Loop through each character in the selected word
            String s = selectedWord.substring(i, i + 1);    //Equal s to a character in the selected word
            if (s.equals(" ") || s.equals(",")) {   //If that character is a space or a comma...
                censoredWord.append(s);     //append that character to censored word
            } else {    //Otherwise...
                censoredWord.append("_");   //add an underscore to the censored word
            }
        }
        wordLabel.setText(censoredWord.toString());     //Set the word label to equal the censored word
    }

    boolean wordCompare(char a) {   //Compares the guessed letter to the letters in the word to guess
        boolean b = false;  //set boolean b to false, which means that the letter was not found in the word
        String l = String.valueOf(a);   //Change a from a char to a string
        for (int i = 0; i < selectedWord.length(); i++) {   //For each character in the selected word
            String s = selectedWord.substring(i, i + 1);    //Equal s to a character in the selected word
            if (s.equals(l)) {      //If the character equals the selected letter...
                censoredWord.replace(i, i + 1, s);  //Replaced the corresponding underscores with the letter in the censored word
                b = true;
            }
        }
        wordLabel.setText(censoredWord.toString());     //Set the word label to equal the new censored word
        return b;
    }

    boolean wordCheck(){
        return Objects.equals(censoredWord.toString(), selectedWord);   //Return true if the censored word equals the selected word
    }
}

