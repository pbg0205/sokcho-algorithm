// https://leetcode.com/problems/maximum-subarray/discuss/20442/My-concise-O(n)-DP-JAVA-Solution/712288

class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int max = nums[0];
        int curr = nums[0];
        for(int i=1; i<nums.length; i++){
            // 이전 기록(curr)을 현재 nums[i]와 함께 들고 갈지, 버릴지 결정
            curr = Math.max(nums[i], nums[i] + curr);

            // 현재 로컬 맥스 값과 글로벌 맥스 값 비교해서 큰 걸 글로벌 맥스로 설정
            max = Math.max(curr, max);
        }
        return max;
    }
}
