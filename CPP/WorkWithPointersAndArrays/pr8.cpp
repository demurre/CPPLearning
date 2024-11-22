#include <iostream>
#include <cstdlib>
using namespace std;
void swap(int* x, int n){ //function to change elements
    int i = 0, temp = 0;
    for (i = 0; i < n / 2; i++){
        temp = x[i];
        x[i] = x[n - i - 1];
        x[n - i - 1] = temp;
    }
}
int main() {
    const int n = 10;
    int x[n];
    cout << "Array: ";
    for (int i = 0; i < n; ++i) {
        x[i] = rand() % 10;
        cout << x[i] << " ";
    }
    swap(x, n);
        cout << endl << "New Array: ";
        for (int i = 0; i < n; ++i)
        cout << x[i] << " ";
}