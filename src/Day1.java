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

// Neat solution to day 2 !!
// https://github.com/ataustin/advent-of-code/blob/main/y2023/d01/solution.R
//
// input <- readLines("input.txt")
//
// decode <- function(input) {
// nums <- gsub("[a-z]", "", input)
// digs <- paste0(substr(nums, 1, 1), substr(nums, nchar(nums), nchar(nums)))
// sum(as.integer(digs))
// }
//
//
// ## Part 1
// decode(input)
//
//
// ### Part 2
// digs <- c(twone = 21, eightwo = 82, oneight = 18,
// five = 5, nine = 9, eight = 8, two = 2, three = 3, one = 1,
// four = 4, six = 6, seven = 7)
//
// for(num in names(digs)) {
// input <- gsub(num, digs[num], input)
// }
//
// decode(input)