import java.io.*;
import java.util.Arrays;

public class ElementsWithLeftSmallerRightGreater {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int size = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            int[] leftMax = new int[size];
            int[] rightMin = new int[size];
            for(int i = 0; i < size; i++) {
                leftMax[i] = i == 0 ? arr[i] : Math.max(leftMax[i-1], arr[i]);
            }

            for(int i = size - 1; i >= 0; i--) {
                rightMin[i] = i == size - 1 ? arr[i] : Math.min(rightMin[i+1], arr[i]);
            }

            int index = -1;
            for(int i = 1; i < size - 1; i++) {
                if(leftMax[i] == arr[i] && rightMin[i] == arr[i]) {
                    index = i;
                    break;
                }
            }
            int ans = index == -1 ? index : arr[index];

            bw.write(ans + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
