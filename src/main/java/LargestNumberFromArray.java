import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LargestNumberFromArray {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int size = Integer.parseInt(br.readLine());
            String[] arr = br.readLine().split(" ");

            String answer = new Solution2().printLargest(arr);
            bw.write(answer + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}

class Solution2 {
    String printLargest(String[] arr) {
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String first, String second) {
                String aTemp = first + second;
                String bTemp = second + first;
                int result = aTemp.compareTo(bTemp);

                if(result < 0)
                    return 1;
                else return -1;
            }
        });

        StringBuilder sb = new StringBuilder();
        for(String elem : arr) {
            sb.append(elem);
        }
        return sb.toString();
    }
}
