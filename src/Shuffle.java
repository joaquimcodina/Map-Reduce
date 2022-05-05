import java.io.*;
import java.util.ArrayList;

/**
 * Aquesta es la Classe Shuffle
 *
 * @author Joaquim Codina (1566940) i Marc Cives (1563480)
 *
 */
public class Shuffle extends Thread{

    String fileName;
    ArrayList<String> llistaCaracters;
    public Shuffle(String fileName, ArrayList<String> llistaCaracters) {
        this.llistaCaracters = llistaCaracters;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        this.generarShuffling();
    }

    public ArrayList<String> getLlistaCaracters(){
        return this.llistaCaracters;
    }

    /**
     * Aquesta es la funció generarShuffling(), bàsicament s'encarrega de generar un HashMap, i a partir d'un bucle
     * buscarà per cada caràcter, el nombre de vegades que apareix en el fitxer de text, en cas de que aparegui, afegim un 1
     * a la ArrayList<Integer> que es troba dins del HashMap, i que més endavant sumarem tot el seu contingut.
     *
     * llista on s'emmagatzema el contingut del fitxer de text, el qual hem esborrat els caràcters repetits per paraules,
     *              i l'hem separat per caràcters amb un split.
     *
     * hashMap on s'emmagatzema els caràcters del fitxer juntament amb el seu nombre d'aparicions (sense sumar).
     *
     */
    public void generarShuffling() {
        try{
            File fitxerSplit = new File(fileName);
            BufferedReader readerShuffle;
            BufferedWriter writer;
            String encoding = "UTF-8";
            for (String caracter : llistaCaracters) {
                FileInputStream shuffleInputStream = new FileInputStream(fitxerSplit);
                readerShuffle = new BufferedReader(new InputStreamReader(shuffleInputStream, encoding));
                writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("value_"+caracter+".txt", true), encoding));
                for (String line; (line = readerShuffle.readLine()) != null;) {
                    if (line.contains(caracter)) {
                        writer.write("1");
                        writer.newLine();
                    }
                }
                readerShuffle.close();
                shuffleInputStream.close();
                writer.close();
            }
            fitxerSplit.delete();
        }
        catch (IOException e){
            System.out.println("Error: " + e);
        }
    }
}