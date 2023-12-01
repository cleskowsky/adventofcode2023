import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Day1 {

    public static boolean PART_B = false;

    public static List<String> wordDigits = List.of("zero",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine"
    );

    public static List<Integer> digits(String s) {
        var ret = new ArrayList<Integer>();
        for (int i = 0; i < s.length(); i++) {
            var c = s.charAt(i);

            if (Character.isDigit(c)) {
                ret.add(Character.digit(c, 10));
                continue;
            }

            if (PART_B) {
                for (String d : wordDigits) {
                    if (s.startsWith(d, i)) {
                        ret.add(wordDigits.indexOf(d));
                        break;
                    }
                }
            }
        }

        return ret;
    }

    public static int calibrationValue(String s) {
        System.out.println(s);

        var digits = digits(s);
        System.out.println(digits);

        return digits.get(0) * 10 + digits.get(digits.size() - 1);
    }

    public static void main(String[] args) throws Exception {
        var x = Files.readAllLines(Path.of("inputs/day1.txt")).stream()
                .map(Day1::calibrationValue)
                .reduce(Integer::sum);
        System.out.println(x);
    }
}
