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
     * Aquesta es la funció generarReducing(), bàsicament s'encarrega d'obtenir el HashMap amb els caràcters i el seu
     * nombre d'aparicions, i fer la suma del nombre d'aparicions de cada caràcter.
     *
     * El hashMap que hem obtingut de la funció generarShuffling() de la Classe Shuffle, on tenim emmagatzemat
     * els caràcters amb el seu nombre d'aparicions (sense sumar).
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