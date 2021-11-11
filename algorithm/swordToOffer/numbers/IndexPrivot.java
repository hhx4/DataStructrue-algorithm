package algorithm.swordToOffer.numbers;

/**
 * 给你一个整数数组nums ，请计算数组的 中心下标 。
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。*
 * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。*
 * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
Give you an integer array nums,
 please calculate the center index of the array. The center subscript of the array is a subscript of the array.
 The sum of all the elements on the left is equal to the sum of all the elements on the right.
 If the center index is at the left end of the array, the sum of the numbers on the left is considered to be 0
 because there is no element to the left of the index. This also applies to the center index at the right end of the array.
 If the array has multiple center subscripts, the one closest to the left should be returned.
 If the array does not have a central index, -1 is returned.
 **/
public class IndexPrivot {
    public int pivotIndex(int[] nums) {
        //先计算数组总和；
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum +=nums[i];
        }
        //如果前n-1项和 等于(sum-nums[i])/2，则该点前n-1项等于 后面n+1到末尾的和；
        int n = 0;
        for(int i=0;i<nums.length;i++){
            if(n*2==sum-nums[i]){
                return i;
            }
            n+=nums[i];
        }
        return -1;
    }
}