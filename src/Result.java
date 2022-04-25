import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Aquesta es la Classe Result, on mostra per pantalla els resultats obtinguts.
 *
 * @author Joaquim Codina (1566940) i Marc Cives (1563480)
 *
 */
public class Result {

    /**
     * Aquesta es la funció getLengthList(), consisteix obtenir la mida del fitxer de text (per paraules).
     *
     * @param llistaLength ArrayList on tenim emmagatzemat el contingut del fitxer de text.
     * @return length, mida per paraules del ArrayList.
     *
     */
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

    /**
     * Aquesta es la funció mostrarPercentatgeCaracter(), bàsicament mostra el resultat obtingut per pantalla.
     *
     * @param hashMap HashMap on tenim emmagatzemat els caracters amb el seu nombre d'aparicions en el fitxer de text.
     * @param len Mida del fitxer de text (per paraules).
     * @param file Nom del fitxer de text.
     *
     */
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
