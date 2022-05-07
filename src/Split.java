import java.io.*;

/**
 * Aquesta es la Classe Split
 *
 * @author Joaquim Codina (1566940) i Marc Cives (1563480)
 *
 */
public class Split {

    /**
     * Aquesta es la funció generatesplitWord(), que consisteix en separar per paraules el contingut del fitxer de text temporal
     * passat per paràmetre d'entrada, i guardar el resultat en uns altres fitxers de text temporals.
     *
     * @param fileName fitxer de text temporal generat en la fase Entry
     * @param count comptador que s'incrementa en cada volta del bucle, que utilitzarem per identificar cadascun dels fitxers
     *              generats en aquesta funció.
     *
     * @return retorna el nom del fitxer de text generat en aquesta funció.
     *
     */
    public String generatesplitWord(String fileName, int count) throws FileNotFoundException {
        File file = new File(fileName);
        FileInputStream fileInputStream = new FileInputStream(file);
        String encoding = "UTF-8";
        String nameWriter="";
        try{
            nameWriter = "split"+count+".txt";
            BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream, encoding));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(nameWriter), encoding));
            for (String line; (line = reader.readLine()) != null;) {
                for (String s : line.toLowerCase().split(" ")) {
                    writer.write(s);
                    writer.newLine();
                }
            }
            writer.close();
            reader.close();
            fileInputStream.close();
            file.delete();
        }
        catch (IOException e){
            System.out.println("Error: " + e);
        }
        return nameWriter;
    }
}
