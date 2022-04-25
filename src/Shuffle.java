import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Aquesta es la Classe Shuffle
 *
 * @author Joaquim Codina (1566940) i Marc Cives (1563480)
 *
 */
public class Shuffle {

    /**
     * Aquesta es la funció generarShuffling(), bàsicament s'encarrega de generar un HashMap, i a partir d'un bucle
     * buscarà per cada caràcter, el nombre de vegades que apareix en el fitxer de text, en cas de que aparegui, afegim un 1
     * a la ArrayList<Integer> que es troba dins del HashMap, i que més endavant sumarem tot el seu contingut.
     *
     * @param llista on s'emmagatzema el contingut del fitxer de text, el qual hem esborrat els caràcters repetits per paraules,
     *              i l'hem separat per caràcters amb un split.
     *
     * @return hashMap on s'emmagatzema els caràcters del fitxer juntament amb el seu nombre d'aparicions (sense sumar).
     *
     */
    public HashMap<String, ArrayList<Integer>> generarShuffling(ArrayList<String> llista) {
        HashMap<String, ArrayList<Integer>> hashMap = new LinkedHashMap<>();
        for (int i = 0; i < llista.size(); i++) {
            ArrayList<Integer> valuesList = hashMap.get(llista.get(i));
            if (!llista.get(i).equalsIgnoreCase("")) {
                if(valuesList == null) {
                    valuesList = new ArrayList<>();
                    valuesList.add(1);
                } else {
                    valuesList.add(1);
                }
                hashMap.put(llista.get(i), valuesList);
            }
        }
        return hashMap;
    }
}
