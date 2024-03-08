import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Game{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        char[][] plansza = new char[6][8];
//        for(int i=0; i<plansza.length; i++){
//            for(int j=0; j<plansza[i].length; j++){
//                System.out.print("o ");
//            }
//            System.out.println();
//        }
        Owca[] owca = new Owca[6];
        for(int i=0; i<owca.length; i++){
            owca[i] = new Owca();
        }
        int[] randPos = new int[8];
        int[] randPos2 = new int[8];
       for(int i=0 ; i< randPos.length ; i++){
           randPos[i] = rand.nextInt(plansza.length-1)+1;
           randPos2[i] = rand.nextInt(plansza.length-1)+1;
       }
        int iter=1;
            for (int i = 0; i < 7; i++) {
                    plansza[randPos[i]][randPos2[i]] = 'O';
                }
            for(int i=0; i<plansza.length; i++){
                for(int j=0; j<plansza[i].length; j++){
                    if (plansza[i][j] != plansza[randPos[i]][randPos2[i]]) {
                        plansza[i][j] = '.';
                    }
                }
            }


            for(int i=0; i<plansza.length; i++){
            for(int j=0; j<plansza[i].length; j++){
                System.out.print(plansza[i][j]+" ");
            }
            System.out.println();
        }
    }
}
class Zwierze{
    int punkty;
}
class Mis extends Zwierze{
    Mis(){}
}
class Owca extends Zwierze{
    int pktZaZjedzenie;
}
