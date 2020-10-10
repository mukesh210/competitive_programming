import java.io.*;
import java.util.Arrays;

public class EquilibriumPoint {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            br.readLine();
            int[] inputArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            if(inputArr.length == 1) {
                bw.write(1 + "\n");
            } else if(inputArr.length == 2)
                bw.write(-1 + "\n");
            else {
                long[] prefixSum = new long[inputArr.length];
                for(int i = 0; i < inputArr.length; i++) {
                    if(i == 0) {
                        prefixSum[i] = inputArr[i];
                    } else {
                        prefixSum[i] = prefixSum[i-1] + inputArr[i];
                    }
                }

                int pos = -1;
                for(int i = 1; i < inputArr.length; i++) {
                    long prevSum = prefixSum[i-1];
                    long nextSum = prefixSum[inputArr.length - 1] - prefixSum[i];
                    if(prevSum == nextSum)
                        pos = i + 1;
                }

                bw.write(pos + "\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
