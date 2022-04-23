import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Map {
    private int numElementsMap;
    HashMap<String, ArrayList<Integer>> hashMap = new LinkedHashMap<>();

    public void generarHashMap(ArrayList<String> llista) {
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

            for(int i=0; i<temp.length; i++){
                if(!temp[i].equalsIgnoreCase("") && !hashMap.containsKey(temp[i])){
                    ArrayList<Integer> valuesList = hashMap.get(temp[i]);
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
    }

    public int getNumElementsMap() {
        return numElementsMap;
    }
    public void setNumElementsMap(int x) {
        numElementsMap = x;
    }
    public HashMap<String, ArrayList<Integer>> getHashMap() { return hashMap; }

}
