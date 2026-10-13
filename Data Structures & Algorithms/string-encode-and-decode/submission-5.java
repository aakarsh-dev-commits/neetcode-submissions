class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            sb.append(s.length()).append("#").append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ls = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int j = i;

            // Find the # separating the length from the string
            while (str.charAt(j) != '#') {
                j++;
            }

            // Extract the length
            int len = Integer.parseInt(str.substring(i, j));

            // Extract the original string
            String s = str.substring(j + 1, j + 1 + len);
            ls.add(s);

            // Move to the beginning of the next encoded string
            i = j + 1 + len;
        }

        return ls;
    }
}