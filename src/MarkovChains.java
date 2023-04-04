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
        ArrayList<String> endPunc = new ArrayList<>();
        endPunc.add(".");
        endPunc.add("!");
        ArrayList<String> endWords = new ArrayList<>();

        System.out.println("Enter file name: ");
        fileName = s.nextLine();
        file = deletePunct(fileName);
        f = new Scanner(file);
        while (f.hasNextLine()){
            words = f.nextLine().split(" ");
            for (int i = 0; i < words.length - 1; i++){
                if (!hm.containsKey(words[i])) {
                    hm.put(words[i], new ArrayList<String>());
                } else if (!(words[i + 1].charAt(0) >= 65 && words[i + 1].charAt(0) <= 90)) {
                    hm.get(words[i]).add(words[i + 1]);
                }
            }
        }

        System.out.println("Enter in the number of words you would like to generate: ");
        int numWords = s.nextInt();

        String YAY = "";
        YAY = YAY.concat(beginners.get(r.nextInt(beginners.size())));
        String currWord = YAY.substring(0, YAY.length());

        for (int i = 0; i < numWords - 1; i++){
            if (hm.get(currWord) == null || hm.get(currWord).isEmpty()){
                int random = r.nextInt(beginners.size());
                YAY = YAY.concat(endPunc.get(r.nextInt(2)) + "\n");
                YAY = YAY.concat(" " + beginners.get(random));
                currWord = beginners.get(random);
            }
            System.out.println(hm.get(currWord).size());
            int random = r.nextInt(hm.get(currWord).size());
            YAY = YAY + " " + hm.get(currWord).get(random);
            currWord = hm.get(currWord).get(random);
        }

        YAY = YAY.concat(endPunc.get(r.nextInt(2)));

        System.out.println(YAY);

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
            String s = oldScanner.nextLine().replaceAll("'", "3").replaceAll("-", "4");
            String s2 = s.replaceAll("\\p{Punct}", "");
            fw.write(s2.replaceAll("3", "'").replaceAll("4", "-"));
            fw.write("\n");
        }
        fw.close();
        return newFile;
    }

    private static void fill(ArrayList<String> array){
//        if (beginner){
            array.add("She");
            array.add("I");
            array.add("The");
            array.add("She");
            array.add("When");
            array.add("And");
            array.add("They");
            array.add("All");
            array.add("He");
            array.add("It");
            array.add("My");
            array.add("In");
            array.add("There");
            array.add("This");
//        }
    }
}
