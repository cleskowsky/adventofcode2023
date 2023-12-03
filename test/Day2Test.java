import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day2Test {

    @Test
    void parseGameID() {
        var x = Day2.parseGameID("Game 1");
        assertEquals(1, x);
    }

    @Test
    void parseRound() {
        var x = Day2.parseRound("3 blue, 4 red");
        assertEquals(3, x.blue());
        assertEquals(4, x.red());
    }

    @Test
    void parseRounds() {
        var x = Day2.parseRounds("3 blue, 4 red; 2 green");
        assertEquals(2, x.size());
        assertEquals(2, x.get(1).green());
    }

    @Test
    void parseGame() {
        var x = Day2.parseGame("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green");
        assertEquals(1, x.id());
        assertEquals(3, x.rounds().size());
    }
}