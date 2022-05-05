import java.io.*;
import java.util.ArrayList;

/**
 * Aquesta es la Classe Entry, accedeix al contingut dels fitxers de Text.
 *
 * @author Joaquim Codina (1566940) i Marc Cives (1563480)
 *
 */
public class Entry {
    public ArrayList<String> generarFitxers(String fitxer, int maxlines, ArrayList<String> llistaFitxers) {
        String encoding = "UTF-8";
        BufferedReader reader;
        BufferedWriter writer;
        String name = "";
        try {
            int count = 0;
            name = "temp"+(0)+".txt";
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(fitxer), encoding));
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(name), encoding));
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
