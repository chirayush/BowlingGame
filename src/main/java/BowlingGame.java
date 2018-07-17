final class BowlingGame {
    private int currentRoll = 0;
    private int[] rolls = new int[21];

    void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    int score() {
        int score = 0;
        int frameIndex = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(frameIndex)) {
                score += 10 + strikeBonus(frameIndex);
                frameIndex += 1;
            } else if (isSpare(frameIndex)) {
                score += 10 + spareBonus(rolls[frameIndex + 2]);
                frameIndex += 2;
            } else {
                score += frameTotal(frameIndex);
                frameIndex += 2;
            }
        }
        return score;
    }

    private int frameTotal(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1];
    }

    private int spareBonus(int roll) {
        return roll;
    }

    private int strikeBonus(int frameIndex) {
        return rolls[frameIndex + 1] + rolls[frameIndex + 2];
    }

    private boolean isStrike(int frameIndex) {
        return rolls[frameIndex] == 10;
    }

    private boolean isSpare(int frameIndex) {
        return frameTotal(frameIndex) == 10;
    }
}
