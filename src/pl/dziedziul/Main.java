package pl.dziedziul;

/**
 * @author Łukasz Dziedziul
 *         Date: 12.08.13
 */

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static boolean remis = false;

    public static void main(String[] agre) {
       Plansza plansza= new Plansza();
       plansza.zainicjuj();

        Gracz gracz1 = new Gracz();
        Gracz gracz2 = new Gracz();

        System.out.println("Podaj imię gracza nr 1 [X]");
        gracz1.imie = sc.next();
        gracz1.symbol = "X";
        System.out.println("Podaj imię gracza nr 2 [O]");
        gracz2.imie = sc.next();
        gracz2.symbol = "O";
        while (true) {
            if (wykonajRuch(gracz1)) break;
            if (wykonajRuch(gracz2)) break;
        }
        if (remis) {
            System.out.println("Niestety nikt nie wygrał");
        }
    }

    private static boolean wykonajRuch(Gracz g, Plansza plansza) {
        plansza.wypisz();
        g.poprosOWprowadzenie();
        int nr = sc.nextInt();
        wstawZnak(nr, g);
        if (czyWygrał(g.symbol)) {
            plansza.wypisz();
            g.wygralem();
            return true;
        }
        if (ileDobrychRuchow > 8) {
            remis = true;
            return true;
        }

        return false;
    }

    private static void wstawZnak(int nr, Gracz g) {
        int x = (nr - 1) / 3;
        int y = (nr - 1) % 3;
        if (plansza[x][y].equals("_")) {
            plansza[x][y] = g.symbol;
            ++ileDobrychRuchow;
        } else {
            System.out.println("To pole jest już zajęte. " + g.imie + " tracisz kolejkę.");
        }
        g.liczbaRuchow++;
    }



    private static boolean czyWygrał(String symbol) {
        return symbol.equals(ktoWygral());
    }


    private static String ktoWygral() {

        for (int numerWiersza = 0; numerWiersza < 3; numerWiersza++) {
            String symbol = "X";
            if (czyWygralW(numerWiersza, symbol)) return symbol;
            symbol = "O";
            if (czyWygralW(numerWiersza, symbol)) return symbol;
        }
        for (int numerKolumny = 0; numerKolumny < 3; numerKolumny++) {
            String symbol = "X";
            if (czyWygralK(numerKolumny, symbol)) return symbol;
            symbol = "O";
            if (czyWygralK(numerKolumny, symbol)) return symbol;
        }
        if (plansza[0][0].equals("X") && plansza[1][1].equals("X") && plansza[2][2].equals("X")) {
            return "X";
        }
        if (plansza[0][0].equals("O") && plansza[1][1].equals("O") && plansza[2][2].equals("O")) {
            return "O";
        }
        if (plansza[0][2].equals("X") && plansza[1][1].equals("X") && plansza[2][0].equals("X")) {
            return "X";
        }
        if (plansza[0][2].equals("O") && plansza[1][1].equals("O") && plansza[2][0].equals("O")) {
            return "O";
        }
        return null;
    }

    private static boolean czyWygralW(int nrW, String symbol) {

        if (plansza[nrW][0].equals(symbol) && plansza[nrW][1].equals(symbol) && plansza[nrW][2].equals(symbol)) {
            return true;
        }
        return false;
    }

    private static boolean czyWygralK(int nrK, String symbol) {

        if (plansza[0][nrK].equals(symbol) && plansza[1][nrK].equals(symbol) && plansza[2][nrK].equals(symbol)) {
            return true;
        }
        return false;
    }
}