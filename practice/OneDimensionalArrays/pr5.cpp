#include <iostream>
#include <math.h>
#include <cstdlib>
using namespace std;
int main() {
	const int n = 25;
	double x[n];
	cout << "Massiv X: ";
	for (int i = 0;i < n; i++) {
		x[i] = rand() % 10;
		cout << x[i] << " ";
	}
	double y[n];
	cout << endl << "Massiv Y: ";
	for (int i = 0;i < n; i++) {
		y[i] = rand() % 10;
		cout << y[i] << " ";
	}
	double z[n];
	cout << endl << "Massiv Z: ";
	for (int i = 0; i < n; i++) {
		z[i] = (x[i] + y[i]) / 2;
		if (z[i] >= 5 && z[i] <= 10) {
			cout << z[i] << " ";
		}
	}
}