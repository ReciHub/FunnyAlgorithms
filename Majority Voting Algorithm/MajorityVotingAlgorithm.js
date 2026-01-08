function findMajority(nums) {
    var count = 0,
        candidate = -1;

    // Finding majority candidate
    for (var index = 0; index < nums.length; index++) {
        if (count == 0) {
            candidate = nums[index];
            count = 1;
        } else {
            if (nums[index] == candidate)
                count++;
            else
                count--;
        }
    }

    // Checking if majority candidate occurs more than
    // n/2 times
    count = 0;
    for (var index = 0; index < nums.length; index++) {
        if (nums[index] == candidate)
            count++;
    }
    if (count > (nums.length / 2))
        return candidate;
    return -1;

    // The last for loop and the if statement step can
    // be skip if a majority element is confirmed to
    // be present in an array just return candidate
    // in that case
}

// Driver code
var arr = [1, 1, 1, 1, 2, 3, 4];
var majority = findMajority(arr);
document.write(" The majority element is : " + majority);