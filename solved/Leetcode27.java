class Solution27 {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (val != nums[i]) {
                nums[count++] = nums[i];
            }
        }

        return count;
    }
}
