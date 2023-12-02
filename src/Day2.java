import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Day2 {
    public static void main(String[] args) {
        System.out.println(1);
    }

    public static int parseGameID(String s) {
        return Integer.parseInt(s.replaceAll("[^0-9]", ""));
    }

    public static Round parseRound(String s) {
        var ret = new Round();
        for (String colour : s.split(", ")) {
            var split = colour.split(" ");
            ret.put(split[1], Integer.parseInt(split[0]));
        };
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

    record Game(int id, List<Round> rounds) {}

    static class Round extends HashMap<String, Integer> {
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
            return get(s) != null ? get(s) : null;
        }
    }
}
