class Solution {
    public int maxArea(int[] heights) {
        int size = heights.length;
        int max = 0;
        int l = 0 ;
        int h = heights.length-1;
        while(l < h) {
            int tmax = Math.min(heights[l],heights[h]) * (h-l);

            if(tmax > max) {
                max = tmax;
            }

            if(heights[l] < heights[h]) {
                l++;
            } else if(heights[l] > heights[h]) {
                h--;
            } 
            while(heights[l] == heights[h] && l < h) {
                tmax = Math.min(heights[l],heights[h]) * (h-l);

                 if(tmax > max) {
                max = tmax;
            }
                if (heights[l+1] > heights[h-1]) {
                    l++;
                }
                else if (heights[l+1] < heights[h-1]) {
                    h--;
                }
                else if (heights[l+1] == heights[h-1]) {
                    l++;
                    h--;
                }
            }
        }

        return max;


    }
}
