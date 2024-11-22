#include <iostream>
#include <cmath>
#include <vector>
using namespace std;
int s(vector<int>list){
    int sum=0;
    for (int e : list) {
        if (e < 0) sum = sum + e;
    }
    return sum;
}
int main() {
    int i, n = 5, m = 6, k = 7;
    vector<int>A, B, C;
    for (int i = 0; i < n; ++i) {
        A.push_back(-(rand() % 100 - 50));
        cout << "A:" << A[i] << " ";
    }
    cout<<endl;
    for (int i = 0; i < m; ++i) {
        B.push_back(-(rand() % 100 - 50));
        cout << "B:" << B[i] << " ";
    }
    cout << endl;
    for (int i = 0; i < k; ++i) {
        C.push_back(-(rand() % 100 - 50));
        cout << "C:" << C[i] << " ";
    }
    cout << endl;
    cout << "Sum of negative elements A: " << s(A) << endl
    << "Sum of negative elements B: " << s(B) << endl
    << "Sum of negative elements C: " << s(C) << endl;
}