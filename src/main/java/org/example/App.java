package main.java.org.example;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) {
        Entry entry = new Entry();
        entry.guardarLinias();
        ArrayList<String> llista = entry.getLines();

        Split split = new Split();
        split.actualitzarLista(llista);
        llista = split.getArrayCharacters();
        for (String s : llista) {
            System.out.println(s);
        }
    }
}
