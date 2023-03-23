import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class MarkovChains<Key, Value> {
    public static void main(String[] args) throws FileNotFoundException {
//        1. Ask the user for a file name. This file should be a text file for the program to train on.
//
//        2. Read in the lines of text from that file and store them in a HashMap/Dictionary with the following format:
//
//        You may also want to store a list of sentence beginnings and sentence endings in addition to the dictionary! This will make sentence creation easier.
//
//        3. Prompt the user for how many words they would like to generate.
//
//        4. Output text from the Markov Chain HashMap/Dictionary by:

//                picking a random starting word
//                continuing to pull words out of the dictionary until you hit the end of a sentence or run out of keys
//                starting again (until you reach the word count requested by the user)

//        5. Implement an extension to the project, as listed below.
    }

    private File deletePunct(String file) throws FileNotFoundException, IOException{
        File newFile = new File("nf.txt");
        Scanner newScanner = new Scanner(newFile);
        Scanner oldScanner = new Scanner(new File(file));
        FileWriter fw = new FileWriter("nf.txt");
        while (oldScanner.hasNextLine()){
            fw.write(oldScanner.nextLine().replaceAll("\\p{Punct}", ""));
            fw.close();
        }
        return newFile;
    }
}
