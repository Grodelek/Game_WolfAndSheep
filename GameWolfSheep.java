import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random randNum = new Random();
        Mis mis = new Mis('M');
        Wilk[] wilk = new Wilk[2];
        Wilk wilki = new Wilk();
        Owca owca = new Owca('O');
        char[][] plansza = new char[12][12];
        int[] tabOwca = new int[30];
        int pozycjaMisiaX = plansza.length - 1;
        int pozycjaMisiaY = randNum.nextInt(plansza[0].length);
        int pozycjaWilkaX = plansza.length - 1;
        int pozycjaWilkaY = randNum.nextInt(plansza[0].length);
        int[] pozycjaOwcyX = new int[30];
        int[] pozycjaOwcyY = new int[30];
        for (int i = 0; i < wilk.length; i++) {
            wilk[i] = new Wilk('W');
        }
        mis.punkty = 0;
        wilki.punkty = wilk[0].punkty + wilk[1].punkty;

        for (int i = 0; i < tabOwca.length; i++) {
            tabOwca[i] = randNum.nextInt(plansza.length);
        }
        //Tworzenie Owiec na plaszny
        tworzOwce(tabOwca,plansza,pozycjaOwcyX,pozycjaOwcyY,owca);

        for(int i = 0; i<plansza.length;i++){
            for (int j = 0; j < plansza[i].length; j++) {
                if (plansza[i][j] != 'O' && plansza[i][j] != 'M' && plansza[i][j] != 'W') {
                    plansza[i][j] = '-';
                }
            }
        }
        plansza[pozycjaMisiaX][pozycjaMisiaY]=mis.znak;
        plansza[pozycjaWilkaX][pozycjaWilkaY] = wilk[0].znak;
        drukPlanszy(plansza);

        //Rzut koscia dla Misia
        System.out.println("Rzut dla Misia");
        rzutKosciaM(plansza, pozycjaMisiaX, pozycjaMisiaY, pozycjaOwcyX, pozycjaOwcyY, mis);
        System.out.println("Następny rzut");
        //Rzut dla Wilka
        System.out.println("Rzut dla Wilka");
        rzutKosciaW(plansza,pozycjaWilkaX,pozycjaWilkaY,pozycjaOwcyX,pozycjaOwcyY,wilk);

        //Rzucanie koscia dopoki mis lub Wilk nie dojdzie do mety
        do {
            rzutKosciaM(plansza, mis.pozycjaX, mis.pozycjaY, pozycjaOwcyX, pozycjaOwcyY, mis);
        }while(plansza[0][pozycjaMisiaY]!=mis.znak);

    }
    static void drukPlanszy(char[][] plansza){
        for (int i = 0; i < plansza.length; i++) {
            for (int j = 0; j < plansza[i].length; j++) {
                System.out.print(plansza[i][j] + " ");
            }
            System.out.println();
        }
    }
    static void tworzOwce(int[] tabOwca,char[][] plansza,int[] pozycjaOwcyX,int[] pozycjaOwcyY,Owca owca) {
        Random randNum = new Random();
        for (int i = 0; i < tabOwca.length; i++) {
            do {
                pozycjaOwcyX[i] = randNum.nextInt(plansza.length);
                pozycjaOwcyY[i] = randNum.nextInt(plansza[0].length);
            } while (plansza[pozycjaOwcyX[i]][pozycjaOwcyY[i]] != 0);
            plansza[pozycjaOwcyX[i]][pozycjaOwcyY[i]] = owca.znak;
        }
    }
    static void rzutKosciaW(char[][]plansza,int pozycjaWilkaX,int pozycjaWilkaY,int[] pozycjaOwcyX,int[] pozycjaOwcyY,Wilk[] wilk){
        Random randNum = new Random();
        int randMiejsc = randNum.nextInt(5)+1;
        System.out.println("Wylosowana liczba dla wilka to "+randMiejsc);
        
        
        /// Sprawdzic ten blok
        try {
            for(int i=0 ;i<randMiejsc; i++) {
                int[] nowaPozycjaWX = new int[randMiejsc];
                     nowaPozycjaWX[i] =  pozycjaWilkaX - randMiejsc;
                int[] nowaPozycjaWY = new int[randMiejsc];
                nowaPozycjaWY[i] =  pozycjaWilkaY - randMiejsc;
                plansza[nowaPozycjaWX[i]][nowaPozycjaWY[i]] = wilk[0].znak;
                plansza[pozycjaWilkaX][pozycjaWilkaY] = '-';
            }
            for(int i=0; i<pozycjaOwcyX.length; i++){
                if(plansza[pozycjaWilkaX][pozycjaWilkaY] == plansza[pozycjaOwcyX[i]][pozycjaOwcyY[i]]){
                    System.out.println(ANSI_RED+"Wilk zjadl owce"+ANSI_RESET);
                    wilk[0].punkty++;
                }
            }
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }
    static void rzutKosciaM(char[][] plansza,int pozycjaMisiaX,int pozycjaMisiaY,int[] pozycjaOwcyX,int[] pozycjaOwcyY,Mis mis){
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
                System.out.println("Punktacja: \n Mis:"+mis.punkty+" Wilk: ");
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
    Wilk(){}
}

    Wilk(){}
}

