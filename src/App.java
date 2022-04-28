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
    public static void main(String[] args) throws InterruptedException {

        for (String file : args) {
            Entry entry = new Entry(file);
            Split split = new Split();
            Map map = new Map();
            Shuffle shuffle = new Shuffle();
            Reduce reduce = new Reduce();
            Result result = new Result();

            entry.guardarLinias();
            ArrayList<String> llista = entry.getLines();

            llista = split.generatesplitWord(llista);

            map.setLlistaAux(llista);
            map.start();
            Thread.sleep(5);

            HashMap<String, ArrayList<Integer>> hashMap = shuffle.generarShuffling(map.splitCharacter(llista));

            reduce.setHashAux(hashMap);
            reduce.start();
            Thread.sleep(3);

            int len = result.getLengthList(llista);
            result.mostrarPercentatgeCaracter(reduce.getHashAux(), len, file);
        }
    }
}
