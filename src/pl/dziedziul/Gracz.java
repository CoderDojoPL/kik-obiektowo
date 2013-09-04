package pl.dziedziul;

/**
 * @author Łukasz Dziedziul
 *         Date: 31.08.13
 */
public class Gracz {
    String symbol;
    String imie;
    int liczbaRuchow= 0;

    public void poprosOWprowadzenie(){
        System.out.println(imie + " podaj nr pola do postawienia " + symbol);
    }
    public void wygralem() {
        System.out.println("Brawo! Wygrał gracz " + imie + " Zwyciężył po " + liczbaRuchow + " ruchach");
        }
}
