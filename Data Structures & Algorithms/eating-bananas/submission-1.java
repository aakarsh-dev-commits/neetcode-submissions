class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int l = 1;
        int r = piles[piles.length -1];
        int sum = 0;
        int res = 1000000001;
        while(l <= r) {
            sum = 0;
            int m = (l+r)/2;
            for(int i = 0 ; i < piles.length ; i++) {
                sum = sum + ((piles[i] + m - 1) / m);
            }
            if(sum <= h) {
                res = Math.min(m , res);
                r = m-1;
            } else {
                l = m+1;
            }
        }

        return res;
    }
}
