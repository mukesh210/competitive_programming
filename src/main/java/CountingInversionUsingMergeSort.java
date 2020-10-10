public class CountingInversionUsingMergeSort {
    public static void main(String args[]) {
        int[] input = {1, 20, 6 , 4, 5}; // {3,1,2,5,6,2,1,4};
        CountingInversionUsingMergeSort ms = new CountingInversionUsingMergeSort();
        int inversionCount = ms.sort(input, 0, input.length - 1);
        System.out.println("InversionCount: " + inversionCount);
    }

    public int sort(int[] input, int l, int r) {
        if(l < r) {
            int mid = (l + r) / 2;

            int leftInversionCount = sort(input, l, mid);
            int rightInversionCount = sort(input, mid + 1, r);

            int mergedInversionCount = merge(input, l, mid, r);

            return leftInversionCount + rightInversionCount + mergedInversionCount;
        }
        return 0;
    }

    public int merge(int[] input, int l, int mid, int r) {
        // create 2 temp arrays
        int[] L = new int[mid - l + 1];
        int[] R = new int[r - mid];

        // fill temp arrays
        for(int i = 0; i < L.length; i++) {
            L[i] = input[l + i];
        }
        for(int i = 0; i < R.length; i++) {
            R[i] = input[mid + 1 + i];
        }

        // to track temp arrays
        int i = 0, j = 0;

        // to track in original array
        int k = l;
        int inversionCount = 0;

        while(i < L.length && j < R.length) {
            if(L[i] <= R[j]) {
                input[k++] = L[i++];
            } else {
                inversionCount += (L.length - i);
                input[k++] = R[j++];
            }
        }

        while(i < L.length) {
            input[k++] = L[i++];
        }
        while(j < R.length) {
            input[k++] = R[j++];
        }

        return inversionCount;
    }
}
