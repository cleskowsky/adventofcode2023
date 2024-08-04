package net.leskowsky;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Day1 {
    public static void main(String[] args) throws IOException {

        String digits = "0123456789";
        System.out.println(digits);
        System.out.println(digits.indexOf("1"));
        System.out.println("Hello world!");
        String s = "1abc2";
        System.out.println(s);

        // Part 1

        var is = Day1.class.getResourceAsStream("/day1.txt");
        var sum = new BufferedReader(new InputStreamReader(is))
                .lines()
                .map(line -> {
                    System.out.println(line);
                    var numbers = new ArrayList<Integer>();
                    for (char c : line.toCharArray()) {
                        var x = digits.indexOf(c);
                        if (x > -1) {
                            numbers.add(x);
                        }
                    }
                    return calibrationValue(numbers);
                })
                .reduce(0, Integer::sum);
        System.out.println(sum);
    }

    static int calibrationValue(List<Integer> nums) {
        return 10 * nums.get(0) + nums.getLast();
    }
}