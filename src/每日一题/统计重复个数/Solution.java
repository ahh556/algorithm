package 每日一题.统计重复个数;

/**
 * @Classname Solution
 * @Description https://leetcode.cn/problems/count-the-repetitions/description/
 * @Date 2024/1/2 21:07
 * @Created by ahh
 */
public class Solution {
    public static void main(String[] args) {
//        s1 = "acb", n1 = 4, s2 = "ab", n2 = 2

        System.out.println(getMaxRepetitions("aaa", 3, "aa", 1));

    }

    /**
     * 没有通过
     *
     * @param s1
     * @param n1
     * @param s2
     * @param n2
     * @return
     */
    public static int getMaxRepetitions1(String s1, int n1, String s2, int n2) {

        StringBuilder strBuffer1 = new StringBuilder("");
        for (int i = 0; i < n1; i++) {
            strBuffer1.append(s1);
        }
        int m = 0;
        String str1 = strBuffer1.toString();
        int str1Index = 0;
        while (str1Index < str1.length()) {
            int count = 0;
            for (int i = 0; i < s2.length(); i++) {
                for (int j = str1Index; j < str1.length(); j++) {
                    if (s2.charAt(i) == str1.charAt(j)) {
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


    public static int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (n1 == 0) {
            return 0;
        }

        int indexS2 = 0;
        int countS2 = 0;
        int[] indexr = new int[s2.length() + 1]; // 记录每1个s2的结束位置在s1中的下标
        int[] countr = new int[s2.length() + 1]; // 记录每1个s2的结束位置对应的s2出现次数

        // 设定两个指针 i,j 分别在s1和s2上移动
        for (int i = 0, j = 0; i < s1.length() * n1; i++) {
            if (s1.charAt(i % s1.length()) == s2.charAt(j % s2.length())) {
                j++;
                if (j % s2.length() == 0) {
                    countS2++;
                    indexS2 = i + 1;
                }
            }

            if (i % s1.length() == s1.length() - 1) { // 完成s1的一次循环
                if (indexr[j % s2.length()] == 0) { // 第一次遍历到s2中的这个位置，记录下来
                    indexr[j % s2.length()] = i + 1;
                    countr[j % s2.length()] = countS2;
                } else { // 发现了重复的位置，即找到了循环节
                    int prevIndex = indexr[j % s2.length()];
                    int prevCount = countr[j % s2.length()];
                    int patternLength = i + 1 - prevIndex;
                    int patternCount = countS2 - prevCount;
                    int remainLength = s1.length() * n1 - prevIndex;
                    int patternOccurrence = remainLength / patternLength;

                    countS2 = prevCount + patternOccurrence * patternCount;
                    indexS2 = prevIndex + patternOccurrence * patternLength;

                    // 处理剩下的部分
                    for (int k = 0; k < remainLength % patternLength; k++) {
                        if (s1.charAt((indexS2 + k) % s1.length()) == s2.charAt(j % s2.length())) {
                            if (++j % s2.length() == 0) {
                                countS2++;
                            }
                        }
                    }
                    break;
                }
            }
        }

        return countS2 / n2; // 返回s2在s1中出现的次数除以n2
    }
}
