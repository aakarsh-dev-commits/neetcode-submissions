class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        int l = 0;
        int msize = 0;
        int mlen = 0;
        for(int i = 0 ; i < s.length() ; i++) {
            if(map.containsKey(String.valueOf(s.charAt(i)))){
                map.put(String.valueOf(s.charAt(i)),map.get(String.valueOf(s.charAt(i))) + 1);
                if(msize < map.get(String.valueOf(s.charAt(i)))) {
                    msize = map.get(String.valueOf(s.charAt(i)));
                }
            } else {
                map.put(String.valueOf(s.charAt(i)),1);
                if(msize < map.get(String.valueOf(s.charAt(i)))) {
                    msize = map.get(String.valueOf(s.charAt(i)));
                }
            }

            int size = i-l+1;
            if(size - msize <= k) {
                if(mlen < size) {
                    mlen = size;
                }

            } else {
                map.put(String.valueOf(s.charAt(l)), map.get(String.valueOf(s.charAt(l))) - 1);
                l++;
            }

        }

        return mlen;
    }
}
