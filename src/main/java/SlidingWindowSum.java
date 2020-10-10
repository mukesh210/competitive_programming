import java.io.*;
import java.util.Arrays;

public class SlidingWindowSum {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        OutputStreamWriter osw = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(osw);

        int testCases = Integer.parseInt(br.readLine());
        while(testCases > 0) {
            String[] arr = br.readLine().split(" ");
            long requiredSum = Long.parseLong(arr[1]);
            long[] inputArr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

            int startIndex = 0;
            int endIndex = 0;
            boolean success = false;
            long currentSum = inputArr[startIndex];
            while(startIndex < inputArr.length && endIndex < inputArr.length) {
                if(currentSum == requiredSum) {
                 success = true;
                 break;
                } else if(currentSum < requiredSum) {   // include one more element from end
                    endIndex++;
                    if(endIndex < inputArr.length)
                        currentSum += inputArr[endIndex];
                    else
                        break;
                } else if(currentSum > requiredSum) {   // exclude element from startIndex
                    currentSum -= inputArr[startIndex];
                    startIndex++;
                }
            }

            if(success)
                bw.write((startIndex + 1) + " " + (endIndex + 1) + "\n");
            else
                bw.write("-1" + "\n");

            testCases--;
        }
        bw.flush();
    }
}
