import java.io.*;

/**
 * Aquesta es la Classe Split
 *
 * @author Joaquim Codina (1566940) i Marc Cives (1563480)
 *
 */
public class Split {

    /**
     * Aquesta es la funció generatesplitWord(), que consisteix en separar per paraules el contingut del ArrayList<String>,
     * passat per paràmetre d'entrada.
     *
     * Utilitza un bucle foreach, que s'encarrega de reemplaçar els caràcters especials i a continuació, separar cadascuna de les linies
     * del fitxer en paraules, i ho emmagatzema en un ArrayList<String> anomenat splitWord.
     *
     * llista ArrayList on tenim emmagatzemat el contingut del fitxer de text.
     * ArrayList del contingut del fitxer de text, separat per paraules.
     *
     */
    public String generatesplitWord(String fileName, int count) throws FileNotFoundException {
        File file = new File(fileName);
        FileInputStream fileInputStream = new FileInputStream(file);
        String encoding = "UTF-8";
        BufferedReader reader;
        BufferedWriter writer;
        String nameWriter="";
        try{
            nameWriter = "split"+count+".txt";
            reader = new BufferedReader(new InputStreamReader(fileInputStream, encoding));
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(nameWriter), encoding));
            for (String line; (line = reader.readLine()) != null;) {
                String[] temp = line.toLowerCase()
                        //.replaceAll("[\\dA-Za-z]", " ")
                        .replaceAll("[0-9]", "")
                        .replace(",", "")
                        .replace(".", "")
                        .replace(";", "")
                        .replace("'", "")
                        .replace("-", "")
                        .replace(":", "")
                        .replace("[", "")
                        .replace("]", "")
                        .replace("/", "")
                        .replace("›", "")
                        .replace("<", "")
                        .replace(">", "")
//                        .replace("•", "").
//                        .replace("“", "")
//                        .replace("„", "")
//                        .replace("”", "")
//                        .replace("_", "")
//                        .replace("’", "")
//                        .replace("‘", "")
//                        .replace("¡", "")
//                        .replace("!", "")
//                        .replace("«", "")
//                        .replace("»", "")
//                        .replace("º", "")
//                        .replace("°", "")
//                        .replace("ª", "")
//                        .replace("=", "")
//                        .replace("&", "")
//                        .replace("%", "")
//                        .replace("|", "")
//                        .replace("@", "")
//                        .replace("$", "")
//                        .replace("?", "")
//                        .replace("¿", "")
//                        .replace("´", "")
//                        .replace("`", "")
//                        .replace("{", "")
//                        .replace("}", "")
//                        .replace("(", "")
//                        .replace(")", "")
//                        .replace("+", "")
//                        .replace("*", "")
//                        .replace(",", "")
//                        .replace("—", "")
//                        .replace(".", "")
//                        .replace(";", "")
//                        .replace("'", "")
//                        .replace("-", "")
//                        .replace(":", "")
//                        .replace("[", "")
//                        .replace("]", "")
                        .split(" ");
                for (String s : temp) {
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
