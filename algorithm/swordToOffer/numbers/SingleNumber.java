package algorithm.swordToOffer.numbers;

/**
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * Give you an array of integers nums. Except for an element that appears only once,
 * every other element appears exactly three times. Please find and return the element that appears only once.
 **/
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i = 0;i<32;i++){
            int sum = 0;
            //10 10 10 11
            for(int n:nums){
                sum += (n>>i)&1;
            }
            sum%=3;
            ans+=sum<<i;
        }
        return ans;
    }
}