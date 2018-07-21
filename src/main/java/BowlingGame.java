import java.util.ArrayList;
import java.util.List;

final class BowlingGame {

    private Frame currentFrame;
    private int frameIndex = 0;
    private List<Frame> frames;

    BowlingGame() {
        frames = new ArrayList<>();
    }

    void roll(int pins) {
        if (frameIndex == 0) {
            currentFrame = new Frame();
            currentFrame.addRoll(pins);
            if (pins == 10) {
                frames.add(currentFrame);
                return;
            }
            frameIndex++;
            return;
        }
        if (frameIndex == 1) {
            currentFrame.addRoll(pins);
            frameIndex = 0;
            frames.add(currentFrame);
        }
    }

    int score() {
        int score = 0;
        for (int frameIndex = 0; frameIndex < frames.size(); frameIndex++) {
            Frame frame = frames.get(frameIndex);
            if (frame.isStrike()) {
                score += 10 + strikeBonus(frameIndex);
            } else if (frame.isSpare()) {
                score += 10 + spareBonus(frameIndex);
            } else {
                score += frame.getScore();
            }
        }
        return score;
    }

    private int strikeBonus(int frameIndex) {
        return getNextFrame(frameIndex).getScore();
    }

    private int spareBonus(int frameIndex) {
        return getNextFrame(frameIndex).getScoreOfFirstRoll();
    }

    private Frame getNextFrame(int frameIndex) {
        return frames.get(frameIndex + 1);
    }
}
