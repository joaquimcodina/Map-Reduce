import java.util.ArrayList;
import java.util.HashMap;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main(String[] args) {
        for (String file : args) {
            Entry entry = new Entry(file);
            entry.guardarLinias();
            ArrayList<String> llista = entry.getLines();
            ArrayList<String> llistalLength = entry.getLines();

            Split split = new Split();
            split.actualitzarLista(llista);
            llista = split.getArrayCharacters();

            Map map = new Map();
            map.generarHashMap(llista);

            Shuffle shuffle = new Shuffle();
            HashMap<String, ArrayList<Integer>> hashMap = shuffle.generarShuffling(llista);

            Reduce reduce = new Reduce();
            hashMap = reduce.generarReducing(hashMap);

            Result result = new Result();
            int len = result.getLengthList(llistalLength);
            result.mostrarPercentatgeCaracter(hashMap, len, file);
        }
    }
}
