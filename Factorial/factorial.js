function factorial(n){
	accumulator = 1
	
	for(; n > 0; n--){
		accumulator *= n;
	}
	
	return accumulator;
}