import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class Result {
    public int getLengthList(ArrayList<String> llistaLength){
        int length=0;
        for (String s : llistaLength) {
            String[] temp = s.toLowerCase()
                    .replace(",", "")
                    .replace(".", "")
                    .replace(";", "")
                    .replace("'","")
                    .replace("-", "")
                    .replace(":", "")
                    .split(" ");

            length += temp.length;
        }
        return length;
    }

    public void mostrarPercentatgeCaracter(HashMap<String, ArrayList<Integer>> hashMap, int len, String file){
        double percentatge=0.0;
        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println(file + ":");

        for (String key : hashMap.keySet()) {
            for (double valors : hashMap.get(key)) {
                percentatge = (valors / len) * 100;
            }
            System.out.println(key + " : " + df.format(percentatge) + "%");
        }
        System.out.println("\n");

    }
}
