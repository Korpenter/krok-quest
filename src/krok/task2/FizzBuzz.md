Faculty: Krok  
Course: Introduction to Java  
Author: Doronin Dmitrii Alekseevich  
Task: Week 1 homework Task 2  
Creation Date: 08.09.2023

## Задание №2
Цель задания:
Напишите короткую программу, которая выводит на экран числа от 1 до 100, каждое в новой строке.
Вместо каждого числа, которое делится на 3, выводите ‘Fizz’.
Вместо каждого числа, которое делится на 5, выводите ‘Buzz’.
Вместо каждого числа, которое делится и на 3, и на 5, выводите ‘FizzBuzz’.


### Ход выполения задания:

Суть задания - решение классической задачки на циклы FizzBuzz. Самым простым решением является
использование цикла с проверкой кратности i:

```Java
public static void fizzBuzzString() {
    for (int i = 1; i <= 100; i++) {
        if (i % 15 == 0) {
            System.out.println("FizzBuzz");
        } else if (i % 3 == 0) {
            System.out.println("Fizz");
        } else if (i % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(i);
        }
    }
}
```
Но учитывая знания, полученные при выполнении первого задания можно оптимизировать решение
воспользовавшись StringBuilder:
```Java
public static void fizzBuzzBuilder() {
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= 100; i++) {
        if ((i % 3 == 0) && (i % 5 == 0)) {
            sb.append("FizzBuzz\n");
        } else if (i % 3 == 0) {
            sb.append("Fizz\n");
        } else if (i % 5 == 0) {
            sb.append("Buzz\n");
        } else {
            sb.append(i).append("\n");
        }
    }
    System.out.print(sb);
}
```

Для тестирование производительности в итоговый код была добавлена проверка по времени, и увеличен интервал вывода (бэнчмарк
и результат под спойлерами):
<details>
<summary>Бэнчмарк</summary>

```Java
package krok.task2;

public class FizzBuzzBenchmark {
    public static void fizzBuzzString() {
        for (int i = 1; i <= 300000; i++) {
            if ((i % 3 == 0) && (i % 5 == 0)) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

    public static void fizzBuzzBuilder() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 300000; i++) {
            if ((i % 3 == 0) && (i % 5 == 0)) {
                sb.append("FizzBuzz\n");
            } else if (i % 3 == 0) {
                sb.append("Fizz\n");
            } else if (i % 5 == 0) {
                sb.append("Buzz\n");
            } else {
                sb.append(i).append("\n");
            }
        }
        System.out.print(sb);
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        fizzBuzzString();
        long endTime = System.currentTimeMillis();
        long startTime2 = System.currentTimeMillis();
        fizzBuzzBuilder();
        long endTime2 = System.currentTimeMillis();
        System.out.println("Execution time for String: " + (endTime - startTime) + "ms");
        System.out.println("Execution time StringBuilder: " + (endTime2 - startTime2) + "ms");
    }
}

```

![screenshot_1](https://github.com/Korpenter/club/assets/141184937/3d7bdf4e-d2a6-4e43-bedd-88c3e1f7fb16)
</details>

<details>
<summary>Результат</summary>

```Java
package krok.task2;

public class FizzBuzz {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 100; i++) {
            if ((i % 3 == 0) && (i % 5 == 0)) {
                sb.append("FizzBuzz\n");
            } else if (i % 3 == 0) {
                sb.append("Fizz\n");
            } else if (i % 5 == 0) {
                sb.append("Buzz\n");
            } else {
                sb.append(i).append("\n");
            }
        }
        System.out.print(sb);
    }
}
```

![screenshot_2](https://github.com/Korpenter/club/assets/141184937/d8962407-8bcc-4339-a984-d202793744c9)
</details>

### Примечание
После написания решения я, ради интереса, нашёл и другие оптимизации в интернете, но в решение они добавлены
не были. [1]

### Источники:
1. https://codegolf.stackexchange.com/questions/215216/high-throughput-fizz-buzz