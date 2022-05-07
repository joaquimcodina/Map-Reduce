import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Aquesta es la Classe Map
 *
 * @author Joaquim Codina (1566940) i Marc Cives (1563480)
 *
 */
public class Map extends Thread{
    int lengthFitxer;
    String fileName;
    Set<String> caracters;

    public Map(String fileName) {
        this.fileName = fileName;
        this.caracters = new HashSet<>();
    }

    @Override
    public void run() {
        try {
            this.splitCharacter();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int getLengthFitxer(){
        return this.lengthFitxer;
    }

    public String getFileName(){
        return this.fileName;
    }

    public Set<String> getLlistaCaracters(){
        return this.caracters;
    }

    /**
     * Aquesta es la funció splitCharacter(), a partir dels fitxers de text temporals generats en la fase SPLIT, s'encarrega de
     * separar cadascuna de les paraules del fitxer de text en caràcters alfàbetics (ignorant els caràcters especials i numèrics).
     *
     * Utilitzem un BufferReader per llegir el fitxer de text generat en la fase Split, i per cada volta separem les paraules per caràcters,
     * finalitzem el procés emmagatzemant els caràcters en un HashSet, el qual no permet emmagatzemar caràcters repetits.
     *
     * Ademés, hem aprofitat aquesta funció per comptar el nombre de paraules del fitxer de text, i emmegatzemar el resultat en una variable
     * anomenada lengthFitxer.
     *
     * Un cop generats tots els fitxers de text temporals, assignarem un per cada Thread Reduce.
     *
     */
   public void splitCharacter() throws FileNotFoundException {
       File file = new File(fileName);
       FileInputStream fileInputStream = new FileInputStream(file);
       String encoding = "UTF-8";
       try {
           BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream, encoding));
           for (String line; (line = reader.readLine()) != null; ) {
               for (String s : line.split(" ")) {
                   for (int j = 0; j < s.length(); j++) {
                       if(String.valueOf(s.charAt(j)).matches("[A-Za-zà-ùá-ú]+")){
                           this.caracters.add(String.valueOf(s.charAt(j)));
                       }
                   }
               }
               this.lengthFitxer += line.split(" ").length;
           }
           reader.close();
       } catch (IOException e) {
           System.out.println("Error: " + e);
       }
   }
}
