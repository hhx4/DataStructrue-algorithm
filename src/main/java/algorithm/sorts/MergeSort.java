package algorithm.sorts;

/**
 * @description 归并
 **/
public class MergeSort {
    public static void main(String[] args) {
        MergeSort mergeSort =new MergeSort();
        int[] nums = {1,2,2,4,2,4,2};
        int[] ints = mergeSort.mergeSort(nums);
        for (int i :
                ints) {
            System.out.println(i);
        }

    }
    public int[] mergeSort(int[] nums) {
        doSort(nums,0,nums.length - 1);
        return nums;
    }
    public void doSort(int[] nums, int left, int right) {
        if (left < right) {
        int mid = left+(right-left) / 2;
            doSort(nums,left,mid);
            doSort(nums,mid+1,right);
            merge(nums,left,mid,right);
        }
    }

    private int[] merge(int[] nums, int left, int mid, int right) {
        //    定义分组长度
            int length = right - left + 1;
            //左右两边的初始索引
            int i = left;
            int j = mid + 1;
            int k = 0;
            int[] temp = new int[length];
        //
            while (i <= mid && j <= right) {
              if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
              } else {
                temp[k++] = nums[j++];
              }
            }
        //  左边有序序列还有剩余的元素，就全部填充到temp中
            while (i <= mid) {
              temp[k++] = nums[i++];
            }
        //  右边有序序列还有剩余的元素填充到temp中
            while (j <= right) {
              temp[k++] = nums[j++];
            }
        //  将temp拷贝到nums
            System.arraycopy(temp, 0, nums, left, length);
        return nums;
    }
}