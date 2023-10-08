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
