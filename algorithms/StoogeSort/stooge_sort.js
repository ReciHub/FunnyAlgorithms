function stoogesort(L, i=0, j=null){
    if(j === null){
        j = L.length - 1
    }
    if(L[j] < L[i]){
        var temp = L[j]
        L[j] = L[i]
        L[i] = temp
    }
    
    
    if(j - i > 1){

        t = Math.floor(((j - i) + 1) / 3)
        stoogesort(L, i  , j-t)
        stoogesort(L, i+t, j  )
        stoogesort(L, i  , j-t)
    
    }
    return L
    
}
numbers = [2,4,6,8,10,9,7,5,3,1]
console.log(numbers)
 
sorted_list = stoogesort(numbers)
console.log(sorted_list)