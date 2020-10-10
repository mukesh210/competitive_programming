import java.io.*;
import java.util.Arrays;

public class ReverseArrayInGroups {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine().trim());
        while(t-- > 0) {
            String[] str = br.readLine().split(" ");
            int size = Integer.parseInt(str[0]);
            int groupLength = Integer.parseInt(str[1]);
            groupLength = groupLength == 1 ? groupLength : groupLength - 1;

            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int i = 0;
            while(i < size) {
                int startIndex = i;
                int endIndex = i + groupLength;
                endIndex = endIndex < size ? endIndex : size - 1;

                swap(arr, startIndex, endIndex);

                i = i + groupLength + 1;
            }

            for(int j = 0; j < arr.length; j++) {
                bw.write(arr[j] + " ");
            }
            bw.write("\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static void swap(int[] arr, int startIndex, int endIndex) {
        while(startIndex <= endIndex) {
            int temp = arr[startIndex];
            arr[startIndex] = arr[endIndex];
            arr[endIndex] = temp;

            startIndex++;
            endIndex--;
        }
    }
}
