public class MissingNumber {
    public static void main(String args[]) {
        MissingNumber mn = new MissingNumber();
        System.out.println(mn.missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }

    public int missingNumber(int[] nums) {
        int length = nums.length;
        int sum = 0;
        for(int i = 0; i < length; i++) {
            sum += nums[i];
        }
        return (length*(length+1))/2 - sum;
    }
}
