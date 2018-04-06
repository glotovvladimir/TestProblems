import java.util.*;

public class Polynomial {
    // -x^256-x^5+25x+4   x^3+34x^2-3x+5
    public static void main(String[] args) {
        System.out.println("Enter 1st palindrome like -x^3-2x^2+x+9");
        Scanner in = new Scanner(System.in);
        String p1 = in.nextLine();
        //System.out.println("Enter 2nd palindrome like ...-x^3-2x^2+x+9");
        //String p2 = in.nextLine();

        HashMap<Integer, Integer> p1Map = new HashMap<Integer, Integer>();

        cutToMap(p1, p1Map);

        System.out.println(p1Map.entrySet());
    }

    public static  void cutToMap(String str, HashMap<Integer, Integer> pMap) {
        String coeff = "";
        String grade = "";
        str = str.replace("^", "");
        char[] strToChar = str.toCharArray();

        if (!str.contains("x")) {
            pMap.put(0, Integer.valueOf(str));
        } else {
            for (int i = 0; i < strToChar.length; i++) {
                if (strToChar[i] != 'x') {
                    coeff += strToChar[i];
                } else
                    str = str.substring(i+1);
                break;
            }
            for (int i = 0; i < strToChar.length; i++) {
                if ((strToChar[i] != '+') && (strToChar[i] != '-')) {
                    grade += strToChar[i];
                } else
                    str = str.substring(i+1);
                break;
            }
        }
        pMap.put(Integer.valueOf(grade), Integer.valueOf(coeff));

        cutToMap(str, pMap);
    }
}
