package base.doublePointer;

public class aa {
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        int target = 0;
        System.out.println(searchInsert(nums, target));
    }

    /**
     * 最初自己思考的思路
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        int res = 0;
        boolean flag = true;
        while (flag) {
            int index = (right - left) / 2 + left;
            if (right - left <= 1) {
                flag = false;
            }
            if (nums[index] < target) {
                left = index + 1;
            } else if (nums[index] == target) {
                flag = false;
                res = index;
            } else {
                right = index;
            }
            if (!flag) {
                if (nums[left] < target && nums[right] > target) {
                    res = left + 1;
                } else if (nums[left] > target) {
                    res = left == 0 ? left : left - 1;
                } else if (nums[right] == target) {
                    res = right;
                } else if (nums[left] == target) {
                    res = left;
                } else if (nums[right] < target) {
                    res = right + 1;
                }
            }
        }
        return res;
    }

    /**
     * 正解
     *
     * @param nums
     * @param target
     * @return
     */
    public static int solution(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int ans = nums.length;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if(target <= nums[mid]){
                ans = mid;
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
