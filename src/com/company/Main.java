package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        long czas1=0, czas2=0;
        int i = 0;

        Scanner odczyt = new Scanner(new File("tablica1.txt"));

        int tablica1[] = new int[10000];
        int tablica2[] = new int[10000];

        while(odczyt.hasNextInt()){
            tablica1[i] = tablica2[i] = odczyt.nextInt();
            i++;
        }
        //for (int i = 0; i < tablica1.length; i++) {
        //    System.out.print(tablica1[i] + " ");
        //}

        for (int b = 0; b < 5; b++) { //petla for wykonuje sortowanie 5 razy w celu dokladniejszego wyniku
            long start1 = System.nanoTime();//poczatek pomiaru czasu, aktualny czas(babel).
            babel(tablica1);
            long stop1 = System.nanoTime();//koniec pomiaru czasu, aktualny czas(babel).
            czas1 += stop1 - start1;
            long start2 = System.nanoTime();//poczatek pomiaru czasu, aktualny czas(szybkie).
            szybkie(tablica2, 0, tablica2.length - 1);
            long stop2 = System.nanoTime();//koniec pomiaru czasu, aktualny czas(szybkie).
            czas2 += stop2 - start2;
        }

        System.out.println("Czas wykonania babel (w mikrosekundach): " + ((czas1 / 5)/1000));//obliczenie czasu sortowania.
        System.out.println("Czas wykonania szybkie (w mikrosekundach): " + ((czas2 / 5)/1000));//obliczenie czasu sortowania.

        //for (int i = 0; i < tablica1.length; i++) {
        //    System.out.print(tablica1[i] + " ");
        //}

        //for (int i = 0; i < tablica2.length; i++) {
        //    System.out.print(tablica2[i] + " ");
        //}
        }

    public static void babel(int tablica[]) {//metoda sortowania babelkowego

        int zmiana = 1, tablica1;

        while (zmiana > 0) {
            zmiana = 0;

            for (int i = 0; i < tablica.length - 1; i++) {

                if (tablica[i] > tablica[i + 1]) {
                    tablica1 = tablica[i + 1];
                    tablica[i + 1] = tablica[i];
                    tablica[i] = tablica1;
                    zmiana++;
                }
            }
        }
    }

    private static void szybkie(int tablica[], int x, int y) {//metoda sortowania szybkiego

        int i, j, v, temp;
        i = x;
        j = y;
        v = tablica[(x + y) / 2];

        do {

            while (tablica[i] < v)
                i++;

            while (v < tablica[j])
                j--;

            if (i <= j) {
                temp = tablica[i];
                tablica[i] = tablica[j];
                tablica[j] = temp;
                i++;
                j--;
            }
        }

        while (i <= j);

        if (x < j)
            szybkie(tablica, x, j);

        if (i < y)
            szybkie(tablica, i, y);
    }
}

