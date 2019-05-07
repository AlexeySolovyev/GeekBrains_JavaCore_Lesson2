import exception.MyArrayDataException;
import exception.MyArraySizeException;

public class Homework {

    private final static int SIZE = 4;

    public static void main(String[] args) {

        String testArray1[][] = {
                {"10", "2", "3", "4"},
                {"-1", "21", "-31", "4"},
                {"1", "200", "3", "40"},
                {"1", "22", "-35", "4"}};

        String testArray2[][] = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}};

        String testArray3[][] = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3"},
                {"1", "2", "3", "4"}};

        String testArray4[][] = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "ujljlkh", "4"},
                {"1", "2", "3", "4"}};

        try {
            System.out.println("Сумма массива 1: " + calcArraySum(testArray1));
        } catch (MyArraySizeException | MyArrayDataException exception) {
            System.out.println(exception);
        }

        try {
            System.out.println("Сумма массива 2: " + calcArraySum(testArray2));
        } catch (MyArraySizeException | MyArrayDataException exception) {
            System.out.println(exception);
        }

        try {
            System.out.println("Сумма массива 3: " + calcArraySum(testArray3));
        } catch (MyArraySizeException | MyArrayDataException exception) {
            System.out.println(exception);
        }

        try {
            System.out.println("Сумма массива 4: " + calcArraySum(testArray4));
        } catch (MyArraySizeException | MyArrayDataException exception) {
            System.out.println(exception);
        }
    }

    private static int calcArraySum(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int result = 0;

        if (arr.length != SIZE) {
            throw new MyArraySizeException();
        }

        for (int i=0; i<arr.length; i++) {
            if (arr[i].length != SIZE) {
                throw new MyArraySizeException();
            }

            for (int j=0; j<arr[i].length; j++) {
                try {
                    result += Integer.valueOf(arr[i][j]);
                } catch (NumberFormatException exception) {
                    throw new MyArrayDataException(i, j, arr[i][j], exception);
                }
            }
        }

        return result;
    }
}