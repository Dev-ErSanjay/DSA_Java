package collections;

public class MaxSumNonAdjacent {

    public static int maxSumNonAdjacent(int[] arr) {

        if (arr == null || arr.length == 0)
            return 0;
        int include = arr[0];
        int exclude = 0;

        for (int i = 1; i < arr.length; i++) {

            int prevInclude = include;
            include = exclude + arr[i];
            exclude = Math.max(prevInclude, exclude);
        }

        return Math.max(include, exclude);
    }

    public static void main(String[] args) {

        int[] arr = { 100, 20, 20, 100 };
        System.out.println(maxSumNonAdjacent(arr));
    }

}
