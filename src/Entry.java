import java.io.*;
import java.util.ArrayList;

/**
 * Aquesta es la Classe Entry.
 *
 * @author Joaquim Codina (1566940) i Marc Cives (1563480)
 *
 */
public class Entry {

    /**
     * Aquesta es el procés generarFitxers(), accedeix al fitxer de text passat per paràmetre d'entrada, i genera
     * fitxers de text temporals amb un nombre de linies màxim (en aquest cas 10000 linies màxim per fitxer).
     *
     * @param fitxer el nom del fitxer de text.
     * @param maxlines el nombre de linies màxim que tindra cadascun dels fitxers de text temporals.
     * @param llistaFitxers llista on emmagatzemarem els noms dels fitxers de text temporals, que acte seguit assignarem
     *                      cadascuna de les classes següents del Split.
     * @return retorna la llista amb els noms dels fitxers de text temporals.
     *
     */
    public ArrayList<String> generarFitxers(String fitxer, int maxlines, ArrayList<String> llistaFitxers) {
        String encoding = "UTF-8";
        try {
            int count = 0;
            String name = "temp"+(0)+".txt";
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fitxer), encoding));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(name), encoding));
            for (String line; (line = reader.readLine()) != null;) {
                if (count++ % maxlines == 0) {
                    writer.close();
                    name = "temp"+(count / maxlines)+".txt";
                    writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(name), encoding));
                    llistaFitxers.add(name);
                }
                writer.write(line);
                writer.newLine();
            }
            writer.close();
            reader.close();
        } catch (IOException e){
            System.out.println("Error " + e);
        }
        return llistaFitxers;
    }
}
