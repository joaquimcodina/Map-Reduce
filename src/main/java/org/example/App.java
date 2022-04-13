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
        for (String s : llista) {
            System.out.println(s);
        }
    }
}
