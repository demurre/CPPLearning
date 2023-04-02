#include <iostream>
#include <math.h>
#include <format>

using namespace std;

double count(double x) {
	const double PI = acos(-1.0);
	if (x < -PI) {
		cout << format("z = ln({}) = ", x);
		return log10(abs(x));
	}
	if ((-PI <= x) && (x <= PI)) {
		cout << format("z = sin({})+cos(2*{}) = ", x);
		return sin(x) + cos(2 * x);
	}
	if ((PI < x) && (x <= 10)) {
		cout << format("z = ({}^3)+1", x);
		return pow(x, 3) + 1;
	}
	if ((10 <= x) && (x < 100)) {
		cout << format("z = ({}+1)/(({}^2)+8) = ", x);
		return (x + 1) / (x * x + 8);
	}
	cout << format("z = ln({}) = ", x);
	return log10(x);
}
int main() {
	double x;
	cout << "Input x: ";
	cin >> x;
	cout << count(x) << endl;
}
