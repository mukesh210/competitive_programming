import java.io.*;
import java.util.Arrays;

public class KadaneAlgorithm {
    public static void main(String args[]) throws IOException {
        KadaneAlgorithm ka = new KadaneAlgorithm();
        int maxSubArraySum = ka.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        System.out.println(maxSubArraySum);
    }

    public int maxSubArray(int[] nums) {
        int max_so_far = nums[0];
        int max_ending_here = nums[0];

        for(int i = 1; i < nums.length; i++) {
            max_ending_here = Math.max(nums[i], nums[i] + max_ending_here);
            max_so_far = Math.max(max_so_far, max_ending_here);
        }

        return max_so_far;
    }
}
