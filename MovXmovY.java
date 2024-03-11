import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char mis = 'M';
        char[][] plansza = new char[6][6];
        int pozycjaMisiaX = 5;
        int pozycjaMisiaY = 5;
        for(int i=0;i<6;i++){
            for(int j=0; j<6; j++){
                plansza[i][j] = '-';
                plansza[pozycjaMisiaX][pozycjaMisiaY] = mis;
                }
            }
        for(int i=0; i<6; i++){
            for(int j=0; j<6; j++){
                System.out.print(plansza[i][j] + " ");
            }
            System.out.println();
        }
        Scanner sc = new Scanner(System.in);
        Random randNum = new Random();
        int numRand = randNum.nextInt(4)+4;
        if(numRand == 0){
            System.out.println("Kurwa czemu");
            numRand = randNum.nextInt(5)+3;
        }
        System.out.println("Wylosowana liczba to: "+numRand);
        int k=1;
        while(k != numRand){
            if (pozycjaMisiaY - 1 > 0) {
                plansza[pozycjaMisiaX][pozycjaMisiaY] = '-';
                pozycjaMisiaX--;
                plansza[pozycjaMisiaX][pozycjaMisiaY] = mis;
                k++;
                for (int i = 0; i < 6; i++) {
                    for (int j = 0; j < 6; j++) {
                        System.out.print(plansza[i][j] + " ");
                    }
                    System.out.println();
                }
                System.out.println();
            }
            if(plansza[0][5] == plansza[pozycjaMisiaX][pozycjaMisiaY]){
                System.out.println("Meta! gratulacje");
            }
                else {
                System.out.println("Nie mozna, poza granica");
            }
             }
        }
        }

