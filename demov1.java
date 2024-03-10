import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        char[][] plansza = new char[10][8];
        int[] randPosO = new int[8];
        int[] randPosMX = new int[4];
        int[] randPosMY = new int[4];

        for (int i = 0; i < randPosO.length; i++) {
            randPosO[i] = rand.nextInt(plansza.length);
        }
        for(int i=0; i < randPosMX.length; i++){
            randPosMX[i] = rand.nextInt(6)+1;
        }
        for(int i=0; i < randPosMY.length; i++){
            randPosMY[i] = rand.nextInt(6)+1;
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
        Mis mis = new Mis('M');
        plansza[9][randPosMY[0]] = mis.pozycja;

        //Drukowanie bez wynikow:
        System.out.println("*--------------*");
        System.out.println("     START");
        System.out.println("*--------------*");
        for (int i = 0; i < plansza.length; i++) {
            for (int j = 0; j < plansza[i].length; j++) {
                System.out.print(plansza[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Wykonaj rzut kostka dla Misia - enter");
        sc.nextLine();
        usuwaniePolozeniaMis(plansza,mis);
        try {
            plansza[randPosMX[0]][randPosMY[0]] = mis.pozycja;
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Zlapano wyjatek: "+e.getMessage());
            randPosMY[0] = rand.nextInt(plansza[0].length);
            plansza[randPosMX[0]][randPosMY[0]] = mis.pozycja;
        }

        //Drukowanie planszy
        drukowaniePlanszy(plansza);

    }
    static void drukowaniePlanszy(char[][] plansza){
        System.out.println("      META");
        System.out.println("---------------");
        for (int i = 0; i < plansza.length; i++) {
            for (int j = 0; j < plansza[i].length; j++) {
                System.out.print(plansza[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Punktacja");
        System.out.println("========================");
        System.out.println("Mis:  Wilk: ");
    }
    static void usuwaniePolozeniaMis(char[][] plansza,Mis mis){
        for(int i=0; i<plansza.length; i++){
            for(int j=0; j<plansza[i].length; j++){
                if(plansza[i][j] == mis.pozycja){
                    plansza[i][j] = '.';
                    break;
                }
            }
        }
    }
}

class Zwierze {
    int punkty;
}

class Mis extends Zwierze {
    char pozycja;
    int punkty;
    Mis(char pozycja) {
        this.pozycja = pozycja;
        this.punkty = 0;
    }
    public int getPunkty(){
        return punkty;
    }
    public void dodajPunkt() {
        punkty++;
    }
}

class Owca extends Zwierze {
    int pktZaZjedzenie;
}
