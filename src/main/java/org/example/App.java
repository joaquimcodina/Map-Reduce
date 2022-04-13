package main.java.org.example;
import java.util.ArrayList;
import java.util.HashMap;

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

        Map map = new Map();
        map.generarHashMap(llista);
        HashMap<String, ArrayList<Integer>> hashMap = map.getHashMap();
        System.out.println(hashMap);
    }
}
