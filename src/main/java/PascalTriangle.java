import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/
 */
public class PascalTriangle {
    public static void main(String args[]) {
        PascalTriangle pt = new PascalTriangle();
        List<List<Integer>> pascalTriangle = pt.generate(0);

        System.out.println(pascalTriangle);

//        for(int i = 0; i < pascalTriangle.size(); i++) {
//            List<Integer> list = pascalTriangle.get(0);
//            for(int j = 0; j < list.size(); j++) {
//                System.out.print(pascalTriangle);
//            }
//            System.out.println();
//        }
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new LinkedList<>();
        if(numRows == 0) return result;
        result.add(Arrays.asList(1));
        if(numRows == 1) return result;
        result.add(Arrays.asList(1, 1));
        if(numRows == 2) return result;

        int n = 3;
        while(n <= numRows) {
            List<Integer> temp = new LinkedList<>();
            temp.add(1);
            List<Integer> previous = result.get(n - 2);
            for(int i = 0; i < previous.size() - 1; i++) {
                temp.add(previous.get(i) + previous.get(i + 1));
            }
            temp.add(1);
            result.add(temp);
            n++;
        }

        return result;
    }
}
