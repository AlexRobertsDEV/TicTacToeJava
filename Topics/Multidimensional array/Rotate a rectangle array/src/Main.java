import java.util.Scanner;

class Main {
    final static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] firstArray = createFirstArray(n, m);
        int[][] secondArray = createSecondArray(firstArray, m, n);
        printArray(secondArray);
    }

    public static int[][] createFirstArray(int rows, int cols) {
        int[][] array = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                array[row][col] = scanner.nextInt();
            }
        }
        return array;
    }

    public static int[][] createSecondArray(int[][] firstArray, int rows, int cols) {
        int[][] secondArray = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                secondArray[row][col] = firstArray[cols - col - 1][row];
            }
        }
        return secondArray;
    }


    private static void printArray(int[][] array) {
        for (int[] row : array) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

}