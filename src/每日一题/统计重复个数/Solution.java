package 每日一题.统计重复个数;

/**
 * @Classname Solution
 * @Description TODO
 * @Date 2024/1/2 21:07
 * @Created by ahh
 */
public class Solution {
    public static void main(String[] args) {
//        s1 = "acb", n1 = 4, s2 = "ab", n2 = 2

        System.out.println(getMaxRepetitions("aaa",3,"aa",1));

    }

    /**
     * 没有通过
     * @param s1
     * @param n1
     * @param s2
     * @param n2
     * @return
     */
    public static int getMaxRepetitions(String s1, int n1, String s2, int n2) {

        StringBuilder strBuffer1 = new StringBuilder("");
        for (int i = 0; i < n1; i++) {
            strBuffer1.append(s1);
        }
        int m = 0;
        String str1 = strBuffer1.toString();
        int str1Index = 0;
        while (str1Index < str1.length()) {
            int count = 0;
            for(int i = 0; i < s2.length(); i++) {
                for (int j = str1Index; j < str1.length(); j++) {
                    if(s2.charAt(i) == str1.charAt(j)) {
                        str1Index = j + 1;
                        count++;
                        break;
                    }

                }
            }
            if (count == s2.length()) {
                m++;
            }

        }

        return m / n2;
    }
}
