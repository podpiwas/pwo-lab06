package pwo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

public class Zadanie1 {

    public static final int FROM = 0, TO = 100;
    public static final String FILE_NAME = "fibseq100.txt";

    public static void main(String[] args) {

        System.out.println("Fibonacci wersja 2");

        boolean ok = SequenceTools.writeToFile(new FibonacciGenerator(), FROM, TO, FILE_NAME);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
            for (int i = 0; i <= 100; i++) {
                writer.write(Fibonacci(i).toString() + "\n");
            }
            writer.close();
        } catch (IOException ex) {
            System.out.println("Błąd");
            return;
        }

        if (ok) {
            System.out.println("Wynik zapisany do pliku: " + FILE_NAME);
        } else {
            System.out.println("Błąd");
        }
    }

    static BigDecimal Fibonacci(int n) {
        if (n == 0) return new BigDecimal(0);
        if (n == 1) return new BigDecimal(1);
        BigDecimal f0 = new BigDecimal(0);
        BigDecimal f1 = new BigDecimal(1);
        for (int i = 2; i <= n; i++) {
            BigDecimal m = new BigDecimal(0);
            m = m.add(f1);
            m = m.add(f0);
            f0 = f1;
            f1 = m;
        }
        return f1;
    }
}
