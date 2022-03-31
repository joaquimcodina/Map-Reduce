package org.example;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Entry {
    BufferedReader br;

    List<String> listaArrays;
    private int numCaracters;
    String file;

    Entry() throws FileNotFoundException {
        file = "fitxer1.txt";
        listaArrays = new ArrayList<>();
        br = new BufferedReader(new FileReader(file));
        numCaracters = 0;
    }
    public void guardarLinias() throws IOException {
        String line = "";
        do {
            line = br.readLine();
            if (line == null) {
                break;
            }
            String lineCorrect = line.replaceAll("\\s","");
            listaArrays.add(lineCorrect);
        } while(line != null);
    }
    public int getNumCaracters() {
        return numCaracters;
    }
    public void setNumCaracters(int numC) {
        numCaracters = numC;
    }
}
