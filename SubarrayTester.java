import java.util.Random;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
public class SubarrayTester {
    public static void main(String[] args) {

        int[] sizes = {1000, 5000, 10000, 50000, 100000};
        Random random = new Random(42);

        try (PrintWriter out =
                new PrintWriter(new FileWriter("subarray_results.csv"))) {

            out.println("Size,Algorithm,TimeMillis,MaxSum");

            for (int n : sizes) {
                int[] arr = new int[n];

                for (int i = 0; i < n; i++) {
                    arr[i] = random.nextInt(201) - 100;
                }

                if (n <= 10000) {
                    long start = System.nanoTime();
                    int result = MaxSubarraySolver.bruteForce(arr);
                    long end = System.nanoTime();

                    double time = (end - start) / 1_000_000.0;

                    System.out.printf(
                        "n=%d | Brute Force | %.3f ms | Sum=%d%n",
                        n, time, result);

                    out.printf("%d,Brute Force,%.6f,%d%n",
                        n, time, result);
                }

                long start = System.nanoTime();
                int result = MaxSubarraySolver.kadane(arr);
                long end = System.nanoTime();

                double time = (end - start) / 1_000_000.0;

                System.out.printf(
                    "n=%d | Kadane | %.3f ms | Sum=%d%n",
                    n, time, result);

                out.printf("%d,Kadane,%.6f,%d%n",
                    n, time, result);
            }

            System.out.println("Results saved to subarray_results.csv");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
