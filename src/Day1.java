import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class Day1 {
    public static int[] digits(String s) {
        return s.chars()
                .filter(Character::isDigit)
                .map(x -> Character.digit(x, 10))
                .toArray();
    }

    public static int calibrationValue(String s) {
        var digits = digits(s);
        System.out.println(Arrays.toString(digits));
        return digits[0] * 10 + digits[digits.length - 1];
    }

    public static String wordsToDigits(String s) {
        var wordList = List.of("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
        var x = s;
        for (int i = 0; i < wordList.size(); i++) {
            x = x.replaceAll(wordList.get(i), Integer.toString(i));
        }
        System.out.println(x);
        return x;
    }

    public static void main(String[] args) throws Exception {
//        var x = Files.readAllLines(Path.of("inputs/day1.txt")).stream()
//                .map(Day1::calibrationValue)
//                .reduce(Integer::sum);
//        System.out.println(x);

        var y = Files.readAllLines(Path.of("inputs/day1.txt")).stream()
                .map(Day1::wordsToDigits)
                .map(Day1::calibrationValue)
                .reduce(Integer::sum);
        System.out.println(y);
    }
}
