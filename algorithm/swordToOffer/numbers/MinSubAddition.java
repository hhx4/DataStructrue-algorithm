package algorithm.swordToOffer.numbers;

/**
 * @created by wt at 2021-11-09 22:28
 **/
public class MinSubAddition {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(11, new int[]{1, 1, 1}));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left;
        int right;
        boolean flag = false;
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            flag = false;
            left = i;
            right = i + 1;
            if (nums[left] == target) {
                return 1;
            }
            int temp = nums[left];
            while (right < nums.length) {
                temp += nums[right];
                if (temp >= target) {
                    flag = true;
                    break;
                }
                right++;
            }
            if (flag) {
                res = Math.min(res, right - left + 1);
            }
        }

        return res;
    }
}