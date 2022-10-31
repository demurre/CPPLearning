#include <iostream>
#include <math.h>
using namespace std;
double count(double x) {
	const double PI = acos(-1.0);
	if (x < -PI) {
		cout << "z = ln(x)";
		return log10(abs(x));
	}
	if ((-PI <= x) && (x <= PI)) {
		cout << "z = sin(x)+cos(2*x)";
		return sin(x)+cos(2*x);
	}
	if ((PI < x) && (x <= 10)) {
		cout << "z = (x^3)+1";
		return pow(x,3)+1;
	}
	if ((10 <= x) && (x < 100)) {
		cout << "z = (x+1)/((x^2)+8)";
		return (x+1)/(x*x+8);
	}
	cout << "z = ln(x)";
	return log10(x);
}
int main() {
	double x;
	cout << "Input x: ";
	cin >> x;
	cout << " = " << count(x) << endl;
}