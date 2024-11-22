#include <iostream>
#include <math.h>
#include <cstdlib>
using namespace std;
int main(){
    const int n = 5;
    const int m = 5;
    int B[n][m];
    cout << "Array B: " << endl;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            B[i][j] = rand() % 30;
            cout << B[i][j] << "\t";
        }
        cout << endl;
    }
    cout << "Elements are multiples 3: " << endl;
    int k = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (B[i][j] % 3 == 0) {
                cout << B[i][j] << " ";
                k++;
            }
        }
    }
    cout << endl << "Count of this: " << k;
}

