package algorithm.swordToOffer.numbers;

/**
 * 给定一个字符串数组words，请计算当两个字符串 words[i] 和 words[j] 不包含相同字符时，它们长度的乘积的最大值。
 * 假设字符串中只包含英语的小写字母。如果没有不包含相同字符的一对字符串，返回 0。
Given a string array words, please calculate the maximum value of the product of the lengths of
 the two strings words[i] and words[j] when they do not contain the same characters.
 Assume that the string contains only English lowercase letters.
 If there is no pair of strings that do not contain the same character, 0 is returned. *
 *
 **/
public class MaxProduct {
    public int maxProduct(String[] words) {
        //位运算解法，不同位置的01表示其是否存在；比如ac表示为101，abc表示为111；不同表示的结果值不同记在数组中；
        int[] nums = new int[words.length];
        for(int i = 0;i<words.length;i++){
            for(int j = 0;j<words[i].length();j++){
                nums[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }
        int res = 0;
        for(int i = 0;i<words.length-1;i++){
            for(int j = i+1;j<words.length;j++){
                if((nums[i] & nums[j]) == 0){
                    res = Math.max(res,words[i].length()*words[j].length());
                }
            }
        }
        return res;
    }
}