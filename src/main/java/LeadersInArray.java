import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class LeadersInArray {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int length = Integer.parseInt(br.readLine());
            int[] inputArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int currentMax = 0;
            Stack<Integer> stack = new Stack<>();
            for(int i = length - 1; i >= 0; i--) {
                if(inputArr[i] >= currentMax) {
                    currentMax = inputArr[i];
                    stack.push(currentMax);
                }
            }
            while(!stack.isEmpty()) {
                bw.write(stack.pop() + " ");
            }

            bw.write("\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
