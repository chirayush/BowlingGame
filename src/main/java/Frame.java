import java.util.ArrayList;
import java.util.List;

class Frame {

    private List<Integer> rolls = new ArrayList<>();

    void addRoll(int pins) {
        rolls.add(pins);
    }

    int getScore() {
        return rolls.stream().mapToInt(Integer::intValue).sum();
    }

    boolean isSpare() {
        return getScore() == 10 && rolls.size() == 2;
    }

    boolean isStrike() {
        return getScore() == 10 && rolls.size() == 1;
    }

    int getScoreOfFirstRoll() {
        return rolls.get(0);
    }
}
