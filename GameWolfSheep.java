import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random randNum = new Random();
        Mis mis = new Mis('M');
        Owca owca = new Owca('O');
        char[][] plansza = new char[15][6];
        int[] tabOwca = new int[15];
        int pozycjaMisiaX = plansza.length-1;
        int pozycjaMisiaY = randNum.nextInt(plansza[0].length);
        int[] pozycjaOwcyX = new int[15];
        int[] pozycjaOwcyY = new int[15];

        mis.punkty=0;
        for (int i = 0; i < tabOwca.length; i++) {
            tabOwca[i] = randNum.nextInt(plansza.length);
        }
        int x, y;
        x = 0;
        y = 0;
        for (int i = 0; i < tabOwca.length; i++) {
            do {
                pozycjaOwcyX[i] = randNum.nextInt(plansza.length);
                pozycjaOwcyY[i] = randNum.nextInt(plansza[0].length);
            } while (plansza[pozycjaOwcyX[i]][pozycjaOwcyY[i]] != 0);
            plansza[pozycjaOwcyX[i]][pozycjaOwcyY[i]] = owca.znak;

        }
        for (int i = 0; i < plansza.length; i++) {
            for (int j = 0; j < plansza[i].length; j++) {
                if (plansza[i][j] != 'O' && plansza[i][j] != 'M') {
                    plansza[i][j] = '-';
                }
            }
        }
        plansza[pozycjaMisiaX][pozycjaMisiaY] = mis.znak;
        //Druk planszy
        drukPlanszy(plansza);
        
        int rzutKostka = randNum.nextInt(5) + 1; // Corrected to generate a random number in the range [0, 5]

        System.out.println("Wylosowana liczba to: " + rzutKostka);
        int k = 0;
        while (k != rzutKostka) {
            if (pozycjaMisiaX > 0) {
                plansza[pozycjaMisiaX][pozycjaMisiaY] = '-';
                pozycjaMisiaX--;
                plansza[pozycjaMisiaX][pozycjaMisiaY] = mis.znak;
                k++;
                System.out.println("Naciśnij spacje");
                sc.nextLine();
            }
            for(int i=0; i<pozycjaOwcyX.length; i++){
            if(plansza[pozycjaMisiaX][pozycjaMisiaY] == plansza[pozycjaOwcyX[i]][pozycjaOwcyY[i]]){
                System.out.println("Mis zjadl owce");
                 mis.punkty++;
                }
            }
            for (int i = 0; i < plansza.length; i++) {
                for (int j = 0; j < plansza[i].length; j++) {
                    System.out.print(plansza[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();

            if (plansza[0][pozycjaMisiaY] == mis.znak) {
                System.out.println("Meta! Gratulacje!");
                System.out.println("Punktacja:\n Mis:"+mis.punkty+" Wilk: ");
                break;
            }
        }
    }
    static void drukPlanszy(char[][] plansza){
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
