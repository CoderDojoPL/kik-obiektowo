package pl.dziedziul;

/**
 * @author Łukasz Dziedziul
 *         Date: 31.08.13
 */
public class Plansza {
    String[][] plansza = new String[3][3];
    int ileDobrychRuchow = 0;
    public void zainicjuj(){
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                plansza[i][j] = "_";
            }
        }
    }

    public void wypisz() {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                System.out.print(plansza[i][j] + " ");
            }
            System.out.println();
        }
    }
}
