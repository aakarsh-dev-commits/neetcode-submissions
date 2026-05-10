class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        Map<String , Integer> map1 = new HashMap<>();

        for(int i = 0 ; i < t.length() ; i++) {
            String v = String.valueOf(s.charAt(i));

            if(map1.containsKey(v)) {
                map1.put(v , map1.get(v) + 1 );
            } else {
                map1.put(v , 1);
        }}

        Map<String , Integer> map2 = new HashMap<>();

        for(int i = 0 ; i < t.length() ; i++) {
            String w = String.valueOf(t.charAt(i));

            if(map2.containsKey(w)) {
                map2.put(w , map2.get(w) + 1 );
            } else {
                map2.put(w , 1);
        }}

        return map1.equals(map2);
    }
}
