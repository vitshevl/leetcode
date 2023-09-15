package task_3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstring {

    public static void main(String[] args){
        String s = "tmmzuxt";

        System.out.println(lengthOfLongestSubstring_1(s));
        System.out.println(lengthOfLongestSubstring_2(s));


    }

    private static int lengthOfLongestSubstring_1(String s){
        int max = 0;

        for(int i = 0; i < s.length(); i++){
            Set<Character> substring = new HashSet<>();

            for(int j = i; j < s.length(); j++){
                if(!substring.add(s.charAt(j))) {
                    break;
                }
            }
            max = Math.max(max, substring.size());
        }
        return max;
    }

    private static int lengthOfLongestSubstring_2(String s){
        int max = 0;
        int left = 0;
        int right = 0;
        int len = s.length();

        final Map<Character, Integer> seen = new HashMap<>();

        while (right < len) {

            final char nextChar = s.charAt(right);

            if (seen.containsKey(nextChar) && seen.get(nextChar) >= left){
                left = seen.get(nextChar) + 1;
            } else {
                max = Math.max(max, right - left + 1);
            }

            seen.put(nextChar, right);
            right++;
        }


        return max;
    }
}
