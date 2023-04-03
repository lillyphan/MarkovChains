import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MarkovChains<Key, Value> {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner s = new Scanner(System.in);
        String fileName;
        Scanner f;
        File file;
        Random r = new Random();
        HashMap<String, ArrayList<String>> hm = new HashMap();
        String[] words;
        ArrayList<String> beginners = new ArrayList<>();
        fill(beginners);
        ArrayList<String> end = new ArrayList<>();
        end.add(".");
        end.add("!");

        System.out.println("Enter file name: ");
        fileName = s.nextLine();
        file = deletePunct(fileName);
        f = new Scanner(file);
        while (f.hasNextLine()){
            words = f.nextLine().split(" ");
            for (int i = 0; i < words.length - 1; i++){
                if (!hm.containsKey(words[i])) {
                    hm.put(words[i], new ArrayList<String>());
                }
                hm.get(words[i]).add(words[i + 1]);
            }
        }

        System.out.println(Arrays.asList(hm));

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

    private static File deletePunct(String file) throws FileNotFoundException, IOException{
        File newFile = new File("nf.txt");
        newFile.createNewFile();
        Scanner newScanner = new Scanner(newFile);
        Scanner oldScanner = new Scanner(new File(file));
        FileWriter fw = new FileWriter("nf.txt");
        while (oldScanner.hasNextLine()){
//            System.out.println(oldScanner.nextLine());
            String s = oldScanner.nextLine().replaceAll("'", "3").replaceAll("-", "4");
            String s2 = s.replaceAll("\\p{Punct}", "");
//            fw.write(s);
            fw.write(s2.replaceAll("3", "'").replaceAll("4", "-"));
            fw.write("\n");
        }
        fw.close();
        return newFile;
    }

    private static void fill(ArrayList<String> array){
        array.add("She");
        array.add("I");
        array.add("The");
        array.add("A");
        array.add("She");
        array.add("Their");
        array.add("We");
        array.add("When");
        array.add("There");
        array.add("And");
        array.add("They");
        array.add("All");
        array.add("He");
        array.add("His");
        array.add("It");
        array.add("My");
        array.add("In");
        array.add("At");
    }
}
