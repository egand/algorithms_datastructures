package editdistance.usage;


import editdistance.EditDistance;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class EditDistanceUsage {

    public static void main(String[] args) throws Exception {

        if(args.length < 2) throw new Exception("Usage: java EditDistanceUsage <data_file_path> <dictionary_file_path>\n");
        HashSet<String> data= null;
        ArrayList<String> dictionary = null;

        try {
            System.out.println("Loading data from " + args[0]);
            data = loadDataFromFile(args[0]);
            System.out.println("Data loaded successfully\nLoading dictionary from " + args[1]);
            dictionary = loadDictionaryFromFile(args[1]);
            System.out.println("Dictionary loaded successfully");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        findMinEditDistWords(data, dictionary);


    }

    private static HashSet<String> loadDataFromFile(String filepath) throws IOException {
        HashSet<String> set = new HashSet<>();
        try(Scanner reader = new Scanner(new File(filepath)).useDelimiter("\\W*\\s+")) {
            while(reader.hasNext()) {
                set.add(reader.next());
            }
        }
        return set;
    }

    private static ArrayList<String> loadDictionaryFromFile(String filepath) throws IOException {
        ArrayList<String> arrayList = new ArrayList<>(661562);
        try(BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while((line = br.readLine()) != null) {
                arrayList.add(line);
            }
        }
        return arrayList;
    }

    private static void findMinEditDistWords(HashSet<String> data, ArrayList<String> dictionary) {
        for(String word : data) {
            ArrayList<String> minEditDistWords = new ArrayList<>();
            int editDistMin = Integer.MAX_VALUE;
            int editDist;
            long start = System.nanoTime();
            for(String dictWord : dictionary) {
                if(editDistMin == 0) break;
                editDist = EditDistance.editDistanceDyn(word, dictWord);

                if(editDist < editDistMin) {
                    editDistMin = editDist;
                    minEditDistWords.clear();
                    minEditDistWords.add(dictWord);
                }
                else if(editDist == editDistMin) minEditDistWords.add(dictWord);
            }
            long end = System.nanoTime();
            System.out.println("Time taken: " + (double)(end - start)/1000000000.0 + "s");
            System.out.println("Word : " + word + "\nMinimum Edit Distance: " + editDistMin + "\nWords at editDistance " + editDistMin + ":\n" + String.join(", ", minEditDistWords) + "\n");
        }
    }
}
