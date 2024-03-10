import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        char[][] plansza = new char[6][8];

        int[] randPosO = new int[8];
        int posM = rand.nextInt(plansza.length-1);
        for (int i = 0; i < randPosO.length; i++) {
            randPosO[i] = rand.nextInt(plansza.length);
        }

        int x, y;
        // Tworzenie Owiec na planszy
        for (int i = 0; i < 8; i++) {
            do {
                x = randPosO[i];
                y = rand.nextInt(plansza[0].length);
            } while (plansza[x][y] == '0');
            plansza[x][y] = '0';
        }

        // Ustawienie Owiec i planszy
        for (int i = 0; i < plansza.length; i++) {
            for (int j = 0; j < plansza[i].length; j++) {
                if (plansza[i][j] != '0') {
                    plansza[i][j] = '.';
                }
            }
        }
        //Tworzenie Misia na planszy
        for(int i = 0; i < plansza.length; i++) {
            for (int j = 0; j < plansza[i].length; j++) {
                plansza[5][posM] = 'M';
            }
        }
        //Drukowanie planszy
        for (int i = 0; i < plansza.length; i++) {
            for (int j = 0; j < plansza[i].length; j++) {
                System.out.print(plansza[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Wykonaj rzut kostka dla Misia - enter");
        sc.nextLine();
        int randRzut = rand.nextInt(plansza.length);
        plansza[randRzut][posM] = 'M';
        plansza[5][posM] = '.';

        //Drukowanie planszy
        for (int i = 0; i < plansza.length; i++) {
            for (int j = 0; j < plansza[i].length; j++) {
                System.out.print(plansza[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class Zwierze {
    int punkty;
}

class Mis extends Zwierze {
    Mis() {
    }
}

class Owca extends Zwierze {
    int pktZaZjedzenie;
}
