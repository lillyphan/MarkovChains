/**
 * MarkovChains - class that utilizes creates a chain trained on a text file and outputs a String
 * imitating the diction of the file
 * Author: Lilly Phan
 * Date (last edited): 04/6/2023
 **/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MarkovChains<Key, Value> {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        //initializations and declarations
        Scanner s = new Scanner(System.in);
        String fileName;
        Scanner f;
        File file;
        Random r = new Random();
        HashMap<String, ArrayList<String>> hm = new HashMap();
        String[] words;
        ArrayList<String> beginners = new ArrayList<>(); //ArrayList of sentence starters
        ArrayList<String> endWords = new ArrayList<>(); //ArrayList of sentence enders
        fill(beginners); //fill beginners with words commonly used to start sentences

        System.out.println("Enter file name: ");
        fileName = s.nextLine(); //store file name
        file = deletePunct(fileName);
        f = new Scanner(file);
        while (f.hasNextLine()){ //read file and hash words into a Java HashMap
            words = f.nextLine().split(" "); //split each line into words separated by spaces
//            endWords.add(words[(words.length) - 1]);
//            hm.put(words[(words.length) - 1] + ".", new ArrayList<String>());
            for (int i = 0; i < words.length - 1; i++){
                if (!hm.containsKey(words[i])) {
                    if ((words[i].charAt(words[i].length()-1) == '.')) {
                        endWords.add(words[i]);
                    }
                    hm.put(words[i], new ArrayList<String>());
                }
                if (!Character.isUpperCase(words[i + 1].charAt(0)) || !(words[i + 1].charAt(0) == 'I')){
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
            if (endWords.contains(currWord)){
                int random = r.nextInt(beginners.size());
                YAY = YAY.concat(" " + beginners.get(random));
                currWord = beginners.get(random);
            } else if (hm.get(currWord) == null || hm.get(currWord).isEmpty()){
                int random = r.nextInt(beginners.size());
                if (currWord.charAt(currWord.length()-1) != '.'){
                    YAY = YAY.concat(".");
                }
                YAY = YAY.concat(" " + beginners.get(random));
                currWord = beginners.get(random);
            } else {
                int random = r.nextInt(hm.get(currWord).size());
                while (beginners.contains(hm.get(currWord).get(random))){
                    random = r.nextInt(hm.get(currWord).size());
                }
                YAY = YAY + " " + hm.get(currWord).get(random);
                currWord = hm.get(currWord).get(random);
            }
        }
        if (YAY.charAt(YAY.length()-1) != '.'){
            YAY = YAY.concat(".");
        }

        System.out.println(YAY);
    }

    private static File deletePunct(String file) throws FileNotFoundException, IOException{
        File newFile = new File("nf.txt");
        newFile.createNewFile();
        Scanner newScanner = new Scanner(newFile);
        Scanner oldScanner = new Scanner(new File(file));
        FileWriter fw = new FileWriter("nf.txt");
        while (oldScanner.hasNextLine()){
            String s = oldScanner.nextLine().replaceAll("'", "3").replaceAll("-", "4").replaceAll("[.]", "5");
            String s2 = s.replaceAll("\\p{Punct}", "");
            fw.write(s2.replaceAll("3", "'").replaceAll("4", "-").replaceAll("5", "."));
            fw.write("\n");
        }
        fw.close();
        return newFile;
    }

    private static void fill(ArrayList<String> array){
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
    }
}
