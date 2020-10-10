import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/find-the-duplicate-number/
 */

public class FindingDuplicates {

    public static void main(String args[]){
        FindingDuplicates fd = new FindingDuplicates();
        System.out.println(fd.findDuplicate(new int[]{1,3,4,2,2}));
    }

    public int findDuplicate(int[] nums) {

        /**
         * most optimal approach
         *
         * time complexity: O(n)
         * space complexity: O(1)
         */

        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);

        fast = nums[0];

        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;

        /**
         *
         * Time Complexity: O(n*logn) (using merge sort)
         * Space Complexity: O(1)
         * Downside: Array is getting distorted
         *
         */

        /*Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i + 1])
                return nums[i];
        }

        return -1;*/

        /**
         *
         * Time Complexity: O(n)
         * Space Complexity: O(n)
         *
         */
        /*Set<Integer> set = new HashSet<>();
        for(int i = 0;i < nums.length; i++) {
            if(set.contains(nums[i]))
                return nums[i];
            set.add(nums[i]);
        }

        return -1;*/

        /**
         *
         * Hashing
         *
         * Another approach would be to create an array of length n(frequencyArray)
         * For each element e in array:
         *  if frequencyArray[arr[e]] > 0
         *      return arr[e];
         *  frequencyArray[arr[e]]++;
         *
         */
    }

}
