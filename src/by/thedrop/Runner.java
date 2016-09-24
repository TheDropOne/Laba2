package by.thedrop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Kuryakov on 17-Sep-16.
 */

public class Runner {
    private static final int ARRAY_CAPASITY = 3;
    private static int[] array;

    public static void main(String[] args) {
        input();
        printArray(array);

        int k = minimum(array);
        System.out.println("Average = " + average(array));
        System.out.println("Maximum = " + maximum(array));
        System.out.println("Minimum = " + k);
        int[] generatedArray = generateArray(k);
        System.out.println("Print generated array : ");
        printArray(generatedArray);
        System.out.println("Count of primes = " + countOfPrimes(generatedArray));
        System.out.println("Count of three dividers = " + countOfDividersByThree(generatedArray));
        System.out.println("Cocktail sort :");
        printArray(generatedArray);
        cocktailSort(generatedArray);
        printArray(generatedArray);
        System.out.println("Bubble sort : (From high to low");
        printArray(generatedArray);
        bubbleSort(generatedArray);
        printArray(generatedArray);
        System.out.println("Selection sort :");
        printArray(generatedArray);
        selectionSort(generatedArray);
        printArray(generatedArray);
    }

    private static void input() {
        String inputString;
        array = new int[ARRAY_CAPASITY];
        for (int i = 0; i < ARRAY_CAPASITY; i++) {
            array[i] = 0;
        }
        int iterator = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please, input your numbers");
        while (array[ARRAY_CAPASITY - 1] == 0) {
            try {
                inputString = br.readLine();
                Pattern hex = Pattern.compile("\\d+");
                Pattern binary = Pattern.compile("\\[[0-1]\\d+\\]");
                Matcher hexMatcher = hex.matcher(inputString);
                Matcher binaryMatcher = binary.matcher(inputString);
                while (binaryMatcher.find() && iterator < ARRAY_CAPASITY) {
                    String s = binaryMatcher.group();
                    try {
                        array[iterator] = Integer.parseInt(s.substring(1, s.length() - 2), 2);
                        iterator++;
                    }catch (Exception ex){

                    }
                }
                System.out.println("Found binaries = " + iterator);
                while (hexMatcher.find() && iterator < ARRAY_CAPASITY) {
                    array[iterator] = Integer.parseInt(hexMatcher.group());
                    iterator++;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("Something gone wrong");
            }
        }
    }

    private static double average(int[] array) {
        double summ = 0;
        for (int anArray : array) {
            summ += anArray;
        }
        return summ / array.length;
    }

    private static int maximum(int[] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    private static int minimum(int[] array) {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    private static int[] generateArray(int k) {
        int arrayCapacity = (int) (Math.random() * 100 + 100);
        System.out.println("Array capacity = " + arrayCapacity);
        int[] array = new int[arrayCapacity];
        for (int i = 0; i < arrayCapacity; i++) {
            array[i] = (int) (Math.random() * (k + 1));
            System.out.print(array[i] + " ");
        }
        System.out.println();
        return array;
    }

    private static boolean isPrime(int number) {
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

    private static int countOfPrimes(int[] array) {
        int numberOfPrimes = 0;
        for (int i = 0; i < array.length; i++) {
            if (isPrime(array[i])) {
                numberOfPrimes++;
            }
        }
        return numberOfPrimes;
    }

    private static int countOfDividersByThree(int[] array) {
        int numberOfNumbers = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 3 == 0) {
                numberOfNumbers++;
            }
        }
        return numberOfNumbers;
    }

    private static void printArray(int[] array) {
        for (int a : array) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    private static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    private static void cocktailSort(int[] array) {
        int leftBorder = 0, rightBorder = array.length - 1;
        do {
            for (int i = leftBorder; i < rightBorder; i++) {
                if (array[i] > array[i + 1]) {
                    array[i] ^= array[i + 1];
                    array[i + 1] ^= array[i];
                    array[i] ^= array[i + 1];
                }
            }
            rightBorder--;
            for (int i = rightBorder; i > leftBorder; i--) {
                if (array[i] < array[i - 1]) {
                    array[i] ^= array[i - 1];
                    array[i - 1] ^= array[i];
                    array[i] ^= array[i - 1];
                }
            }
            leftBorder++;
        } while (leftBorder <= rightBorder);
    }

    private static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int min_i = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    min_i = j;
                }
            }
            if (i != min_i) {
                int tmp = array[i];
                array[i] = array[min_i];
                array[min_i] = tmp;
            }
        }
    }
}
