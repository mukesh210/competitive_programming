import java.util.Arrays;

public class NextPermutation {
    public static void main(String args[]) {
        NextPermutation np = new NextPermutation();
        int[] input = {1, 3, 2};
        np.nextPermutation(input);

        for(int element : input)
            System.out.print(element + " ");
        System.out.println();
    }

    public void nextPermutation(int[] nums) {
        boolean found = false;

        for(int i = nums.length - 1; i > 0; i--) {
            if(nums[i-1] < nums[i]) {
                // we know that i-1 is the index which we need to consider
                int currentSuccessorIndex = getSuccessorIndex(nums, i, nums[i-1]);
                int temp = nums[i-1];
                nums[i-1] = nums[currentSuccessorIndex];
                nums[currentSuccessorIndex] = temp;

                Arrays.sort(nums, i, nums.length);

                found = true;
                break;
            }
        }

        if(!found) {
            Arrays.sort(nums);
        }
    }

    public int getSuccessorIndex(int[] nums, int startIndex, int number) {
        int currentSuccessorIndex = startIndex;

        for(int i = startIndex; i < nums.length; i++) {
            if(nums[i] > number && nums[i] < nums[currentSuccessorIndex]) {
                currentSuccessorIndex = i;
            }
        }

        return currentSuccessorIndex;
    }
}
