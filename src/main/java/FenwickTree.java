public class FenwickTree {
    int[] fen;
    public static void main(String args[]) {
        int[] input = {1, 0, 2, 1, 1, 3, 0, 4, 2, 5, 2, 2, 3, 1, 0, 2};
        FenwickTree ft = new FenwickTree(input.length);

        for(int i = 0; i < input.length; i++) {
            ft.update(i, input[i]);
        }

        System.out.println("sum from 0 to 5 is:"+ ft.rangeSum(0, 5));
    }

    public FenwickTree(int size) {
        fen = new int[size + 1];
    }

    public void update(int i, int add) {
        i++;
        while(i < fen.length) {
            fen[i] += add;
            /*
            Finding next element:
                Find 2's complement
                and it with original number
                add it with original number
             */
            i += (i & (-i));
        }
    }

    public int sum(int i) {
        i++;
        int s = 0;
        while(i > 0) {
            s += fen[i];
            /**
             * Step to get parent
             *  Turn off right most bit
             *      2's complement
             *      & with original number
             *      subtract from original number
             */
            i = i - (i & (-i));
        }
        return s;
    }

    public int rangeSum(int l, int r) {
        return sum(r) - sum(l - 1);
    }
}
