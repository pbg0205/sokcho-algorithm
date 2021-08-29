// T(n) = nums[n] + Math.max(T(n-2), T(n-3))

class Solution {
    int MAX_IDX;
    HashMap<Integer, Integer> map = new HashMap<>();

    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        MAX_IDX = nums.length - 1;
        return Math.max(recur(nums, MAX_IDX), recur(nums, MAX_IDX - 1));
    }

    public int recur(int[] nums, int n) {
        boolean canJumpOnce = n - 2 >= 0;
        boolean canJumpTwice = n - 3 >= 0;

        if(!canJumpOnce) {
            return nums[n];
        }

        int jumpOnce = (map.containsKey(n-2)) ? map.get(n-2) : recur(nums, n - 2);
        map.put(n-2, jumpOnce);

        if(!canJumpTwice) {
            return nums[n] + jumpOnce;
        }
        int jumpTwice = (map.containsKey(n-3)) ? map.get(n-3) : recur(nums, n - 3);
        map.put(n-3, jumpTwice);

        int result = nums[n] + Math.max(jumpOnce, jumpTwice);
        return result;
    }

}
