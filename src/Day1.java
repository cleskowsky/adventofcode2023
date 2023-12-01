import java.nio.file.Files;
import java.nio.file.Path;

public class Day1 {
    public static int[] digits(String s) {
        return s.chars()
                .filter(Character::isDigit)
                .map(x -> Character.digit(x, 10))
                .toArray();
    }

    public static int calibrationValue(String s) {
        var digits = digits(s);
        return digits[0] * 10 + digits[digits.length - 1];
    }

    public static void main(String[] args) throws Exception {
        var x = Files.readAllLines(Path.of("inputs/day1.txt")).stream()
                .map(Day1::calibrationValue)
                .reduce(Integer::sum);
        System.out.println(x);
    }
}
