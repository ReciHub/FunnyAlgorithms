function knapsack(items, capacity) {
    const n = items.length;
  const dp = new Array(n + 1).fill(null).map(() => new Array(capacity + 1).fill(0));

  for (let i = 1; i <= n; i++) {
    for (let w = 0; w <= capacity; w++) {
      if (items[i - 1].weight <= w) {
        dp[i][w] = Math.max(
          dp[i - 1][w],
          dp[i - 1][w - items[i - 1].weight] + items[i - 1].value
        );
      } else {
        dp[i][w] = dp[i - 1][w];
      }
    }
  }

  // Reconstruct the selected items
  const selectedItems = [];
  let i = n;
  let w = capacity;
  while (i > 0 && w > 0) {
    if (dp[i][w] !== dp[i - 1][w]) {
      selectedItems.push(items[i - 1]);
      w -= items[i - 1].weight;
    }
    i--;
  }

  
    return {
      maxValue: dp[n][capacity],
      selectedItems: selectedItems.reverse(),
    };
  }
  
  function getUserInput() {
    const items = [];
    const numItems = parseInt(prompt("Enter the number of items:"));
  
    for (let i = 0; i < numItems; i++) {
      const weight = parseInt(prompt(`Enter the weight of item ${i + 1}:`));
      const value = parseInt(prompt(`Enter the value of item ${i + 1}:`));
      items.push({ weight, value });
    }
  
    const capacity = parseInt(prompt("Enter the knapsack capacity:"));
  
    return { items, capacity };
  }
  
  function main() {
    const { items, capacity } = getUserInput();
    const result = knapsack(items, capacity);
  
    console.log("Max Value:", result.maxValue);
    console.log("Selected Items:", result.selectedItems);
  }
  
  main();
  