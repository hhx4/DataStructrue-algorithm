package algorithm.swordToOffer.numbers;

import java.util.HashMap;

/**
 * 给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。
 * Given an integer array and an integer k, find the number of consecutive sub-arrays whose sum is k in the array.
 **/
public class PreSumAddition {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        //前缀和， 使用hash表来记录前缀和，如果在后续的遍历中存在有sum-k，   即当前前缀和-k = 以前前缀和，则代表从该位置到现在这个位置的和等于k
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            sum+=nums[i];
            count+=map.getOrDefault(sum-k,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}