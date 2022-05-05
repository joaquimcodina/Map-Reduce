import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Aquesta es la Classe principal, on fem crides a les diferents funcions de les altres classes per dur a terme
 * l'algoritme MapReduce
 *
 * @author Joaquim Codina (1566940) i Marc Cives (1563480)
 *
 */
public class App {
    public static void main(String[] args) throws InterruptedException, FileNotFoundException {

        long inicio = System.currentTimeMillis();
        for (String file : args) {
            ArrayList<String> llistaFitxers = new ArrayList<>();
            ArrayList<Map> mapThreads = new ArrayList<>();
            ArrayList<Shuffle> shuffleThreads = new ArrayList<>();
            ArrayList<Reduce> reduceThreads = new ArrayList<>();
            Entry entry = new Entry();
            //Shuffle shuffle = new Shuffle();
            Split split = new Split();
            Result result = new Result();
            int len=0, max_lines=10000, count=0;

            System.out.print("FASE ENTRY ");
            llistaFitxers = entry.generarFitxers(file, max_lines, llistaFitxers);
            System.out.println("OK");

            System.out.print("FASE SPLIT ");
            for(String fileName : llistaFitxers){
                mapThreads.add(new Map(split.generatesplitWord(fileName, count)));
                count++;
            }
            System.out.println("OK");

            System.out.print("FASE MAP ");
            for(Map map : mapThreads){
                map.start();
            }
            for(Map map : mapThreads){
                map.join();
                len += map.getLengthFitxer();
                shuffleThreads.add(new Shuffle(map.getFileName(), map.getLlistaCaracters()));
            }
            System.out.println("OK");

            System.out.print("FASE SHUFFLE ");
            for(Shuffle shuffle : shuffleThreads){
                shuffle.start();
            }
            for(Shuffle shuffle : shuffleThreads){
                shuffle.join();
                reduceThreads.add(new Reduce(shuffle.getLlistaCaracters()));
            }
            System.out.println("OK");

            System.out.print("FASE REDUCE ");
            for(Reduce reduce : reduceThreads){
                reduce.start();
            }
            for(Reduce reduce : reduceThreads){
                reduce.join();
            }
            System.out.println("OK\n");

            result.mostrarPercentatgeCaracter(reduceThreads, len, file);
            reduceThreads.clear();
            shuffleThreads.clear();
            mapThreads.clear();
        }
        long fin = System.currentTimeMillis();
        double tiempo = (double) ((fin - inicio)/1000);
        System.out.println("Temps d'execució: "+tiempo +" segons");
    }
}