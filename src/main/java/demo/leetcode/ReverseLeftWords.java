package demo.leetcode;

/**
 *字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 *
 *
 * 示例 1：
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 *
 * 示例 2：
 *
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 *
 *
 *
 * 限制：
 *
 *     1 <= k < s.length <= 10000
 *
 *
 * @author RDJ-YUZHENQUAN
 */
public class ReverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        String startStr = s.substring(0, n);
        String endStr = s.substring(n, s.length());
        return endStr + startStr;

    }


    public String reverseLeftWords2(String s, int n) {
        String startStr = s.substring(0, n);
        String endStr = s.substring(n, s.length());
        return endStr + startStr;

    }


    public static void main(String[] args) {
        ReverseLeftWords reverseLeftWords = new ReverseLeftWords();
        System.out.println(reverseLeftWords.reverseLeftWords("abcdefg", 2));
        System.out.println(reverseLeftWords.reverseLeftWords("lrloseumgh", 6));
    }
}
