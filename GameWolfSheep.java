import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random randNum = new Random();
        Mis mis = new Mis('M');
        Owca owca = new Owca('O');
        char[][] plansza = new char[6][6];
        int[] pozycjaOwcy = new int[8];
        int pozycjaMisiaX = 5;
        int pozycjaMisiaY = randNum.nextInt(plansza[0].length);
        int pozycjaOwcyX = randNum.nextInt(plansza.length);
        int pozycjaOwcyY = randNum.nextInt(plansza[0].length);
        for (int i = 0; i < pozycjaOwcy.length; i++) {
            pozycjaOwcy[i] = randNum.nextInt(plansza.length);
        }
        int x, y;
        x = 0;
        y = 0;
        for (int i = 0; i < 8; i++) {
            do {
                pozycjaOwcyX = randNum.nextInt(plansza.length);
                pozycjaOwcyY = randNum.nextInt(plansza[0].length);
            } while (plansza[pozycjaOwcyX][pozycjaOwcyY] != 0);
            plansza[pozycjaOwcyX][pozycjaOwcyY] = owca.znak;
        }
        //druk planszy
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (plansza[i][j] != 'O' && plansza[i][j] != 'M') {
                    plansza[i][j] = '-';
                }
            }
        }
        plansza[pozycjaMisiaX][pozycjaMisiaY] = mis.znak;
        plansza[pozycjaOwcyX][pozycjaOwcyY] = owca.znak;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(plansza[i][j] + " ");
            }
            System.out.println();
        }
        int numRand = randNum.nextInt(5) + 1; // Corrected to generate a random number in the range [0, 5]

        System.out.println("Wylosowana liczba to: " + numRand);
        int k = 0;
        while (k != numRand) {
            if (pozycjaMisiaX > 0) {
                plansza[pozycjaMisiaX][pozycjaMisiaY] = '-';
                pozycjaMisiaX--;
                plansza[pozycjaMisiaX][pozycjaMisiaY] = mis.znak;
                k++;
                System.out.println("Naciśnij spacje");
                sc.nextLine();
            }
            //Zrobic zeby zaliczalo ze mis zjadl owce

            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    System.out.print(plansza[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();

        if (plansza[0][pozycjaMisiaY] == mis.znak) {
            System.out.println("Meta! Gratulacje!");
            break;
        }
        }
    }
}

        class Zwierze {
            int punkty;
        }
        class Owca extends Zwierze {
            int pktZaZjedzenie;
            char znak;
            Owca(char znak) {
                this.znak = znak;
            }
        }
        class Mis extends Zwierze{
        char znak;
        Mis(char znak){
            this.znak = znak;
             }
        }



