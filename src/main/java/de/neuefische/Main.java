package de.neuefische;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int[] zahlen = new int[]{9, 1, 8, 2, 7, 3, 6, 4, 5};

        // sort
        zahlen = Arrays.stream(zahlen).sorted().toArray();
        System.out.println(Arrays.toString(zahlen));

        // sum
        int sum = Arrays.stream(zahlen).sum();
        System.out.println("Summe: " + sum);

        // product
        int productOfNumbers = Arrays
                .stream(zahlen)
                .reduce(1, (product, nextNumber) -> product * nextNumber);

        System.out.println(productOfNumbers);

        // Bonus
        try {
            Path path = Path.of("students.csv");

            List<Student> lines = Files.lines(path)
                    .skip(1)
                    .filter(x -> !x.equals(""))
                    .distinct()
                    .map(line -> line.split(","))
                    .filter(x -> x.length == 4)
                    .map(data -> new Student(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]))).toList();

            lines.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}