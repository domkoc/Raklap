import java.util.Vector;

public class Raktar {
    int hosszusag;
    int szelesseg;
    int[][] raktar;
    Vector<Oszlop> oszlopok;

    public Raktar(int hosszusag, int szelesseg) {
        this.hosszusag = hosszusag;
        this.szelesseg = szelesseg;
        this.raktar = new int[hosszusag][szelesseg];
        for (int i = 0; i < hosszusag; i++) {
            for (int j = 0; j < szelesseg; j++) {
                raktar[i][j] = 0;
            }
        }
        oszlopok = new Vector<Oszlop>();
    }

    public void addOszlop(int y, int x) {
        oszlopok.add(new Oszlop(y, x));
    }

    public boolean addRaklap(Raklap raklap) {
        for (int y = 0; y < hosszusag; y++) {
            for (int x = 0; x < szelesseg; x++) {
                if (raklapFits(y, x, raklap)) {
                    putRaklap(y, x, raklap);
                    return true;
                }
            }
        }
        return false;
    }

    private void putRaklap(int y, int x, Raklap raklap) {
        for (int i = y; i < y + raklap.hosszusag; i++) {
            for (int j = x; j < x + raklap.szelesseg; j++) {
                raktar[i][j] = raklap.raklap[0][0];
            }
        }
    }

    private boolean raklapFits(int y, int x, Raklap raklap) {
        if (y + raklap.hosszusag > hosszusag) {
            if (y + raklap.szelesseg > hosszusag) {
                return false;
            } else {
                if (x + raklap.hosszusag > szelesseg) {
                    return false;
                } else {
                    if (isIntersected(y, x, raklap.szelesseg, raklap.hosszusag)) {
                        return false;
                    } else {
                        raklap.rotate();
                    }
                }
            }
        } else {
            if (x + raklap.szelesseg > szelesseg) {
                if (y + raklap.szelesseg > hosszusag) {
                    return false;
                } else {
                    if (x + raklap.hosszusag > szelesseg) {
                        return false;
                    } else {
                        if (isIntersected(y, x, raklap.szelesseg, raklap.hosszusag)) {
                            return false;
                        } else {
                            raklap.rotate();
                        }
                    }
                }
            } else {
                if (isIntersected(y, x, raklap.hosszusag, raklap.szelesseg)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isIntersected(int y, int x, int raklapHosszusag, int raklapSzelesseg) {
        for (Oszlop oszop: oszlopok) {
            if (oszop.y > y && oszop.y < y + raklapHosszusag) {
                if (oszop.x > x && oszop.x < x + raklapSzelesseg) {
                    return true;
                }
            }
        }

        for (int i = y; i < y + raklapHosszusag; i++) {
            for (int j = x; j < x + raklapSzelesseg; j++) {
                if (raktar[i][j] != 0) {
                    return true;
                }
            }
        }
        return false;
    }

    void print(){
        for (int i = 0; i < hosszusag; i++) {
            for (int j = 0; j < szelesseg; j++) {
                System.out.print(raktar[i][j]);
                if (j < szelesseg - 1) System.out.print("\t");
            }
            System.out.print("\n");
        }
    }
}
