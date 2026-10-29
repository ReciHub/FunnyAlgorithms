#include<bits/stdc++.h>
using namespace std;

//Function to find the number of rotations using binary search

int findRotation(const vector<int>& arr){
    int low=0,high=arr.size()-1;
    int ans=INT_MAX;
    int index=-1;

    while(low<=high){
       int mid=low+(high-low)/2;
       if(arr[low]<=arr[high]){
        if(arr[low]<ans){
            ans=arr[low];
            index=low;
        }
        break;
       }

       if(arr[low]<=arr[mid]){
        if(arr[low]<ans){
            ans=arr[low];
            index=low;
        }
        low=mid+1;
    }
    else{
        if(arr[mid]<ans){
            ans=arr[mid];
            index=mid;
        }
        high=mid-1;
    }
}

return index;
}

int main(){
    int n;
    cout<<"Enter number of elements: ";
    cin>>n;

    vector<int>nums(n);
    cout<<"enter the rotated sorted array elements: \n";
    for(int i=0;i<n;i++){
        cin>>nums[i];
    }

    int rotations= findRotation(nums);
    cout << "The array is rotated" << rotations <<"times."<<endl;

    return 0;
}
