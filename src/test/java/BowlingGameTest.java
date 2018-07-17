import org.junit.Test;

import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BowlingGameTest {

    private BowlingGame game = new BowlingGame();

    @Test
    public void scoreShouldBeZeroForAGutterGame() {
        rollMany(20, 0);
        assertThat(0, is(game.score()));
    }

    @Test
    public void scoreShouldBeTenIfAllOnesRolled() {
        rollMany(20, 1);
        assertEquals(20, game.score());
    }

    @Test
    public void scoreShouldBeSixteenForOneSpare() {
        rollSpare();
        game.roll(3);
        rollMany(17, 0);
        assertEquals(16, game.score());
    }

    @Test
    public void scoreShouldBeSixteenWhenNoSpare() {
        game.roll(3);
        game.roll(5);
        game.roll(5);
        game.roll(3);
        rollMany(16, 0);
        assertEquals(16, game.score());
    }

    @Test
    public void scoreShouldBeForOneStrike() {
        rollStrike();
        game.roll(5);
        game.roll(3);
        rollMany(16, 0);
        assertEquals(26, game.score());
    }

    @Test
    public void scoreShouldBeThreeHundredForPerfectGame() {
        rollMany(12, 10);
        assertEquals(300, game.score());
    }

    private void rollStrike() {
        game.roll(10);
    }

    private void rollMany(int numberOfRolls, int score) {
        IntStream.range(0, numberOfRolls)
                .forEach(i -> game.roll(score));
    }

    private void rollSpare() {
        game.roll(5);
        game.roll(5);
    }
}
