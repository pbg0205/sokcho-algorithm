class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left != right) {
            int sumOfTwo = numbers[left] + numbers[right];

            if (sumOfTwo == target) {
                return new int[]{left + 1, right + 1};
            }
            
            if (sumOfTwo < target) {
                left += 1;
            }

            if (sumOfTwo > target) {
                right -= 1;
            }
        }
        return new int[0];
    }
}

