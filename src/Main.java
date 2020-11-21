import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        //1. Beolvasas:
        //valtozok:
        Raktar raktar = new Raktar(0, 0);
        int oszlopokszama = 0;
        int raklapokszama = 0;
        Vector<Raklap> raklapok = new Vector<Raklap>();

        //beolvaso valtozok:
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = " ";
        String[] parts = new String[2];
        boolean input = true;
        int lineidx = 0;
        //bemenet:
        try {
            while (input) {
                line = br.readLine();
                if (line == null) input = false;
                else if ((line).trim().equals("")) input = false;
                else {
                    parts = line.split("\t");
                    int hossz = Integer.parseInt(parts[0]);
                    int szelesseg = 0;
                    if (lineidx == 0) {
                        szelesseg = Integer.parseInt(parts[1]);
                        raktar = new Raktar(hossz, szelesseg);
                    } else if (lineidx == 1) {
                        oszlopokszama = hossz;
                    } else if (lineidx == 2) {
                        raklapokszama = hossz;
                    } else if (lineidx > 2 && lineidx < 3 + oszlopokszama) {
                        szelesseg = Integer.parseInt(parts[1]);
                        raktar.addOszlop(hossz, szelesseg);
                    } else {
                        szelesseg = Integer.parseInt(parts[1]);
                        Raklap raklap = new Raklap(hossz, szelesseg, lineidx - 2 - oszlopokszama);
                        raklapok.add(raklap);
                    }
                    lineidx++;
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //2. Rendezes csokkeno sorba:
        Collections.sort(raklapok);

        //3. Betevés:
        for (Raklap raklap: raklapok) {
            raktar.addRaklap(raklap);
        }

        raktar.print();


    }
}
