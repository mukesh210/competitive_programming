import java.io.*;
import java.util.Arrays;
import java.util.stream.IntStream;

public class CoutingTriplets {
    public static void main(String args[]) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        OutputStreamWriter osw = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(osw);

        int t = Integer.parseInt(br.readLine());
        while(t > 0) {
            br.readLine();
            int[] inputArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(inputArr);

            int tripletsCount = -1;
            for(int currentIndex = 0; currentIndex < inputArr.length; currentIndex++) {
                for(int indexToAdd = currentIndex + 1; indexToAdd < inputArr.length; indexToAdd++) {
                    int sumToSearch = inputArr[currentIndex] + inputArr[indexToAdd];
                    int sumToSearchPossibleIndex = Arrays.binarySearch(inputArr, indexToAdd, inputArr.length, sumToSearch);

                    if(sumToSearchPossibleIndex > indexToAdd && sumToSearchPossibleIndex < inputArr.length){
                        if(tripletsCount == -1)
                            tripletsCount = 1;
                        else
                            tripletsCount++;
                    }
                }
            }

            bw.write(tripletsCount + "\n");
            t--;
        }

        bw.flush();

    }
}
