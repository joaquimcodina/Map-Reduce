import java.util.ArrayList;
import java.util.HashMap;

public class Reduce {
    public HashMap<String, ArrayList<Integer>> generarReducing(HashMap<String, ArrayList<Integer>> hashMap){

        for (String key : hashMap.keySet()) {
            Integer suma=0;
            ArrayList<Integer> resultat = hashMap.get(key);
            for (Integer valors : hashMap.get(key)){
                suma += valors;
            }
            resultat.clear();
            resultat.add(suma);
            hashMap.put(key, resultat);
        }
        return hashMap;
    }
}
