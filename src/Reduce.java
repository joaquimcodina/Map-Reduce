import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Aquesta es la Classe Reduce
 *
 * @author Joaquim Codina (1566940) i Marc Cives (1563480)
 *
 */
public class Reduce extends Thread{

    ArrayList<String> llistaCaracters;
    HashMap<String, Integer> hashMap;
    public Reduce(ArrayList<String> llistaCaracters) {
        this.llistaCaracters = llistaCaracters;
        hashMap = new HashMap<>();
    }

    @Override
    public void run() {
        this.generarReducing();
    }

    public void setHashMap(HashMap<String, Integer> hashMap){
        this.hashMap = hashMap;
    }

    public HashMap<String, Integer> getHashMap() {
        return this.hashMap;
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
            BufferedReader readerValueCaracter;
            int suma=0;
            String encoding = "UTF-8";
            for(String caracter : llistaCaracters){
                File fileValueCaracter = new File("value_"+caracter+".txt");
                FileInputStream fileValueInputStream = new FileInputStream(fileValueCaracter);
                readerValueCaracter = new BufferedReader(new InputStreamReader(fileValueInputStream, encoding));
                for (String value; (value = readerValueCaracter.readLine()) != null; ) {
                    suma += Integer.parseInt(value);
                }
                hashMap.put(caracter, suma);
                readerValueCaracter.close();
                fileValueInputStream.close();
                suma = 0;
            }

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}