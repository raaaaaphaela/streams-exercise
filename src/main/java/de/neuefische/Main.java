package de.neuefische;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
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
        parseCSV().forEach(System.out::println);
    }

    public static List<Student> parseCSV() {
        List<Student> students = new ArrayList<>();
        try {
            Path path = Path.of("students.csv");

            students = Files.lines(path)
                    .skip(1)
                    .filter(x -> !x.equals(""))
                    .distinct()
                    .map(line -> line.split(","))
                    .filter(x -> x.length == 4)
                    .filter(x -> {
                        try {
                            Integer.parseInt(x[0]);
                            Integer.parseInt(x[3]);
                            return true;
                        } catch (NumberFormatException e) {
                            return false;
                        }
                    })
                    .map(data -> new Student(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]))).toList();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return students;
    }
}