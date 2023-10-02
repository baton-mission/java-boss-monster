package bossmonster.domain.scanner;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameInputScannerImpl
        implements GameInputScanner {
    Scanner sc = new Scanner(System.in);

    @Override
    public int inputNumber() {
        try {
            int input = sc.nextInt();
            sc.nextLine();

            return input;
        } catch (InputMismatchException e) {
            sc.next();
            throw new IllegalArgumentException("정수 값 외에는 입력할 수 없습니다.");
        }
    }

    @Override
    public String inputString() {
        return sc.nextLine();
    }

    @Override
    public int[] inputStringAndConvertToIntegerArrayBasedOnDelimiter(int countNumber, String delimiter) {
        String input = sc.nextLine();
        String[] inputArray = input.split(delimiter);

        checkInputCount(inputArray, countNumber);

        int[] convertResult = new int[inputArray.length];
        for (int i = 0; i < convertResult.length; i++) {
            convertResult[i] = convertStringToInteger(inputArray[i]);
        }

        return convertResult;
    }

    private void checkInputCount(String[] inputArray, int countNumber) {
        if (inputArray.length != countNumber) {
            throw new IllegalArgumentException("입력 값 개수가 유효하지 않습니다.");
        }
    }

    private int convertStringToInteger(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구분자로 구분된 입력 값은 정수만 가능합니다.");
        }
    }
}
