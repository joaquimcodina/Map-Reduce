package org.example;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Entry {
    private FileReader entryDades;
    private int numCaracters;

    Entry() throws FileNotFoundException {
        entryDades = new FileReader("NombreFichero");
        numCaracters = 0;

    }
    public void emptyFile() {

    }
    public int getNumCaracters() {
        return numCaracters;
    }
    public void setNumCaracters(int numC) {
        numCaracters = numC;
    }
}
