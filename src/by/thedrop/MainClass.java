package by.thedrop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Kuryakov on 17-Sep-16.
 */
public class MainClass {
    private static final int ARRAY_CAPASITY = 3;

    public static void main(String[] args) {
        input();
    }

    private static void input() {
        //Число считается двоичным, если оно окружено в квадратные скобки
        int[] a = new int[ARRAY_CAPASITY];
        for (int i = 0; i < ARRAY_CAPASITY; i++) {
            a[i] = 0;
        }
        int iterator = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please, input your numbers");
        String inputString = "";
        while (a[ARRAY_CAPASITY - 1] == 0) {
            try {
                inputString = br.readLine();
            } catch (IOException e) {
                System.out.println("IOException catched!");
                e.printStackTrace();
            }
            try {
                String[] tempArray = inputString.split("/");
                for (int i = 0; i < tempArray.length; i++) {
                    System.out.println(tempArray[i]);
                }
                for (int i = 0; i < tempArray.length; i++) {
                    if (iterator + i <= a.length) {
                        a[iterator + i] = Integer.parseInt(tempArray[i]);
                        System.out.println(iterator + " number =" + a[iterator]);
                        iterator++;
                    }
                }
            } catch (Exception ex) {
                System.out.println("Unhandled exception!");
                ex.printStackTrace();
            }
        }
    }

    private static double average(int[] array, int count) {
        double summ = 0;
        for (int i = 0; i < count; i++) {
            summ += array[i];
        }
        return summ / count;
    }

    private int maximum(int[] array, int count) {
        int max = array[0];
        for (int i = 0; i < count; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    private int minimum(int[] array, int count) {
        int min = array[0];
        for (int i = 0; i < count; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    private void generateArray(int k) {
        int arrayCapacity = (int) (Math.random() * 100 + 100);
        System.out.println("Array capacity =" + arrayCapacity);
        int[] array = new int[arrayCapacity];
        for (int i = 0; i < arrayCapacity; i++) {
            array[i] = (int) (Math.random() * k);
        }

    }

    private boolean isPrime(int number) {
        if (number % 2 == 0) {
            return false;
        }
        for (int i = 1; i < Math.sqrt(number); i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int countOfPrime(int[] array, int count) {
        int numberOfPrimes = 0;
        for (int i = 0; i < count; i++) {
            if (isPrime(array[i])) {
                numberOfPrimes++;
            }
        }
        return numberOfPrimes;
    }

    private int countOfDevidersByThree(int[] array, int count) {
        int numberOfNumbers = 0;
        for (int i = 0; i < count; i++) {
            if (array[i] % 3 == 0) {
                numberOfNumbers++;
            }
        }
        return numberOfNumbers;
    }

    private void bubbleSort(int[] array, int count){

    }
    private void radexSort(int[] array, int count){

    }
}
