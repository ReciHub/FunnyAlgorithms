function bubbleSort(array) {
	const len = array.length;

	for (let i = 0; i < len; i++) {
		for (let j = 0; j < len - i; j++) {
			if (array[j] > array[j + 1]) {
				const tmp = array[j];
				array[j] = array[j + 1];
				array[j + 1] = tmp;
			}
		}
	}
}

// This one quit sooner if the array is sorted before all iterations
function bubbleSortOpti(array) {
	const len = array.length;

	for (let i = 0; i < len; i++) {
		let isSorted = true;

		for (let j = 0; j < len - i; j++) {
			if (array[j] > array[j + 1]) {
				isSorted = false;

				const tmp = array[j];
				array[j] = array[j + 1];
				array[j + 1] = tmp;
			}
		}

		if (isSorted) {
			return;
		}
	}
}

(() => {
	const array = [64, 34, 25, 12, 22, 11, 90];
	console.log("Unsorted array:", array);
	bubbleSort(array);
	console.log("Sorted array:", array);
})();
