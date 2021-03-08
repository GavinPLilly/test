public class P2_8_5 {
    public static int getAnswer() {
        int counter = 0;
        for(int i = 0; i < 512; i++) {
            if(checkReflexive(i)) {
                if(checkTransitive(i)) {
                    counter += 1;
                    System.out.println(printNum(i));
                }
            }
        }
        return counter;
    }
    private static boolean checkReflexive(int counter) {
        String input = getBinaryString(counter);
        if(input.charAt(0) == '1') {
            if(input.charAt(4) == '1') {
                if(input.charAt(8) == '1') {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkTransitive(int counter) {
        String input = getBinaryString(counter);
        if(input.charAt(1) == '1' && input.charAt(5) == '1' && input.charAt(2) == '0') {
            return false;
        }
        if(input.charAt(1) == '1' && input.charAt(6) == '1' && input.charAt(7) == '0') {
            return false;
        }
        if(input.charAt(2) == '1' && input.charAt(3) == '1' && input.charAt(5) == '0') {
            return false;
        }
        if(input.charAt(2) == '1' && input.charAt(7) == '1' && input.charAt(1) == '0') {
            return false;
        }
        if(input.charAt(3) == '1' && input.charAt(7) == '1' && input.charAt(6) == '0') {
            return false;
        }
        if(input.charAt(5) == '1' && input.charAt(6) == '1' && input.charAt(3) == '0') {
            return false;
        }
        return true;
    }

    private static String getBinaryString(int counter) {
        String input = java.lang.Integer.toBinaryString(counter);
        while(input.length() < 9) {
            input = "0" + input;
        }
        return input;
    }

    private static String printNum(int num) {
        String input = getBinaryString(num);
        String[] pairs = {"(1, 1)", "(1, 2)", "(1, 3)", "(2, 1)", "(2, 2)", "(2, 3)", "(3, 1)", "(3, 2)", "(3, 3)"};
        String out = "";
        for(int i = 0; i < 9; i++) {
            if(input.charAt(i) == '1' && i != 0 && i != 4 && i != 8) {
                out += " " + pairs[i];
            }
        }
        if(out == "") {
            return " [None]";
        }
        return out;
    }
    public static void main(String[] args) {
        // I used the method I described in part a.) to loop through all possible combinations
        // This number is then converted to a String so I can then easily check the value of different indexes
        // Converting to a array would also work
        // Because I check for reflexivity before transitivity there are only 6 cases I need to check for in the checkTransitive() method
        // The mapping of pair to digits is as follows
        // (1, 1)  (1, 2)  (1, 3)  (2, 1)  (2, 2)  (2, 3)  (3, 1)  (3, 2)  (3, 3)
        //    0       0       0       0       0       0       0       0       0
        // 
        // So if only (1, 1) (1, 3) and (3, 2) are true for a relation then the binary representaion reads as
        // 101000010
        // When printing to the console I don't include any reflexive pair
        System.out.println("All reflexive pairs are implied");
        System.out.println(getAnswer());
    }
}
