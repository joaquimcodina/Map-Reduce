import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Entry {
    BufferedReader br;
    ArrayList<String> llista;
    private int numCaracters;

    Entry(String file){
        try{
            numCaracters = 0;
            llista = new ArrayList<>();
            br = new BufferedReader(new FileReader(file));
        } catch (IOException e) {
            System.out.println("Error E/S" + e);
        }
    }
    public void guardarLinias(){
        try{
            String linea = br.readLine();
            while (linea != null) {
                llista.add(linea);
                linea = br.readLine();
            }
        }
        catch (IOException e){
            System.out.println("Error: " + e);
        }
    }
    public int getNumCaracters() { return numCaracters; }
    public void setNumCaracters(int numC) { numCaracters = numC;}
    public ArrayList<String> getLines(){ return llista; };
}
