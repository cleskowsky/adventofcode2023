import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Day1 {

    public static boolean PART_B = true;

    public static List<Integer> digits(String s) {
        var digits = "0123456789";
        var wordDigits = List.of("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");

        var ret = new ArrayList<Integer>();
        for (int i = 0; i < s.length(); i++) {
            var c = s.charAt(i);

            if (digits.contains(String.valueOf(c))) {
                ret.add(digits.indexOf(c));
                continue;
            }

            if (PART_B) {
                for (String d: wordDigits) {
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
