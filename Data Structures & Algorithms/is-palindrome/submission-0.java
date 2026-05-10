class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() -1;

        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        while(i < s.length()) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                String l = String.valueOf(s.charAt(i));
                list1.add(l.toLowerCase());
            }

            if (Character.isLetterOrDigit(s.charAt(j))) {
                String k = String.valueOf(s.charAt(j));
                list2.add(k.toLowerCase());
            }
            
            i++;
            j--;
        }

        return list1.equals(list2);
    }
}
