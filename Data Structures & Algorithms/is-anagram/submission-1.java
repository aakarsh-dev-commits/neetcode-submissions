class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        if (s.length() != t.length()) {
            return false;
        }
        for(int i = 0 ; i < s.length() ; i++) {
            if(map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i),map.get(s.charAt(i)) + 1);
            } else {
            map.put(s.charAt(i),1);
            }


            if(map2.containsKey(t.charAt(i))) {
                map2.put(t.charAt(i),map2.get(t.charAt(i)) + 1);
            } else {
            map2.put(t.charAt(i),1);
            }
        }

        if(map.equals(map2)) {
            return true;
        }

        return false;
    }
}