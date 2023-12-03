import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Day2 {
    public static void main(String[] args) throws Exception {
        var in = Files.readAllLines(Path.of("inputs/day2.txt"));

        var games = in.stream()
                .map(Day2::parseGame)
                .collect(Collectors.toList());

        System.out.println(part1(games));
        System.out.println(part2(games));
    }

    public static int part1(List<Game> games) {
        var sum = 0;

        for (Game g : games) {
            boolean possible = true;
            for (Round r : g.rounds) {
                if (r.red() > 12 || r.green() > 13 || r.blue() > 14) {
                    possible = false;
                }
            }

            if (possible) {
                sum += g.id;
            }
        }
        return sum;
    }

    // Min cubes making all rounds possible
    public static int part2(List<Game> games) {
        int sum = 0;
        for (Game g : games) {
            // Find min cubes in bag
            int red = 0;
            int green = 0;
            int blue = 0;
            for (Round r : g.rounds) {
                red = Math.max(red, r.red());
                blue = Math.max(blue, r.blue());
                green = Math.max(green, r.green());
            }

            // Then get power
            var power = red * blue * green;

            // Add power to sum
            sum += power;
        }
        return sum;
    }

    public static int parseGameID(String s) {
        return Integer.parseInt(s.replaceAll("[^0-9]", ""));
    }

    public static Round parseRound(String s) {
        var ret = new Round();
        for (String colour : s.split(", ")) {
            var split = colour.split(" ");
            ret.put(split[1], Integer.parseInt(split[0]));
        }
        return ret;
    }

    public static List<Round> parseRounds(String s) {
        var ret = new ArrayList<Round>();
        for (String round : s.split("; ")) {
            ret.add(parseRound(round));
        }
        return ret;
    }

    public static Game parseGame(String s) {
        var split = s.split(": ");
        return new Game(parseGameID(split[0]), parseRounds(split[1]));
    }

    public record Game(int id, List<Round> rounds) {}

    public static class Round extends HashMap<String, Integer> {
        public int blue() {
            return getColour("blue");
        }

        public int red() {
            return getColour("red");
        }

        public int green() {
            return getColour("green");
        }

        private int getColour(String s) {
            return get(s) != null ? get(s) : 0;
        }
    }
}