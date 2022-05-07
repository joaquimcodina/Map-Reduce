import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Aquesta es la Classe Reduce
 *
 * @author Joaquim Codina (1566940) i Marc Cives (1563480)
 *
 */
public class Reduce extends Thread{

    String fileName;
    String caracter;
    public Reduce(String fileName, String caracter) {
        this.fileName = fileName;
        this.caracter = caracter;
    }

    @Override
    public void run() {
        this.generarReducing();
    }

    /**
     * Aquesta es la funció generarReducing(), a del caràcter que li hem assignat d'un caràcter que li hem assignat a cada Thread Reduce,
     * s'encarrega de cercar el fitxer de text temporal d'aquell caràcter on tenim emmagatzemat el nombre d'aparicions, i acte seguit
     * realitzat la suma del nombre d'aparicions.
     *
     * El resultat d'aquesta suma s'emmagatzema dins d'un altre fitxer de text temporal.
     *
     */
    public void generarReducing(){
        try {
            Path path = Paths.get("value_"+caracter+".txt");
            String encoding = "UTF-8";
            BufferedWriter sumaKey = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("suma_"+caracter+".txt"), encoding));
            sumaKey.write(String.valueOf(Files.lines(path).count()));
            sumaKey.newLine();
            sumaKey.close();
            File fileSplit = new File(fileName);
            fileSplit.delete();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}