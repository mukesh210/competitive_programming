public class MergeSort {
    public static void main(String args[]) {
        int[] input = {3, 1, 2, 5, 6, 2, 1, 4};
        MergeSort ms = new MergeSort();
        //int[] result = ms.divideInputArr(input, 0, input.length - 1);
        ms.sort(input, 0, input.length - 1);
        for(int elem: input) {
            System.out.print(elem + " ");
        }
    }

    // sorts input[l...r]
    public void sort(int[] input, int l, int r) {
        if(l < r) {
            int mid = (l + r) / 2;

            sort(input, l, mid);
            sort(input, mid + 1, r);

            merge(input, l, mid, r);
        }
    }

    public void merge(int[] input, int l, int mid, int r) {
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

        while(i < L.length && j < R.length) {
            if(L[i] < R[j]) {
                input[k++] = L[i++];
            } else {
                input[k++] = R[j++];
            }
        }

        while(i < L.length) {
            input[k++] = L[i++];
        }
        while(j < R.length) {
            input[k++] = R[j++];
        }
    }

    public int[] divideInputArr(int[] input, int start, int end) {
        if(start == end) {
            return new int[]{ input[start] };
        }

        int mid = (start + end) / 2;
        int[] sortedLeftArr = divideInputArr(input, start, mid);
        int[] sortedRightArr = divideInputArr(input, mid + 1, end);

        return merge(sortedLeftArr, sortedRightArr);
    }

    public int[] merge(int[] leftArr, int[] rightArr) {
        int i = 0;
        int j = 0;
        int[] resultArr = new int[leftArr.length + rightArr.length];
        int count = 0;

        while(i < leftArr.length && j < rightArr.length) {
            if(leftArr[i] < rightArr[j])
                resultArr[count++] = leftArr[i++];
            else
                resultArr[count++] = rightArr[j++];
        }

        while(i < leftArr.length) {
            resultArr[count++] = leftArr[i++];
        }
        while(j < rightArr.length) {
            resultArr[count++] = rightArr[j++];
        }

        return resultArr;
    }
}
