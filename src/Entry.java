import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Aquesta es la Classe Entry, accedeix al contingut dels fitxers de Text.
 *
 * @author Joaquim Codina (1566940) i Marc Cives (1563480)
 *
 */
public class Entry {
    BufferedReader br;
    ArrayList<String> llista;

    /**
     * Aquesta es la funció Entry, que consisteix en inicialitzar un ArrayList<String> on anira el contingut del
     * nostre fitxer de text, i un BufferedReader, que s'encarrega de llegir el contingut del fitxer de text linia per linia.
     *
     * @param file fitxer de text passat per paràmetre d'entrada.
     *
     */
    Entry(String file){
        try{
            llista = new ArrayList<>();
            br = new BufferedReader(new FileReader(file));
        } catch (IOException e) {
            System.out.println("Error E/S" + e);
        }
    }
    /**
     * Aquesta es la funció guardarLinias(), consisteix en guardar el contingut del fitxer de text linia per linia
     * en el ArrayList<String>.
     *
     */
    public void guardarLinias(){
        try{
            String linea = br.readLine();
            while (linea != null) {
                llista.add(linea);
                linea = br.readLine();
            }
        }
        catch (IOException e){
            System.out.println("Error: " + e);
        }
    }
    /**
     * Aquesta es la funció getLines(), retorna el ArrayList<String> on tenim emmagatzemat el contingut del fitxer.
     *
     * @return llista.
     *
     */
    public ArrayList<String> getLines(){ return llista; };
}
