const fibonacci = (n) => {
  const nums = [0, 1];

  const recurse = (n) => {
    if (nums.length === n ) {
      return;
    }

    nums.push(nums[nums.length-1] + nums[nums.length-2]);
    recurse(n);
  };

  recurse(n);
  return nums;
};

fibonacci("Number of fibonacci numbers needed");