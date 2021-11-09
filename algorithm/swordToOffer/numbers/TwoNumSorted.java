package algorithm.swordToOffer.numbers;

/**
 * 对于一个已排序的数组，求两数之和等于target的两个数的下标；
 * For a sorted array, find the subscript of the two numbers whose sum is equal to the target；
 *
 * **/
public class TwoNumSorted {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        //对于已排序的数组利用双指针的思想，灵活移动指针比较两数之和与Target的关系；
        while(left<right){
            int sum = numbers[left]+numbers[right];
            if(sum == target){
                return new int[]{left,right};
            }else if(sum<target){
                left++;
            }else{
                right--;
            }
        }
        return new int[]{-1,-1};
    }
}