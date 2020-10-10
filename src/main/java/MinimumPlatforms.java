import java.io.*;
import java.util.*;

public class MinimumPlatforms {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine().trim());
        while(t-- > 0) {
            int trains = Integer.parseInt(br.readLine().trim());
            int[] arrivalTs = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int[] departureTs = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            Arrays.sort(arrivalTs);
            Arrays.sort(departureTs);

            int maxPlatforms = 1;
            int neededPlatforms = 1;

            int i = 1, j = 0;

            while(i < trains && j < trains) {
                if(arrivalTs[i] <= departureTs[j]) {
                    maxPlatforms++;
                    i++;
                } else {
                    maxPlatforms--;
                    j++;
                }

                if(maxPlatforms > neededPlatforms)
                    neededPlatforms = maxPlatforms;
            }

            bw.write(neededPlatforms + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}


/** Works but gives TLE

 public static void main(String args[]) throws IOException {
 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

 int t = Integer.parseInt(br.readLine().trim());
 while(t-- > 0) {
 int trains = Integer.parseInt(br.readLine().trim());
 int[] arrivalTs = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
 int[] departureTs = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

 HashMap<Integer, Integer> map = new HashMap<>();

 for(int i = 0; i < trains; i++) {
 if(list.isEmpty()) {
 map.put(1, departureTs[i]);
 } else {
 boolean platformFound = false;
 int platform = 1;
 while(map.containsKey(platform)) {
 int timeWhenPlatformWillBeFree = map.get(platform);
 if(timeWhenPlatformWillBeFree < arrivalTs[i]) {
 platformFound = true;
 map.put(platform, departureTs[i]);
 break;
 }
 platform++;
 }

 if(!platformFound) {
 map.put(platform, departureTs[i]);
 }
 }
 }

 bw.write(map.size() + "\n");
 }

 br.close();
 bw.flush();
 bw.close();
 }

 */
