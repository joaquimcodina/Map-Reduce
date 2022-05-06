import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Aquesta es la Classe principal, on fem crides a les diferents funcions de les altres classes per dur a terme
 * l'algoritme MapReduce
 *
 * @author Joaquim Codina (1566940) i Marc Cives (1563480)
 *
 */
public class App {
    public static void main(String[] args) throws InterruptedException, IOException {

        long inicio = System.currentTimeMillis();
        for (String file : args) {
            ArrayList<String> llistaFitxers = new ArrayList<>();
            Set<String> llistaCaracters = new HashSet<>();
            ArrayList<Map> mapThreads = new ArrayList<>();
            ArrayList<Shuffle> shuffles = new ArrayList<>();
            ArrayList<Reduce> reduceThreads = new ArrayList<>();
            Entry entry = new Entry();
            Split split = new Split();
            Result result = new Result();
            int len=0, count=0;

            System.out.print("FASE ENTRY ");
            llistaFitxers = entry.generarFitxers(file, 10000, llistaFitxers);
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
                llistaCaracters.addAll(map.getLlistaCaracters());
            }
            System.out.println("OK");
            BufferedWriter keys = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("keys.txt")));
            for(String caracter : llistaCaracters){
                keys.write(caracter);
                keys.newLine();
                for(Map map : mapThreads){
                    shuffles.add(new Shuffle(map.getFileName(), caracter));
                }
            }
            keys.close();

            System.out.print("FASE SHUFFLE ");
            for (Shuffle shuffle : shuffles) {
                shuffle.start();
            }
            for (Shuffle shuffle : shuffles) {
                shuffle.join();
                reduceThreads.add(new Reduce(shuffle.getFileName(), shuffle.getCaracter()));
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
            result.mostrarPercentatgeCaracter(len, file);
        }
        long fin = System.currentTimeMillis();
        double tiempo = (double) ((fin - inicio)/1000);
        System.out.println("Temps d'execució: "+tiempo +" segons");
    }
}