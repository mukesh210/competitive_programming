import java.io.*;
import java.util.Arrays;

public class LastIndexOf1 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String str = br.readLine();
            int index = -1;
            for(int i = str.length() - 1; i >= 0; i--) {
                if(str.charAt(i) == '1') {
                    index = i;
                    break;
                }
            }

            bw.write(index + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
