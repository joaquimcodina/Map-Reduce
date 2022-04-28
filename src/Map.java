import java.util.ArrayList;

/**
 * Aquesta es la Classe Map
 *
 * @author Joaquim Codina (1566940) i Marc Cives (1563480)
 *
 */
public class Map extends Thread{
    /**
     * Aquesta es la funció splitCharacter(), consisteix en aprofitar el ArrayList<String> que hem generat anteriorment
     * en la funció generatesplitWord() de la Classe Split.
     *
     * Hem implementat un bucle for, que s'encarrega de comprovar que les paraules no tinguin caràcters repetits, en cas afirmatiu,
     * s'esborren i emmagatzemem el resultat dins d'un nou ArrayList<String>, ja que l'objectiu d'aquesta pràctica es mostrar
     * la freqüència dels caràcters per paraula (sense tenir en compte els caràcters repetits).
     *
     * @param llista on tenim emmagatzemat el contingut del fitxer de text, separat per paraules.
     * @return ArrayList<String> separat per caràcters.
     *
     */


    ArrayList<String> llistaAux;
    ArrayList<String> splitCharacters;
    Map() {
        splitCharacters = new ArrayList<>();
    }

    @Override
    public void run() {
        splitCharacters = this.splitCharacter(llistaAux);
    }

    public void setLlistaAux(ArrayList<String> aux) {
        llistaAux = aux;
    }


    public ArrayList<String> getLlistaRetorn() {
        return this.splitCharacters;
    }

   public ArrayList<String> splitCharacter(ArrayList<String> llista) {

        for (String s : llista) {
            String[] temp = s.toLowerCase()
                    .replace(",", "")
                    .replace(".", "")
                    .replace(";", "")
                    .replace("'", "")
                    .replace("-", "")
                    .replace(":", "")
                    .replace("[", "")
                    .replace("]", "")
                    .split(" ");

            for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j < temp[i].length(); j++) {
                    if (temp[i].indexOf(temp[i].charAt(j)) == j) {
                        splitCharacters.add(String.valueOf(temp[i].charAt(j)));
                    }
                }
            }
        }
        return splitCharacters;
    }

}
