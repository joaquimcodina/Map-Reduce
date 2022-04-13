package main.java.org.example;
import java.util.ArrayList;
import java.util.Arrays;

public class Split {
    ArrayList<String> splitCharacter;
    private int numLinies;

    Split() {
        splitCharacter = new ArrayList<>();
        numLinies = 0;
    }

    public void actualitzarLista(ArrayList<String> llista) {
        for (String s : llista) {
            splitCharacter.add(Arrays.toString(s.toCharArray()));
        }
    }
    public int getNumLinies() {
        return numLinies;
    }
    public void setNumLinies(int numL) {
        numLinies = numL;
    }
    public ArrayList<String> getArrayCharacters() { return splitCharacter; }

}
