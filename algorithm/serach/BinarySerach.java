package algorithm.serach;

/**
 * @description 二分查找
 **/
public class BinarySerach {
    public static void main(String[] args) {
        BinarySerach binarySerach = new BinarySerach();
        int[] nums ={1,2,3,4,5,6,7,9,0};
        int i = binarySerach.binarySearch(nums, 8);
        System.out.println(i);
    }

    /**
    * 二分查找的递归实现
     * 进行查找的数组必须是有序数组
    */

    public int binarySearch(int[] nums, int n) {
        return binarySearchUtil(nums,0,nums.length-1,n);
    }

    private int binarySearchUtil(int[] nums, int left, int right, int n) {
        if(left>right){
            return -1;
        }
        int mid = (left+right)>>>1;
        if(nums[mid]<n){
            return binarySearchUtil(nums, mid+1, right, n);
        } else if (nums[mid] > n) {
            return binarySearchUtil(nums, left, mid-1, n);
        }else {
            return mid;
        }

    }

    /**
    * 二分查找的非递归实现
    * @params 有序数组和查找值
    */

    static int binarySearch2(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}