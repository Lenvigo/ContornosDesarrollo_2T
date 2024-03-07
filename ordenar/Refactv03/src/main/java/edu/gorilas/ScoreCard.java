
public class ScoreCard {

    public static final int STRIKE = 10;
    public static final int SPARE = 10;
    public static final int ZERO = 0;
    public static final String PINS = "-123456789";

    private String scoreCard;
    private int totalScore;

    public ScoreCard() {
        this.scoreCard = "";
    }

    public ScoreCard(String scoreCard) {
        this.scoreCard = scoreCard;
    }

    public String getScoreCard() {
        return scoreCard;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public boolean isNormalRoll(char roll) {
        return roll != 'X' && roll != '/';
    }

    public int computePins(char pin) {
        return PINS.indexOf(pin);
    }

    public boolean isStrike(char roll) {
        return roll == 'X';
    }

    public int computeStrike(char roll) {
        return isStrike(roll) ? STRIKE : ZERO;
    }

    public boolean isSpare(char roll) {
        return roll == '/';
    }

    public int computeSpare(char roll) {
        return isSpare(roll) ? SPARE : ZERO;
    }

    public void sumTotalScore(int score) {
        totalScore += score;
    }

    public int bowlingCardScore(String scoreCard) {
        for (int roll = 0; roll < scoreCard.length(); roll++) {
            char result = scoreCard.charAt(roll);

            try {
                if (isNormalRoll(result)) {
                    if (roll == 20 && scoreCard.charAt(19) == '/') {
                        break;
                    } else if (roll == scoreCard.length() - 2 && scoreCard.charAt(roll - 1) == 'X') {
                        break;
                    }
                    sumTotalScore(computePins(result));
                }

                if (isSpare(result)) {
                    char nextResult = scoreCard.charAt(roll + 1);
                    char previousResult = scoreCard.charAt(roll - 1);
                    if (!isStrike(nextResult)) {
                        sumTotalScore(computeSpare(result) + computePins(nextResult) - computePins(previousResult));
                    } else if (isStrike(nextResult)) {
                        sumTotalScore(computeSpare(result) + computeStrike(nextResult) - computePins(previousResult));
                    }
                }

                if (isStrike(result)) {
                    char nextResult = scoreCard.charAt(roll + 1);
                    char nextResult2 = scoreCard.charAt(roll + 2);
                    if (isStrike(nextResult) && isStrike(nextResult2)) {
                        sumTotalScore(computeStrike(result) * 3);
                    } else if (isStrike(nextResult) && !isStrike(nextResult2)) {
                        sumTotalScore((computeStrike(result) * 2) + computePins(nextResult2));
                    } else if (isNormalRoll(nextResult) && isStrike(nextResult2)) {
                        sumTotalScore(computePins(nextResult) + computeStrike(result) * 2);
                    } else if (isNormalRoll(nextResult) && isSpare(nextResult2)) {
                        sumTotalScore(computeStrike(result) + computeSpare(nextResult2));
                    } else if (isNormalRoll(nextResult) && isNormalRoll(nextResult2)) {
                        sumTotalScore(computeStrike(result) + computePins(nextResult) + computePins(nextResult2));
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                return totalScore;
            }
        }
        return totalScore;
    }

    public int bowlingCardScore2(String scoreCard) {
        for (int roll = 0; roll < scoreCard.length(); roll++) {
            char result = scoreCard.charAt(roll);

            try {
                if (isNormalRoll(result)) {
                    sumTotalScore(computePins(result));
                } else if (isSpare(result)) {
                    char nextResult = scoreCard.charAt(roll + 1);
                    char previousResult = scoreCard.charAt(roll - 1);
                    sumTotalScore(computeSpareScore(result, nextResult, previousResult));
                } else if (isStrike(result)) {
                    char nextResult = scoreCard.charAt(roll + 1);
                    char nextResult2 = scoreCard.charAt(roll + 2);
                    sumTotalScore(computeStrikeScore(result, nextResult, nextResult2));
                }
            } catch (IndexOutOfBoundsException e) {
                return totalScore;
            }
        }
        return totalScore;
    }

    private int computeSpareScore(char currentResult, char nextResult, char previousResult) {
        int score = computeSpare(currentResult);
        if (!isStrike(nextResult)) {
            score += computePins(nextResult) - computePins(previousResult);
        } else {
            score += computeStrike(nextResult) - computePins(previousResult);
        }
        return score;
    }

    private int computeStrikeScore(char currentResult, char nextResult, char nextResult2) {
        int score = computeStrike(currentResult);
        if (isStrike(nextResult) && isStrike(nextResult2)) {
            score += computeStrike(currentResult) * 2 + computeStrike(nextResult2);
        } else if (isStrike(nextResult) && !isStrike(nextResult2)) {
            score += computeStrike(currentResult) + computePins(nextResult2);
        } else if (isNormalRoll(nextResult) && isStrike(nextResult2)) {
            score += computePins(nextResult) + computeStrike(currentResult);
        } else if (isNormalRoll(nextResult) && isSpare(nextResult2)) {
            score += computeStrike(currentResult) + computeSpare(nextResult2);
        } else if (isNormalRoll(nextResult) && isNormalRoll(nextResult2)) {
            score += computeStrike(currentResult) + computePins(nextResult) + computePins(nextResult2);
        }
        return score;
    }

}
