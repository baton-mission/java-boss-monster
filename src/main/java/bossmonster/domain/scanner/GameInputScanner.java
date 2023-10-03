package bossmonster.domain.scanner;

public interface GameInputScanner {
    int inputNumber();

    String inputString();

    int[] inputStringAndConvertToIntegerArrayBasedOnDelimiter(int countNumber, String delimiter);
}
