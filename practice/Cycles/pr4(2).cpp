#include <iostream>
#include <math.h>
#include <iomanip>
using namespace std;
int main() {
	const double PI = acos(-1.0);
	const double xmin = PI / 4, xmax = PI / 2;
	const int m = 15;
	const double h = (xmax - xmin) / m;
	cout << "x\ty" << endl;
	double x = xmin;
	while (x <= xmax) {
		if (x <= 0) {
			cout << fixed << setprecision(2) << x << "\t" << "no" << endl;
		}
		else {
			double y = sin(x);
			cout << fixed << setprecision(2) << x << "\t" << y << endl;
		}
		x += h;
	}
	return 0;
}