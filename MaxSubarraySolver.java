public class MaxSubarraySolver {
    public static int bruteForce(int[] arr) {
        int maxSum = arr[0];

    for (int i = 0; i < arr.length; i ++) {
        int sum = 0;

        for (int j = i; j < arr.length; j++) {
            sum+= arr[j];

            if (sum > maxSum) {
                maxSum = sum;
            }
        }
    }
    return maxSum;
}
public static int kadane(int[] arr) {
    int currentSum = arr[0];
    int maxSum= arr[0];

    for (int i = 1; i < arr.length; i++) {
        currentSum = Math.max(arr[i], currentSum + arr[i]);
        maxSum = Math.max(maxSum, currentSum);
    }
    return maxSum;
}
}
