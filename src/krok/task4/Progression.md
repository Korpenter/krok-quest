Faculty: Krok  
Course: Introduction to Java  
Author: Doronin Dmitrii Alekseevich  
Task: Week 2 practice - Task 4  
Creation Date: 15.10.2023

## Задание №4
Цель задания:
Написать программу, которая принимает 3 аргумента, и считает сумму арифметической прогрессии.
Аргументы: начальный элемент, разность арифметической прогрессии и кол-во членов прогрессии.
Каждое число от -10 000 до +10 000. Решить с помощью использования циклов, а не формулы суммы.

### Ход выполнения задания:
Арифметическая прогрессия - это последовательность чисел, в которой разница между любыми двумя последовательными членами постоянна.
Задача состоит в том, чтобы вычислить сумму заданной прогрессии с помощью цикла.  
Главное - учесть, что при использовании неправильных типов может произойти переполнение, и результат будет неверным.
<details>
<summary>Итоговый код</summary>

```Java
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
```
</details>

<details>
<summary>Результат</summary>

![screenshot_1](https://github.com/Korpenter/url-shortener/assets/141184937/282f74ca-34c3-43b1-a865-42c64d02e10e)
</details>

Эта реализация была выбрана после бенчмарка других различными методами на большом количестве итераций. Однако, на небольшом
количестве итераций, вторая реализация sumArithmeticProgressionParam() оказывается быстрее.
(при реальном использовании разница в скорости незначительная)
<details>
<summary>Бенч</summary>

```Java
package krok.task4;

public class ProgressionBench {
    public static long sumArithmeticProgressionLocal(int start, int difference, int n) {
        long sum = 0;
        int currentElement = start;
        for (int i = 0; i < n; i++) {
            sum += currentElement;
            currentElement += difference;
        }
        return sum;
    }

    public static long sumArithmeticProgressionParam(int start, int difference, int n) {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += start;
            start += difference;
        }
        return sum;
    }

    public static long sumUsingLoops(int a, int d, int n) {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a + i * d;
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

        int iterations = 1000000;
        long startTime1 = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            sumArithmeticProgressionLocal(start, difference, n);
        }
        long endTime1 = System.nanoTime();
        double averageTime1 = (double) (endTime1 - startTime1) / iterations;
        System.out.println("sumArithmeticProgressionLocal - Average time for " + iterations + " iterations: " + averageTime1 + " nanosec.");

        long startTime2 = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            sumArithmeticProgressionParam(start, difference, n);
        }
        long endTime2 = System.nanoTime();
        double averageTime2 = (double) (endTime2 - startTime2) / iterations;
        System.out.println("sumArithmeticProgressionParam - Average time for " + iterations + " iterations: " + averageTime2 + " nanosec.");

        long startTime3 = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            sumUsingLoops(start, difference, n);
        }
        long endTime3 = System.nanoTime();
        double averageTime3 = (double) (endTime3 - startTime3) / iterations;
        System.out.println("sumUsingLoops - Average time for " + iterations + " iterations: " + averageTime3 + " nanosec.");
    }
}

```
</details>

<details>
<summary>Результат</summary>

![screenshot_2](https://github.com/Korpenter/krok-school-itmo/assets/141184937/6596e675-65ae-47b7-a878-ef754d24d6e3)
</details>
