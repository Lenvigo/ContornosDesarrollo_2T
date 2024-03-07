
public class Frame {

    private char firstRoll;
    private char secondRoll;
    private char extraRoll;
    private char secondExtraRoll;

    public Frame(char firstRoll, char secondRoll){
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
        extraRoll = 0;
    }

    public Frame(char firstRoll, char secondRoll, char extraRoll) {
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
        this.extraRoll = extraRoll;
    }

    public Frame(char firstRoll, char secondRoll, char extraRoll, char secondExtraRoll){
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
        this.extraRoll = extraRoll;
        this.secondExtraRoll = secondExtraRoll;
    }

    public int getFirstRoll() {
        return getFirstRollScore();
    }

    public int getSecondRoll() {
        return getSecondRollScore();
    }
    public int getFrameScore(){
        return getFirstRollScore() + getSecondRollScore();
    }
    private int getFirstRollScore(){
        return switch (firstRoll) {
            case 'X' -> getStrikeScore();
            case '-' -> 0;
            default -> Character.getNumericValue(firstRoll);
        };
    }
    private int getSecondRollScore(){
        return switch (secondRoll) {
            case '/' -> getSpareScore();
            case '-' -> 0;
            default -> Character.getNumericValue(secondRoll);
        };
    }
    private int getSpareScore(){
        int total = 10 - getFirstRoll();
        switch (extraRoll){
            case 'X':
                return total += 10;
            case '-':
                return total;
            default:
                return total += Character.getNumericValue(extraRoll);
        }
    }
    private int getStrikeScore(){
        int total = 10;
        if (extraRoll == 'X'){
            total += 10;
        } else if(extraRoll != '-')
            total += Character.getNumericValue(extraRoll);
        if (secondExtraRoll == 'X')
            total += 10;
        else if (secondExtraRoll == '/' && extraRoll != 'X') {
            total += (10 - Character.getNumericValue(extraRoll));
        } else if (secondExtraRoll != '-')
            total += Character.getNumericValue(secondExtraRoll);

        return total;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Frame frame = (Frame) o;
        return firstRoll == frame.firstRoll && secondRoll == frame.secondRoll;
    }

}
