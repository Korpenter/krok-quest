package krok.task3;

import java.util.Scanner;

public class Primes {

    public static boolean isPrime(long n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        for (long i = 5; i * i <= n; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }

        return true;
    }

    public static boolean isTwinPrime(long n) {
        if (n == 3) return true;
        if (n % 6 == 5) return isPrime(n + 2);
        if (n % 6 == 1) return isPrime(n - 2);
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число в интервале [2, 10^10]:");
        long input = scanner.nextLong();

        if (input < 2 || input > 1e10) {
            System.out.println("Введите число в интервале [2, 10^10].");
            return;
        }

        if (isPrime(input)) {
            System.out.println("Простое");
            if (isTwinPrime(input)) {
                System.out.println("и близнец");
            } else {
                System.out.println("но не близнец");
            }
        } else {
            System.out.println("Составное");
        }


    }
}