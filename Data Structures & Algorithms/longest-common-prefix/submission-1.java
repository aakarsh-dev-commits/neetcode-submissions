class Solution {
    public String longestCommonPrefix(String[] strs) {
        String c = "";
        boolean match = true;
        for(int j = 0 ; j < strs[0].length() ; j++) {
        for(int i =0 ; i< strs.length ; i++) {
        if(!(strs[0].regionMatches(0,strs[i],0,j+1))) {
            match = false;
            if (j == 0) {
            return c;
            }
            return strs[0].substring(0,j);
        }
        }
        }
        if(match) {
            return strs[0];
        }
        return c;

    }
}