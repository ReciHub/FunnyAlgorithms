//C++ program to implement Binary search using recursive method
//For this we are hoping that the array is sorted

#include<bits/stdc++.h>

using namespace std;

// A function that return the index of the element if found
// If the number is not there then it will return -1

int bSearch(int binarySearchArray[], int low, int high, int searchingNumber){
    int mid = (low + high)/2; 
    // When the array is initialized then low represents 0th index whereas high represents the last index of the array
    if(low > high)
        return -1;
    // we return -1 when low becomes greater than high denoting that the number is not present
    if(binarySearchArray[mid] == searchingNumber)
        return mid;
    // If the number is found we are returning the index of the number where it was found
    else if(searchingNumber > binarySearchArray[mid])
        bSearch(binarySearchArray, mid + 1, high, searchingNumber);
    // Since the number is greater than the mid element in the array so we increase the index of low by mid+1 
    // becuase the number before do not contain the number we were searching for
    else
        bSearch(binarySearchArray, low, mid-1, searchingNumber);
    // Since the number is less than the mid elemet in the array so we decrease the index of high to mid-1
    // because the number after the middle element do not contain the number we were searching for
}

int main(){
    int sizeofArray = 10; // Taking the size of array
    int binSearchArray[sizeofArray] = {5, 8 ,12, 34, 36, 40, 45, 50, 56, 61}; // Array containing the elements
    int searchNumber = 40;

    int isNumberFound = bSearch(binSearchArray, 0, sizeofArray - 1, searchNumber);

    if(isNumberFound != -1)
        cout<<"The number is found at the index : "<<isNumberFound;
    // Since the returned index is not -1 we print that the number was found and at what index
    else
        cout<<"The number is not present in the array";
    // else part is activated when the function returns -1 indicating that the number is not present

    return 0;
}