class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<String> set = new HashSet<>();
        int l = 0;
        int max = 0;
        for (int i = 0 ; i < s.length() ; i++) {
            if(!set.contains(String.valueOf(s.charAt(i)))) {
                set.add(String.valueOf(s.charAt(i)));
                int tmax = set.size();
                if(tmax > max) {
                    max = tmax;
                }
            } else {
                while(set.contains(String.valueOf(s.charAt(i)))) {
                    set.remove(String.valueOf(s.charAt(l)));
                    l++;
                }
                set.add(String.valueOf(s.charAt(i)));
            }
        }

        return max;
    }
}
