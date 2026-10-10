class Solution {
    public int reverse(int x) {
        String rev = String.valueOf(x);
        String newStr = "";
        if (x > 0) {
            for (int i = rev.length() - 1; i >= 0; i--) {
                newStr = newStr + rev.charAt(i);
            }

            long newInt = Long.parseLong(newStr);
            if (newInt >= Integer.MIN_VALUE && newInt <= Integer.MAX_VALUE) {
                return (int) newInt;
            }

            return 0;
        }

        else if (x < 0) {
            for (int i = rev.length() - 1; i > 0; i--) {
                newStr = newStr + rev.charAt(i);
            }

            long newInt = Long.parseLong(newStr) * -1;

            if (newInt >= Integer.MIN_VALUE && newInt <= Integer.MAX_VALUE) {
                return (int) newInt;
            }

            return 0;
        }

        else {
            return 0;
        }
    }
}
