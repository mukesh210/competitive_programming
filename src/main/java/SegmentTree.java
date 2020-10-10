public class SegmentTree {
    int st[];

    public static void main(String args[]) {
        int[] arr = {1, 3, 5, 7, 9, 11};

        SegmentTree segmentTree = new SegmentTree();
        segmentTree.allocateSegmentArray(arr.length);
        segmentTree.initializeSegmentTree(arr, 0, 0, arr.length - 1);

        for(int i = 0; i < segmentTree.st.length; i++) {
            System.out.print(segmentTree.st[i] + " ");
        }
        System.out.println();

        System.out.println(segmentTree.query(0, 0, arr.length - 1, 2 , 3));

        segmentTree.update(arr, 3, 10);

        System.out.println(segmentTree.query(0, 0, arr.length - 1, 2 , 3));
    }

    public void allocateSegmentArray(int n) {
        int x = (int)Math.ceil(Math.log(n) / Math.log(2));

        int size = 2 * (int) Math.pow(2, x) - 1;

        st = new int[size];
    }

    public int initializeSegmentTree(int[] input, int currentSI, int segmentS, int segmentE) {
        if(segmentS > segmentE)
            return 0;
        if(segmentS == segmentE) {
            st[currentSI] = input[segmentS];
            return input[segmentS];
        }

        int mid = (segmentS + segmentE) / 2;
        int sumOfSubSegments =
                initializeSegmentTree(input, 2 * currentSI + 1, segmentS, mid) +
                initializeSegmentTree(input, 2 * currentSI + 2, mid + 1, segmentE);
        st[currentSI] = sumOfSubSegments;
        return sumOfSubSegments;
    }

    public int query(int currentSI, int segmentS, int segmentE, int queryS, int queryE) {
        if(segmentS > segmentE)
            return 0;

        if(queryS > segmentE || queryE < segmentS)
            return 0;

        if(queryS <= segmentS && queryE >= segmentE)
            return st[currentSI];

        // overlapping intervals
        int mid = (segmentS + segmentE) / 2;
        int querySum = query(2 * currentSI + 1, segmentS, mid, queryS, queryE) +
                query(2 * currentSI + 2, mid + 1, segmentE, queryS, queryE);

        return querySum;
    }

    public void update(int[] input, int index, int value) {
        int diff = input[index] - value;

        input[index] = value;

        updateUtils(0, 0, input.length - 1, index, diff);
    }

    public void updateUtils(int si, int ss, int se, int index, int diff) {
        if(index >= ss && index <= se && si < st.length) {    // index lies inside the segment
            st[si] = st[si] - diff;

            int mid = (ss + se) / 2;
            updateUtils(2 * si + 1, ss, mid, index, diff);
            updateUtils(2 * si + 2, mid + 1, se, index, diff);
        }
    }
}
