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
     * Aquesta es la funció splitCharacter(), consisteix en aprofitar el ArrayList<String> que hem generat anteriorment
     * en la funció generatesplitWord() de la Classe Split.
     *
     * Hem implementat un bucle for, que s'encarrega de comprovar que les paraules no tinguin caràcters repetits, en cas afirmatiu,
     * s'esborren i emmagatzemem el resultat dins d'un nou ArrayList<String>, ja que l'objectiu d'aquesta pràctica es mostrar
     * la freqüència dels caràcters per paraula (sense tenir en compte els caràcters repetits).
     *
     * llista on tenim emmagatzemat el contingut del fitxer de text, separat per paraules.
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
