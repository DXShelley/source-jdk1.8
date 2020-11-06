package demo.leetcode;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * @author RDJ-YUZHENQUAN
 */
public class ReplaceSpace {

    public static void main(String[] args) {
        System.out.println(replaceSpace2("We are happy."));
    }

    public static String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            if (' ' == (chars[i])) {
                stringBuffer.append("%20");
            } else {
                stringBuffer.append(chars[i]);
            }
        }
        return stringBuffer.toString();


    }

    public static String replaceSpace2(String s) {

        int length = s.length();
        int[] arr = new int[length * 3];
        int size = 0;

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                arr[size] = c;
                size++;
            } else {
                arr[size] = '%';
                arr[size + 1] = '2';
                arr[size + 2] = '0';
                size = size + 3;
            }
        }
        return new String(arr, 0, size);


    }

}
