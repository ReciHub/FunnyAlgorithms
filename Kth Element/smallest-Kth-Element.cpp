#include <bits/stdc++.h>
using namespace std ;

int partition(vector<int>& arr, int left, int right) {
    int pivot = arr[left] ;
    int l = left + 1 ;
    int r = right;
    while (l <= r) {
        if (arr[l] < pivot && arr[r] > pivot) {
            swap(arr[l], arr[r]);
            l++ ;
            r-- ;
        }
        if (arr[l] >= pivot) {
            l++;
        }
        if (arr[r] <= pivot) {
            r--;
        }
    }
    swap(arr[left], arr[r]);
    return r;
}

int kth_Largest_Element(vector<int>& arr, int k) {
    int left = 0, right = arr.size() - 1, kth;
    while (1) {
        int idx = partition(arr, left, right);
        if (idx == k - 1) {
            kth = arr[idx];
            break;
        }
        if (idx < k - 1) {
            left = idx + 1;
        } else {
            right = idx - 1;
        }
    }
    return kth;
}



int main() {

    vector<int>arr ;
    arr.push_back(12) ;
    arr.push_back(3)  ;
    arr.push_back(5) ;
    arr.push_back(7)  ;
    arr.push_back(4) ;
    arr.push_back(19)  ;
    arr.push_back(26) ;

    int n = arr.size(), k = 1;
    cout << "Kth Largest element is " << kth_Largest_Element(arr, k);
    return 0 ;
}