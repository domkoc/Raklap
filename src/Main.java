import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        //valtozok:
        int[][] raktar = new int[0][0];
        boolean[][] oszlopok = new boolean[0][0];
        int raktarhossz = 0;
        int raktarszelesseg = 0;
        int oszlopokszama = 0;
        int raklapokszama = 0;
        Vector<int[][]> raklapok = new Vector<>();

        //beolvaso valtozok:
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = " ";
        String[] parts = new String[2];
        boolean input = true;
        int lineidx = 0;

        //beolvasas:
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
                        raktarhossz = hossz;
                        raktarszelesseg = szelesseg = Integer.parseInt(parts[1]);
                        raktar = new int[hossz][szelesseg];
                        oszlopok = new boolean[raktarhossz][raktarszelesseg];
                    } else if (lineidx == 1) {
                        oszlopokszama = hossz;
                    } else if (lineidx == 2) {
                        raklapokszama = hossz;
                    } else if (lineidx > 2 && lineidx < 3 + oszlopokszama) {
                        hossz = Integer.parseInt(parts[0]);
                        szelesseg = Integer.parseInt(parts[1]);
                        oszlopok[hossz - 1][szelesseg - 1] = true;
                    } else {
                        szelesseg = Integer.parseInt(parts[1]);
                        int[][] raklap = new int[hossz][szelesseg];
                        for (int i = 0; i < hossz; i++) {
                            for (int j = 0; j < szelesseg; j++) {
                                raklap[i][j] = lineidx - 2 - oszlopokszama;
                            }
                        }
                        raklapok.add(raklap);
                    }
                    lineidx++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Rendezes valtozok:

        //Rendezes:


    }
}
