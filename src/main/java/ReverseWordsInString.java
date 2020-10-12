import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class ReverseWordsInString {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            String str = br.readLine();

            StringBuilder sb = new StringBuilder();

            int i = str.length() - 1;
            StringBuilder currentStr = new StringBuilder();
            while(i >= 0) {
                char currentChar = str.charAt(i);
                if(currentChar == '.') {
                    bw.write(currentStr + ".");
                    currentStr = new StringBuilder();
                } else {
                    currentStr.insert(0, str.charAt(i));
                }
                i--;
            }
            bw.write(currentStr + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
