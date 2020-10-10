import java.io.*;
import java.util.Arrays;

public class PythagoreanTriplet {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int size = Integer.parseInt(br.readLine());
            int[] inputArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            boolean ans = new Solution().checkTriplet(inputArr, size);
            System.out.println(ans ? "Yes" :  "No");
        }

        br.close();
    }
}

class Solution {
    boolean checkTriplet(int[] arr, int n) {
        int[] squared = Arrays.stream(arr).map(x -> x * x).toArray();
        Arrays.sort(squared);

        boolean doTripletExist = false;
        for(int i = arr.length - 1; i >= 0; i--) {
            doTripletExist = apply2PointerTechnique(squared, i);
            if(doTripletExist)
                return true;
        }

        return doTripletExist;
    }

    boolean apply2PointerTechnique(int[] arr, int fixedElemIndex) {
        int left = 0;
        int right = fixedElemIndex - 1;

        boolean doSolutionExist = false;
        while(!doSolutionExist && left < right) {
            if(arr[left] + arr[right] == arr[fixedElemIndex])
                doSolutionExist = true;
            else if(arr[left] + arr[right] < arr[fixedElemIndex])
                left++;
            else
                right--;
        }


        return doSolutionExist;
    }
}