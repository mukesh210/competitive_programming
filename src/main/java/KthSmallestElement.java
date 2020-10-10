import java.io.*;
import java.util.Arrays;

public class KthSmallestElement {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            br.readLine();
            int[] inputArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int k = Integer.parseInt(br.readLine());

            for(int i = inputArr.length / 2 - 1; i >= 0; i--) {
                heapify(inputArr, inputArr.length, i);
            }

            int kthSmallest = inputArr[0];
            int counter = 0;
            int i = inputArr.length - 1;
            while(i >= 0 && counter < k) {
                int smallest = inputArr[0];
                kthSmallest = smallest;
                inputArr[0] = inputArr[i];
                inputArr[i] = smallest;

                heapify(inputArr, i, 0);
                counter++;
                i--;
            }

            bw.write(kthSmallest + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static void heapify(int[] arr, int heapSize, int indexToHeapify) {
        int smallest = indexToHeapify;
        int leftChild = 2 * indexToHeapify + 1;
        int rightChild = 2 * indexToHeapify + 2;

        if(leftChild < heapSize && arr[leftChild] < arr[smallest]) {
            smallest = leftChild;
        }

        if(rightChild < heapSize && arr[rightChild] < arr[smallest]) {
            smallest = rightChild;
        }

        if(smallest != indexToHeapify) {
            int temp = arr[indexToHeapify];
            arr[indexToHeapify] = arr[smallest];
            arr[smallest] = temp;

            heapify(arr, heapSize, smallest);
        }
    }
}
