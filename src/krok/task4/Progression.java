package krok.task4;
public class Progression {
    public static long sumArithmeticProgression(int start, int difference, int n) {
        long sum = 0;
        int currentElement = start;
        for (int i = 0; i < n; i++) {
            sum += currentElement;
            currentElement += difference;
        }
        return sum;
    }

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Введите три аргумента: начало [-10000;10000], разность [-10000;10000], кол-во элем. [1;10000].");
            return;
        }

        int start = Integer.parseInt(args[0]);
        int difference = Integer.parseInt(args[1]);
        int n = Integer.parseInt(args[2]);

        if (start < -10000 || start > 10000 ||
                difference < -10000 || difference > 10000 ||
                n < 0 || n > 10000) {
            System.out.println("Проверьте введённые аргументы.");
            return;
        }

        long sum = sumArithmeticProgression(start, difference, n);

        System.out.println("Sum: " + sum);
    }
}