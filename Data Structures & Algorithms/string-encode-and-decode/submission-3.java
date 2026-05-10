class Solution {

    public String encode(List<String> strs) {
        String res = "";

        for (int i = 0 ; i < strs.size() ; i++) {
            String str = strs.get(i);
            res = res.concat(String.valueOf(str.length()) + "#" + str);

        }

        return res;
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int j = 0;
        int i = 0;
        while(i < str.length()) {
            while(!(String.valueOf(str.charAt(j)).equals("#"))) {
                j++;
            }
            String s = str.substring(i,j);
            int len = Integer.valueOf(s);
            res.add(str.substring(j+1,j + 1 +len));
            i = j +1 + len;
            j = i;
        }    

        return res;
        
    }
}
