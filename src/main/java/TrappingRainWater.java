import java.io.*;
import java.util.Arrays;

public class TrappingRainWater {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int size = Integer.parseInt(br.readLine());
            int[] inputArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] leftMaxArr = getLeftMaxArr(inputArr);
            int[] rightMaxArr = getRightMaxArr(inputArr);

            int totalSum = 0;
            for(int i = 1; i < size-1; i++) {
                totalSum += Math.min(leftMaxArr[i], rightMaxArr[i]) - inputArr[i];
            }

            bw.write(totalSum + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static int[] getLeftMaxArr(int[] arr) {
        int[] leftMaxArr = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            leftMaxArr[i] = i > 0 ? Math.max(leftMaxArr[i - 1], arr[i]) : arr[i];
        }

        return leftMaxArr;
    }

    public static int[] getRightMaxArr(int[] arr) {
        int[] rightMaxArr = new int[arr.length];
        for(int i = arr.length - 1; i >= 0; i--) {
            rightMaxArr[i] = i < arr.length - 1 ? Math.max(rightMaxArr[i + 1], arr[i]) : arr[i];
        }

        return rightMaxArr;
    }
}
