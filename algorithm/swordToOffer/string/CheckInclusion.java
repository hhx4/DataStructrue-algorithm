package algorithm.swordToOffer.string;

import java.util.Arrays;

/**
 *
 * 判断子串是否有变位词 只包含小写字母
 * Determine whether the substring has an anagram，Contain only lowercase
 **/
public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length()){
            return false;
        }
        int[] chars1 = new int[26];
        int[] chars2 = new int[26];
        //用数组来存储个字母的数量，以
        for(int i = 0;i<s1.length();i++){
            chars1[s1.charAt(i) - 'a']++;
            chars2[s2.charAt(i) - 'a']++;
        }
        if(Arrays.equals(chars1,chars2)){
            return true;
        }
        int left = 0;
        int right = s1.length();
        while(right<s2.length()){
            chars2[s2.charAt(left) - 'a']--;
            chars2[s2.charAt(right) - 'a']++;
            if(Arrays.equals(chars1,chars2)){
                return true;
            }
            right++;
            left++;
        }
        return false;
    }
}