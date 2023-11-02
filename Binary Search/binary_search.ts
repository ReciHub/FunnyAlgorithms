const binarySearch = (
  nums: number[],
  s: number,
  start: number = 0,
  end: number = nums.length - 1,
): number => {
  const mid = Math.floor((start + end) / 2);

  if (nums[mid] === s) {
    return mid;
  }

  if (nums[mid] > s) {
    return binarySearch(nums, s, start, mid - 1);
  }

  if (nums[mid] < s) {
    return binarySearch(nums, s, mid + 1, end);
  }

  return -1;
};
