package sorting.usage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Utils {

    public static ArrayList<Long> loadArrayListFromFile(String filepath, int initialCapacity) throws IOException {
        ArrayList<Long> arrayList = new ArrayList<>(initialCapacity);
        try(BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while((line = br.readLine()) != null) {
                arrayList.add(Long.parseLong(line));
            }
        }
        return arrayList;
    }
}
