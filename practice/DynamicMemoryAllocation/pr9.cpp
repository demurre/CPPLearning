#include <iostream>
#include <cstdlib>
#include <iomanip>
using namespace std;
int main() {
    float *time = new float[20];
        for (int i = 0; i < 20; ++i) {
            cout << "Time of the " << i + 1 << " athlete: ";
            time[i] = rand() % 100 + 20;
            cout << time[i] << "s" << endl;
        }
    float sr = 0;
    for (int j = 0;j < 20;++j) {
        sr = 100 / time[j];
        cout << endl << "Avgspeed of the " << j + 1 << " athlete: "
            << setprecision(3) << sr << " m/s";
    }
    delete[] time;
}