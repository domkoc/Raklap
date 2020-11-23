public class Raklap implements Comparable<Raklap> {
    int hosszusag;
    int szelesseg;
    int meret;
    int[][] raklap;
    int y;
    int x;

    public Raklap(int hosszusag, int szelesseg, int index) {
        this.hosszusag = hosszusag;
        this.szelesseg = szelesseg;
        this.meret = this.szelesseg * this.hosszusag;
        this.raklap = new int[this.hosszusag][this.szelesseg];
        for (int i = 0; i < this.hosszusag; i++) {
            for (int j = 0; j < this.szelesseg; j++) {
                raklap[i][j] = index;
            }
        }
        this.y = 0;
        this.x = 0;
    }

    public Raklap(int y, int x, Raklap raklap) {
        this.hosszusag = raklap.hosszusag;
        this.szelesseg = raklap.szelesseg;
        this.meret = this.szelesseg * this.hosszusag;
        this.raklap = new int[this.hosszusag][this.szelesseg];
        for (int i = 0; i < this.hosszusag; i++) {
            for (int j = 0; j < this.szelesseg; j++) {
                this.raklap[i][j] = raklap.raklap[0][0];
            }
        }
        this.y = y;
        this.x = x;
    }

    @Override
    public int compareTo(Raklap o) {
        return this.meret < o.meret ? 1 : this.meret == o.meret ? 0 : -1;
    }

    public void rotate() {
        int swap = hosszusag;
        hosszusag = szelesseg;
        szelesseg = swap;

        int[][] newRaklap = new int[hosszusag][szelesseg];
        for (int i = 0; i < hosszusag; i++) {
            for (int j = 0; j < szelesseg; j++) {
                newRaklap[i][j] = raklap[0][0];
            }
        }
        raklap = newRaklap;
    }

    public void print() {
        for (int i = 0; i < hosszusag; i++) {
            for (int j = 0; j < szelesseg; j++) {
                System.out.print(raklap[i][j]);
                System.out.print("\t");
            }
            System.out.print("\n");
        }
    }
}