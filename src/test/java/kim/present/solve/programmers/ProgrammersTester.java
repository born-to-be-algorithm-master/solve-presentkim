package kim.present.solve.programmers;


public class ProgrammersTester {

    public static int[] copy(int[] input) {
        return input.clone();
    }

    public static int[][] copy(int[][] input) {
        int[][] result = new int[input.length][input[0].length];

        for (int y = 0; y < input.length; y++) {
            result[y] = copy(input[y]);
        }

        return result;
    }

    public static String[] copy(String[] input) {
        return input.clone();
    }

    public static String[][] copy(String[][] input) {
        String[][] result = new String[input.length][input[0].length];

        for (int y = 0; y < input.length; y++) {
            result[y] = copy(input[y]);
        }

        return result;
    }
}
