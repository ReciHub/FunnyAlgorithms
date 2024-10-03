#include <iostream>
#include <vector>
using namespace std;
/*
 *Welcome to Calmly Sorting! Here we are sorting values entered by the user
 *and sorting them in ascending order. We don't have to rush everything in life, sometimes it's nice
 *to take things slow and really visualize the process!!
 */
void calm_sort(vector<int>& arr) {
    cout << "Starting Calm Sort... Let's take it slow and step by step and not rush! Time to relax and learn slowly!"<< endl;
    cin.get(); //makes user click enter before continuing (keeps things interactive!)
    //loops through list given by user
    for (size_t i = 0; i < arr.size(); i++) {
        cin.get();
        cout << "Understanding value " << arr[i] << "... thinking and contemplating life..."<<endl;
        cin.get();
        //compares current value to other values in list
        for (size_t j = i+1; j < arr.size(); j++) {
            if(arr[i] > arr[j]) {
                cout <<"There we go, time to SWAP! "<< arr[i]<< " with "<< arr[j]<<endl;
                swap(arr[i], arr[j]);
                cin.get();
            } else {
                cout<< "Value"<<" " << arr[i] << " and value " <<"" << arr[j] << " are fine where they are. No need to SWAP. Let's move on :)" << endl;
                cin.get();
            }
        }
    }
    // complete message
    cout<< "YAY! Sorting complete. That was quite a fast journey... right? ... YAY??.."<< endl;
    cin.get();
}


int main() {
    vector<int> arr;
    int user_values;
    //asks user to enter # of values
    cout<< "Welcome to Calmly Sort! Please enter the number of values you want to enter and sort: ";
    cin >> user_values;
    // user enters their specific numbers they would like to sort
    cout << "Please enter " <<user_values << " numbers:" << endl;
    for (int i =0; i <user_values; ++i) {
        int value;
        cin>>value;
        arr.push_back(value);
    }
    cout <<"Original List: ";
    for (int n :arr) cout << n << " ";
    cout << endl;

    //call function to start sorting
    calm_sort(arr);

    cout << "Sorted List: " ;
    for (int n :arr) cout << n << " ";
    cout << endl;
    return 0;
}
