import java.util.ArrayList;
import java.util.Arrays;

/**
 * Aquesta es la Classe Split
 *
 * @author Joaquim Codina (1566940) i Marc Cives (1563480)
 *
 */
public class Split {

    /**
     * Aquesta es la funció generatesplitWord(), que consisteix en separar per paraules el contingut del ArrayList<String>,
     * passat per paràmetre d'entrada.
     *
     * Utilitza un bucle foreach, que s'encarrega de reemplaçar els caràcters especials i a continuació, separar cadascuna de les linies
     * del fitxer en paraules, i ho emmagatzema en un ArrayList<String> anomenat splitWord.
     *
     * @param llista ArrayList on tenim emmagatzemat el contingut del fitxer de text.
     * @return ArrayList del contingut del fitxer de text, separat per paraules.
     *
     */
    public ArrayList<String> generatesplitWord(ArrayList<String> llista) {
        ArrayList<String> splitWord = new ArrayList<>();
        for (String s : llista) {
            String[] temp = s.toLowerCase()
                    .replace(",", "")
                    .replace(".", "")
                    .replace(";", "")
                    .replace("'", "")
                    .replace("-", "")
                    .replace(":", "")
                    .replace("[", "")
                    .replace("]", "")
                    .split(" ");
            splitWord.add(Arrays.toString(temp));
        }
        return splitWord;
    }
}
