Faculty: Krok  
Course: Introduction to Java  
Author: Doronin Dmitrii Alekseevich  
Task: Week 1 Task 1  
Creation Date: 08.09.2023  

## Задание №1
Цель задания: Реализуйте программу, которая бы выводила на экран текст ‘Hello, Java ^^’

### Ход выполения задания:

Суть задания заключается в выводе простой строки. Строки, как правило, состоят из 
букв или других символов, и Java не исключение. В Java для представления символов 
используется тип char, у которого под капотом 16-bit unsigned integer.
.
```Java
char w = 'w';
```

В целом, можно было бы задать строку просто как массив таких символов и вывести его:
```Java
char[] hello = {'H','e','l','l','o',' ', 'J', 'a', 'v', 'a', ' ', '^', '^'};
System.out.println(hello);
```
<details>
<summary>Вывод</summary>

![screenshot_1](https://github.com/Korpenter/url-shortener/assets/141184937/9fe04722-aa93-4ea0-afb7-5286d0395086)
</details>

Но в подобных* задачах удобнее пользоваться классом String, который даёт возможность
использовать множество методов для работы со строками, например, конкатенацию, 
форматирование и сравнение. Важно заметить, для хранения символов в String 
используется byte[] вместо char[].
```Java
    // Использовать литерал
    String helloLiteral = "Hello, Java ^^"

    // Использовать конструктор
    char[] hello = {'h','e','l','l','o',' ', 'J', 'a', 'v', 'a', ' ', '^', '^'};
    String heelloContsr = new String(hello)
            
    // Или сразу        
    String helloJavaConstr = new String("Hello, Java ^^")

    // А если мы хотим вывести строку только 1 раз, то можно просто 
    System.out.println("Hello, Java ^^");
```
Таким образом, итоговая версия программы для вывода строки 'Hello, Java ^^' будет:
```Java
package homework.krok;

public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello, Java ^^");
    }
}

```

![Program Launch](https://github.com/Korpenter/url-shortener/assets/141184937/f5ed9e30-cc7e-4247-9698-b508d99ea156)


### *Примечание 
Так как объекты String являются неизменяемыми, в задачах, в которых требуется 
как-то наращивать или по-другому изменять строки, каждая такая операция приводит к
созданию новой строки, ухудшая производительность. Для избежания этого можно 
использовать StringBuilder и StringBuffer. Эти классы позволяют создавать изменяемые
последовательности символов без реаллокации (создания новых объектов). Их основное
отличие в том, что StringBuffer даёт гарантию многопоточности, а StringBuilder - 
нет (но работает быстрее).

### Источники:
1. https://docs.oracle.com/javase/tutorial/java/data/strings.html
2. https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html
2. https://habr.com/ru/articles/260767/
3. https://www.digitalocean.com/community/tutorials/string-vs-stringbuffer-vs-stringbuilder