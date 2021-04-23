package algorithm.sorts;

/**
 * @description 希尔排序
 **/
public class ShellSort {
    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        int[] nums = {1,2,2,3,1,2,3,1};
        for (int i : shellSort.shellSort(nums)) {
            System.out.println(i);
        }
    }
    public int[] shellSort(int[] nums) {
//        将数据先细分组后，分别进行插入排序，排好后逐渐合并。直到最后合为一组；
        //定义增量并初始化增量序列
        int gap = 1;
        while (gap < nums.length/3){
            gap = 3*gap+1;
        }
        //增量每一轮缩小3倍，到最小为一时，表示合成了一个大组，这样可以减少在插入排序时较小数据的移动次数
        for ( ; gap > 0; gap /= 3) {
            //由分组的第一个数开始往数组后面快排，保证每一组都进行了插入排序
            for (int i = gap; i < nums.length; i++) {
                int temp = nums[i];
                int j = i;
                //每一轮的遍历变成分组形式
                while (j >= gap && temp < nums[j-gap]) {
                    nums[j] = nums[j-gap];
                    j-=gap;
                }
                nums[j] = temp;
            }
        }
        return nums;
    }
}