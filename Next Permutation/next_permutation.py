class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # Base case
        if nums == sorted(nums, key=lambda x: -x):
            nums.sort()
            return

        for i in range(len(nums) - 1, 0, -1):
            if nums[i - 1] < nums[i]:
                # Find the first value that is less than the current value
                min_idx, min_val = len(nums), float('inf')
                for j in range(len(nums) - 1, i - 1, -1):
                    if nums[j] > nums[i - 1] and nums[j] < min_val:
                        min_val = nums[j]
                        min_idx = j
                nums[i - 1], nums[min_idx] = nums[min_idx], nums[i - 1]

                # Bubble Sort
                while True:
                    swapped = False
                    for k in range(i, len(nums) - 1):
                        if nums[k] > nums[k + 1]:
                            swapped = True
                            nums[k], nums[k + 1] = nums[k + 1], nums[k]
                    if swapped == False: break
                    
                return
