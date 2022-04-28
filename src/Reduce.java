import java.util.ArrayList;
import java.util.HashMap;

/**
 * Aquesta es la Classe Reduce
 *
 * @author Joaquim Codina (1566940) i Marc Cives (1563480)
 *
 */
public class Reduce extends Thread{

    /**
     * Aquesta es la funció generarReducing(), bàsicament s'encarrega d'obtenir el HashMap amb els caràcters i el seu
     * nombre d'aparicions, i fer la suma del nombre d'aparicions de cada caràcter.
     *
     * @param hashMap que hem obtingut de la funció generarShuffling() de la Classe Shuffle, on tenim emmagatzemat
     *               els caràcters amb el seu nombre d'aparicions (sense sumar).
     *
     * @return hashMap on tenim emmagatzemat els caràcters amb el seu nombre d'aparicions dins del fitxer de text.
     *
     */
    private HashMap<String, ArrayList<Integer>> hashAux;
    private HashMap<String, ArrayList<Integer>> hashRetorn;

    Reduce() {
        hashRetorn = new HashMap<>();
    }

    public void run() {
        this.generarReducing(hashAux);
    }

    public void setHashAux(HashMap<String, ArrayList<Integer>> aux) {
        hashAux = aux;
    }

    public HashMap<String, ArrayList<Integer>> getHashAux() {
        return hashRetorn;
    }

    public void generarReducing(HashMap<String, ArrayList<Integer>> hashMap){

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
        hashRetorn = hashMap;
    }
}
