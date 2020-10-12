import java.io.*;
import java.util.Arrays;

public class SpiralTraversingMatrix {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            int[] size = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int m = size[0];
            int n = size[1];
            int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int[][] mat = new int[m][n];
            int count = 0;
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    mat[i][j] = arr[count++];
                }
            }

            int tr = 0;             // top row
            int br = m - 1;         // bottom row
            int lc = 0;             // left most column
            int rc = n - 1;         // right most column

            while(tr <= br && lc <= rc) {
                for(int i = lc; i <= rc; i++) {
                    writer.write(mat[tr][i] + " ");
                }
                tr++;

                for(int i = tr; i <= br; i++) {
                    writer.write(mat[i][rc] + " ");
                }
                rc--;

                if(tr <= br) {
                    for(int i = rc; i >= lc; i--) {
                        writer.write(mat[br][i] + " ");
                    }
                    br--;
                }

                if(lc <= rc) {
                    for(int i = br; i >= tr; i--) {
                        writer.write(mat[i][lc] + " ");
                    }
                    lc++;
                }
            }
            writer.write("\n");
        }

        reader.close();
        writer.flush();
        writer.close();
    }
}
