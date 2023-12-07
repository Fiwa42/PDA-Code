public class Masken {
    public static void main(String[] args) {
        String mask1 = "1234";
        String mask2 = "1?3?";
        System.out.println(match(mask1, mask2));
    }

    public static boolean match(String str, String mask) {
        if (str.length() != mask.length()) {
            return false;
        }

        if (mask.length() == 0) {
            return true;
        }

        if (str.charAt(0) == mask.charAt(0) || mask.charAt(0) == '?') {
            return match(str.substring(1), mask.substring(1));
        } else {
            return false;
        }
    }
}

