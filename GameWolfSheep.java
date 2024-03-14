import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random randNum = new Random();
        Mis mis = new Mis('M');
        Wilk wilk = new Wilk('W');
        Owca owca = new Owca('O');

        char[][] plansza = new char[12][12];
        int[] tabOwca = new int[30];
        int pozycjaMisiaX = plansza.length-1;
        int pozycjaMisiaY = randNum.nextInt(plansza[0].length);
        int pozycjaWilkaX = plansza.length-1;
        int pozycjaWilkaY = randNum.nextInt(plansza[0].length);
        int[] pozycjaOwcyX = new int[30];
        int[] pozycjaOwcyY = new int[30];
        mis.punkty=0;
        wilk.punkty=0;
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
        //Rzut koscia dla Misia
        RzutKosciaM(plansza,pozycjaMisiaX,pozycjaMisiaY,pozycjaOwcyX,pozycjaOwcyY,mis);
        System.out.println("Następny rzut");
        RzutKosciaM(plansza,mis.pozycjaX,mis.pozycjaY,pozycjaOwcyX,pozycjaOwcyY,mis);
    }
    static void drukPlanszy(char[][] plansza){
        for (int i = 0; i < plansza.length; i++) {
            for (int j = 0; j < plansza[i].length; j++) {
                System.out.print(plansza[i][j] + " ");
            }
            System.out.println();
        }
    }
    static void RzutKosciaM(char[][] plansza,int pozycjaMisiaX,int pozycjaMisiaY,int[] pozycjaOwcyX,int[] pozycjaOwcyY,Mis mis){
        Random randNum = new Random();
        Scanner sc = new Scanner(System.in);
        int rzutKostka = randNum.nextInt(5) + 1;

        System.out.println("Wylosowana liczba to: " + rzutKostka);
        int k = 0;
        while (k != rzutKostka) {
            if (pozycjaMisiaX > 0) {
                plansza[pozycjaMisiaX][pozycjaMisiaY] = '-';
                pozycjaMisiaX--;
                plansza[pozycjaMisiaX][pozycjaMisiaY] = mis.znak;
                k++;
                System.out.println("Naciśnij spacje");
                mis.pozycjaX = pozycjaMisiaX;
                mis.pozycjaY = pozycjaMisiaY;
                sc.nextLine();
            }
            for(int i=0; i<pozycjaOwcyX.length; i++){
                if(plansza[pozycjaMisiaX][pozycjaMisiaY] == plansza[pozycjaOwcyX[i]][pozycjaOwcyY[i]]){
                    System.out.println(ANSI_RED+"Mis zjadl owce"+ANSI_RESET);
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
    int pozycjaX;
    int pozycjaY;
    Mis(char znak){
        this.znak = znak;
    }
}
class Wilk extends Zwierze{
    char znak;
    Wilk(char znak){
        this.znak = znak;
    }
}
