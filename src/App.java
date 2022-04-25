import java.util.ArrayList;
import java.util.HashMap;

/**
 * Aquesta es la Classe principal, on fem crides a les diferents funcions de les altres classes per dur a terme
 * l'algoritme MapReduce
 *
 * @author Joaquim Codina (1566940) i Marc Cives (1563480)
 *
 */
public class App
{
    public static void main(String[] args) {

        for (String file : args) {
            Entry entry = new Entry(file);
            entry.guardarLinias();
            ArrayList<String> llista = entry.getLines();

            Split split = new Split();
            llista = split.generatesplitWord(llista);

            Map map = new Map();
            ArrayList<String> characterList = map.splitCharacter(llista);

            Shuffle shuffle = new Shuffle();
            HashMap<String, ArrayList<Integer>> hashMap = shuffle.generarShuffling(characterList);

            Reduce reduce = new Reduce();
            hashMap = reduce.generarReducing(hashMap);

            Result result = new Result();
            int len = result.getLengthList(llista);
            result.mostrarPercentatgeCaracter(hashMap, len, file);
        }
    }
}
