public class MergeSortedArray {
    public static void main(String args[]) {
        MergeSortedArray msa = new MergeSortedArray();
        int[] firstArr = new int[]{1, 2, 3, 0, 0, 0};
        int[] secondArr = new int[]{2, 5, 6};
        msa.merge1(firstArr, 3, secondArr, 3);
        for(int element : firstArr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }


    /**
     *
     * Populating from back in nums1 array
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int firstArrEndIndex = m - 1;
        int secondArrEndIndex = n - 1;
        int finished = m + n - 1;

        while(finished >= 0 && firstArrEndIndex >= 0 && secondArrEndIndex >= 0) {
            nums1[finished--] = nums1[firstArrEndIndex] > nums2[secondArrEndIndex] ?
                    nums1[firstArrEndIndex--] : nums2[secondArrEndIndex--];
        }

        while(secondArrEndIndex >= 0 && finished >= 0) {
            nums1[finished--] = nums2[secondArrEndIndex--];
        }
    }

    /**
     *
     * Populating from front in nums1 array
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1Index = 0;
        int nums2Index = 0;

        while(nums1Index < m && nums2Index < nums2.length) {
            if(nums1[nums1Index] <= nums2[nums2Index]) {
                nums1Index++;
            } else if(nums1[nums1Index] > nums2[nums2Index]) {
                moveElementRightBy1(nums1, nums1Index);
                nums1[nums1Index] = nums2[nums2Index];
                nums1Index++;
                nums2Index++;
                m++;
            }
        }
        while(nums2Index < nums2.length && nums1Index < nums1.length) {
            nums1[nums1Index] = nums2[nums2Index];
            nums1Index++;
            nums2Index++;
        }
    }

    public void moveElementRightBy1(int[] arr, int index) {
        for(int i = arr.length - 1; i > index && i > 0; i--) {
            arr[i] = arr[i-1];
        }
    }
}
