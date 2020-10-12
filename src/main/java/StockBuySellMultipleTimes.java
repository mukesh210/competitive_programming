import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class StockBuySellMultipleTimes {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int size = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            ArrayList<Interval> list = new ArrayList<>();

            int i = 0;
            while(i < size - 1) {
                while(i < size - 1 && arr[i] >= arr[i+1])
                    i++;

                if(i == size - 1)
                    break;

                Interval interval = new Interval();
                interval.buy = i++;

                while(i < size - 1 && arr[i] <= arr[i+1])
                    i++;

                interval.sell = i++;
                list.add(interval);
            }

            if(list.isEmpty()) {
                bw.write("No Profit");
            } else {
                for(Interval interval : list) {
                    bw.write("(" + interval.buy + " " + interval.sell + ")");
                }
            }
            bw.write("\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}

class Interval {
    int buy;
    int sell;
}