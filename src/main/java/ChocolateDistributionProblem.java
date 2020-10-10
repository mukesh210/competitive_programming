import java.io.*;
import java.util.Arrays;

public class ChocolateDistributionProblem {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int size = Integer.parseInt(br.readLine());
            int[] inputArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int childrens = Integer.parseInt(br.readLine());

            Arrays.sort(inputArr);
            int minimumDiff = Integer.MAX_VALUE;
            for(int rangeMinIndex = 0; rangeMinIndex < size; rangeMinIndex++) {
                int rangeMaxIndex = rangeMinIndex + childrens - 1;
                if(rangeMaxIndex < size) {
                    minimumDiff = Math.min(minimumDiff, inputArr[rangeMaxIndex] - inputArr[rangeMinIndex]);
                }
            }

            bw.write(minimumDiff + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
