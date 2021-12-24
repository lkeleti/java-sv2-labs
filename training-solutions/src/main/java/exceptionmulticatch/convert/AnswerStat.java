package exceptionmulticatch.convert;

public class AnswerStat {
    private BinaryStringConverter binaryStringConverter;

    public AnswerStat(BinaryStringConverter binaryStringConverter) {
        this.binaryStringConverter = binaryStringConverter;
    }

    public boolean[] convert(String text) {
        try {
            return binaryStringConverter.binaryStringToBooleanArray(text);
        }
        catch (NullPointerException | IllegalArgumentException ex) {
            throw new InvalidBinaryStringException("",ex);
        }
    }

    public int answerTruePercent(String answers) {
        boolean[] binaryDatas = convert(answers);
        int counter = 0;
        for (boolean b : binaryDatas) {
            if (b) {
                counter++;
            }
        }
        return counter*100/binaryDatas.length;
    }
}
