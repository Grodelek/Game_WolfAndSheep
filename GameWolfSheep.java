import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random randNum = new Random();
        char mis = 'M';
        Owca owca = new Owca('O');
        char[][] plansza = new char[6][6];
        int[] pozycjaOwcy = new int[8];
        int pozycjaMisiaX = 5;
        int pozycjaMisiaY = randNum.nextInt(6);

        for(int i=0; i < pozycjaOwcy.length; i++){
            pozycjaOwcy[i] = randNum.nextInt(plansza.length);
        }
        int x,y;
        for(int i=0; i< 8; i++){
            do{
                x = pozycjaOwcy[i];
                y = randNum.nextInt(plansza[0].length);
            }while(plansza[x][y] == '0');
            plansza[x][y] = 'O';
        }

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if(plansza[i][j] != 'O' && plansza[i][j] != 'M'){
                plansza[i][j] = '-';
                }
            }
        }
        plansza[pozycjaMisiaX][pozycjaMisiaY] = mis;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(plansza[i][j] + " ");
            }
            System.out.println();
        }
        int numRand = randNum.nextInt(5)+1; // Corrected to generate a random number in the range [0, 5]

        System.out.println("Wylosowana liczba to: " + numRand);
        int k = 0; // Corrected to start from 0
        while (k != numRand) {
            if (pozycjaMisiaX > 0) {
                plansza[pozycjaMisiaX][pozycjaMisiaY] = '-';
                pozycjaMisiaX--;
                plansza[pozycjaMisiaX][pozycjaMisiaY] = mis;
                k++;
                System.out.println("Naciśnij spacje");
                sc.nextLine();
            }

            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    System.out.print(plansza[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();

            if (plansza[0][pozycjaMisiaY] == mis) {
                System.out.println("Meta! Gratulacje!");
                break;
            }
        }
    }
}
class Zwierze{
    int punkty;
}
class Owca extends Zwierze{
    int pktZaZjedzenie;
    char znak;
    Owca(char znak){
        this.znak = znak;
    }
}
