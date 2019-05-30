import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */

public class LeetCode3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("a"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()){
            return 0;
        }
        int maxlength = 0;
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++){
            int length = 0;
            set.clear();
            for(int j = i;j<chars.length; j++){
                if(!set.contains(chars[j])){
                    set.add(chars[j]);
                    length++;
                    if(length > maxlength){
                        maxlength = length;
                    }
                }else {
                    if(length > maxlength){
                        maxlength = length;
                    }
                    break;
                }
            }
        }

        return maxlength;

        //滑动窗口法，时间复杂度为O（n），我上面写的那个时间复杂度是n的平方
//        int n = s.length();
//        Set<Character> set = new HashSet<>();
//        int ans = 0, i = 0, j = 0;
//        while (i < n && j < n) {
//            // try to extend the range [i, j]
//            if (!set.contains(s.charAt(j))){
//                set.add(s.charAt(j++));
//                ans = Math.max(ans, j - i);
//            }
//            else {
//                set.remove(s.charAt(i++));
//            }
//        }
//        return ans;
    }
}
