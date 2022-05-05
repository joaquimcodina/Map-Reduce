import java.io.File;
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
     * Aquesta es la funció mostrarPercentatgeCaracter(), bàsicament mostra el resultat obtingut per pantalla.
     *
     * @param reduceThreads HashMap on tenim emmagatzemat els caracters amb el seu nombre d'aparicions en el fitxer de text.
     * @param len Mida del fitxer de text (per paraules).
     * @param file Nom del fitxer de text.
     *
     */
    public void mostrarPercentatgeCaracter(ArrayList<Reduce> reduceThreads, int len, String file){
        DecimalFormat df = new DecimalFormat("0.00");
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (Reduce reduce : reduceThreads) {
            for (String key : reduce.getHashMap().keySet()) {
                hashMap.put(key, reduce.getHashMap().get(key));
            }
        }

        File fitxer = new File(file);
        System.out.println(fitxer.getName() + ":");
        for (String key : hashMap.keySet()) {
            System.out.println(key + " : " + df.format((Double.valueOf(hashMap.get(key)) / len) * 100) + "%");
        }
        System.out.println("\n");

        for(Reduce reduce : reduceThreads){
            for(String caracter : reduce.llistaCaracters){
                File fileCaracter = new File("key_"+caracter+".txt");
                fileCaracter.delete();
                for(String valueCaracter : reduce.llistaCaracters) {
                    File fileValueCaracter = new File("value_"+valueCaracter+".txt");
                    fileValueCaracter.delete();
                }
            }
        }
    }
}
