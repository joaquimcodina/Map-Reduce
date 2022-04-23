import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Shuffle {
    HashMap<String, ArrayList<Integer>> hashMap = new LinkedHashMap<>();

    public HashMap<String, ArrayList<Integer>> generarShuffling(ArrayList<String> llista) {
        for (String s : llista) {
            String[] temp = s.toLowerCase()
                    .replace(" ", "")
                    .replace(".", "")
                    .replace(";", "")
                    .replace("'","")
                    .replace("-", "")
                    .replace(":", "")
                    .replace("[", "")
                    .replace("]","")
                    .split(",");

            for (int i = 0; i < temp.length; i++) {
                ArrayList<Integer> valuesList = hashMap.get(temp[i]);
                if (!temp[i].equalsIgnoreCase("")) {
                    if(valuesList == null) {
                        valuesList = new ArrayList<>();
                        valuesList.add(1);
                    } else {
                        valuesList.add(1);
                    }
                    hashMap.put(temp[i], valuesList);
                }
            }
        }
        return hashMap;
    }
}
