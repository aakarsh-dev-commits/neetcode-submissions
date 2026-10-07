class Solution {
    public int[] countBits(int n) {
        int[] arr = new int[n+1];
        for(int i = 0; i <= n ;i++) {
            arr[i] = bits(i);
        }

        return arr;
    }

    public int bits(int num) {
        int res = 0;
        for(int i = 0; i < 32 ; i++) {
            if(((1 << i) & num ) != 0 ) {
                res++;
            }
        }

        return res;
    }
}
