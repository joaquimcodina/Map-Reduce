package org.example;

import java.util.HashMap;

public class Map {
    private HashMap<String,String> mapFinal;
    private int numElementsMap;

    Map() {
        mapFinal = new HashMap<>();
        numElementsMap = mapFinal.size();
    }

    public int getNumElementsMap() {
        return numElementsMap;
    }
    public void setNumElementsMap(int x) {
        numElementsMap = x;
    }

}
