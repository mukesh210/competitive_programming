import java.util.Arrays;
import java.util.Vector;
import java.util.stream.Collectors;

public class SortColors {
    public static void main(String args[]) {
        SortColors sc = new SortColors();
        int[] result = sc.sortColors(new int[]{2, 0, 2, 1, 1, 0});
        for(int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public void sortColorsOptimalApproachIn1Pass(int[] nums) {
        int zerosEndingIndex = 0;
        int twosStartingIndex = nums.length - 1;
        int index = 0;

        while(index <= twosStartingIndex) {
            if(nums[index] == 0) {
                nums[index] = nums[zerosEndingIndex];
                nums[zerosEndingIndex] = 0;
                zerosEndingIndex++;
            } else if(nums[index] == 2) {
                nums[index] = nums[twosStartingIndex];
                nums[twosStartingIndex] = 2;
                index--;
                twosStartingIndex--;
            }
            index++;
        }
    }



    public int[] sortColors(int[] nums) {
        Integer[] trackingArr = new Integer[2];
        Arrays.fill(trackingArr, 0);

        Vector<Integer> input = new Vector<Integer>(Arrays.stream(nums).boxed().collect(Collectors.toList()));

        for(int i = 0; i < input.size(); i++) {
            if(input.get(i) == 0 || input.get(i) == 1) {
                int currentElement = input.remove(i);
                input.add(trackingArr[currentElement], currentElement);
                trackingArr = incrementArrFromIndex(trackingArr, currentElement);
            }
        }

        int[] resultArr = new int[input.size()];
        int count = 0;
        for(int i = 0;i < input.size(); i++) {
            resultArr[count++] = input.get(i);
        }

        return resultArr;
    }

    public Integer[] incrementArrFromIndex(Integer[] trackingArr, int index) {
        for(int i = index; i < trackingArr.length; i++) {
            trackingArr[i]++;
        }

        return trackingArr;
    }

}
