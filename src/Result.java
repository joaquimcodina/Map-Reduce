import java.io.*;
import java.text.DecimalFormat;

/**
 * Aquesta es la Classe Result, on mostra per pantalla els resultats obtinguts.
 *
 * @author Joaquim Codina (1566940) i Marc Cives (1563480)
 *
 */
public class Result {

    /**
     * Aquesta es la funció mostrarPercentatgeCaracter(), bàsicament mostra el resultat obtingut per pantalla.
     *
     * @param len Mida del fitxer de text (per paraules).
     * @param file Nom del fitxer de text.
     *
     */
    public void mostrarPercentatgeCaracter(int len, String file) throws IOException {
        DecimalFormat df = new DecimalFormat("0.00");
        String encoding = "UTF-8";
        File fitxer = new File(file);
        File keys = new File("keys.txt");
        System.out.println(fitxer.getName() + ":");
        BufferedReader buffersKeys = new BufferedReader(new InputStreamReader(new FileInputStream(keys), encoding));
        for (String key; (key = buffersKeys.readLine()) != null; ) {
            File resultat = new File("suma_"+key+".txt");
            File valor = new File("value_"+key+".txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(resultat), encoding));
            System.out.println(key + " : " + df.format((Double.parseDouble(reader.readLine()) / len) * 100) + "%");
            resultat.delete();
            valor.delete();
        }
        keys.delete();
        System.out.println("\n");
    }
}
