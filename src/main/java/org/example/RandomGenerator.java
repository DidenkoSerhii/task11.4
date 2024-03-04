package org.example;

import java.util.stream.Stream;

public class RandomGenerator {

    public static Stream<Long> generateRandomStream(long a, long c, long m) {
        return Stream.iterate(new long[]{0L, 1L},
                        x -> new long[]{x[1], (a * x[1] + c) % m})
                .map(x -> x[1]);
    }

    public static void main(String[] args) {
        long a = 25214903917L;
        long c = 11L;
        long m = (long) Math.pow(2, 48);

        generateRandomStream(a, c, m)
                .limit(10)
                .forEach(System.out::println);
    }
}