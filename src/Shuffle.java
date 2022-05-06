import java.io.*;

/**
 * Aquesta es la Classe Shuffle
 *
 * @author Joaquim Codina (1566940) i Marc Cives (1563480)
 *
 */
public class Shuffle extends Thread{

    String fileName;
    String caracter;
    public Shuffle(String fileName, String caracter) {
        this.fileName = fileName;
        this.caracter = caracter;
    }

    @Override
    public void run() {
        this.generarShuffling();
    }

    public String getCaracter(){
        return this.caracter;
    }

    public String getFileName(){
        return this.fileName;
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
            String encoding = "UTF-8";
            File fitxerSplit = new File(fileName);
            FileInputStream shuffleInputStream = new FileInputStream(fitxerSplit);
            BufferedReader readerShuffle;
            readerShuffle = new BufferedReader(new InputStreamReader(shuffleInputStream, encoding));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("value_"+caracter+".txt", true), encoding));
            for (String line; (line = readerShuffle.readLine()) != null;) {
                if (line.contains(caracter)) {
                    writer.write("1");
                    writer.newLine();
                }
            }
            writer.close();
            readerShuffle.close();
            shuffleInputStream.close();
        }
        catch (IOException e){
            System.out.println("Error: " + e);
        }
    }
}