package pl.kurs.range;

public class Range {

    private int rangeFrom;
    private int rangeTo;

    public Range(int rangeFrom, int rangeTo) throws IncorrectRange {
        if (rangeFrom > rangeTo) {
            throw new IncorrectRange("Incorrect Range");
        }
        this.rangeFrom = rangeFrom;
        this.rangeTo = rangeTo;
    }

    public boolean isInTheRange(int i) {
        return i >= rangeFrom && i <= rangeTo;
    }

    public int getRangeFrom() {
        return rangeFrom;
    }

    public void setRangeFrom(int rangeFrom) {
        this.rangeFrom = rangeFrom;
    }

    public int getRangeTo() {
        return rangeTo;
    }

    public void setRangeTo(int rangeTo) {
        this.rangeTo = rangeTo;
    }
}
