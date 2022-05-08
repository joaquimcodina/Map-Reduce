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
     * Aquesta es la funció generarShuffling(), a partir dels fitxers de text temporals generats en la fase split i d'un caràcter en concret
     * que hem assignat per cada Classe Shuffle, comprova la freqüència d'aparició del caràcter assignat per cadascuna de les paraules que es troben
     * en el fitxer de text, en cas afirmatiu, genera un nou fitxer de text temporal on anira la freqüència d'aparicions d'aquest caràcter (a partir de 1s),
     * que més endavant utilitzarem en la fase Reduce per fer la suma.
     *
     * Un cop generats tots els fitxers de text temporals, assignarem un caràcter per Thread Reduce, el qual s'encarregarà de
     * fer les suma del nombre d'aparicions del caràcter assignat.
     *
     */
    public void generarShuffling() {
        try{
            String encoding = "UTF-8";
            File fitxerSplit = new File(fileName);
            FileInputStream shuffleInputStream = new FileInputStream(fitxerSplit);
            BufferedReader readerShuffle = new BufferedReader(new InputStreamReader(shuffleInputStream, encoding));
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