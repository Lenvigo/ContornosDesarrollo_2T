import java.util.Arrays;

public class Scorecard {
    private String rolls;
    private Frame[] frames = new Frame[10];


    public Scorecard(String rolls) {
        this.rolls = rolls;
        createFrames();
    }

    public String getRolls() {
        return rolls;
    }

    public Frame[] getFrames() {
        return frames;
    }

    private void createFrames(){
        int j = 0;
        for (int i = 0; i < 10; i++){
            if (rolls.charAt(j + 1) == '/'){
                frames[i] = new Frame(rolls.charAt(j),rolls.charAt(j + 1), rolls.charAt(j + 2));
            } else if (rolls.charAt(j) == 'X') {
                frames[i] = new Frame(rolls.charAt(j), '-', rolls.charAt(j + 1), rolls.charAt(j + 2));
                j--;
            } else {
                frames[i] = new Frame(rolls.charAt(j), rolls.charAt(j + 1));
            }
            j += 2;
        }
    }

    public int getTotalScore(){
        return Arrays.stream(frames).mapToInt(Frame::getFrameScore).sum();
    }
}
