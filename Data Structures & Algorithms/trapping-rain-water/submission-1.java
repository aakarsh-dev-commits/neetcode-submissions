class Solution {
    public int trap(int[] height) {

        int[] maxRarr = new int[height.length];
        int[] maxLarr = new int[height.length];
        int[] arr = new int[height.length];
        int maxL = 0;
        int maxR = 0;
        for(int i = 0 ; i < height.length ; i++) {
            if(i == 0 ) {
                maxLarr[i] = 0;
                maxRarr[height.length-1] = 0;
            }
            else {
            maxL = Math.max(maxL , height[i-1]);
            maxLarr[i] = maxL;
            
            maxR = Math.max(maxR , height[height.length-i]);
            maxRarr[height.length-1-i] = maxR;
            }
        }

        int wat = 0;

        for(int i = 0 ; i < height.length ; i++) {
            arr[i] = Math.min(maxLarr[i] , maxRarr[i]);

            if(arr[i] > height[i]) {
                wat = wat + arr[i] - height[i];
            }
        }

        return wat;


    } 
}
