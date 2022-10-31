#include <iostream>
#include <math.h>
using namespace std;
int main()
{
	double m1, m2, r, F;
	double const g = 6.673 * pow(10, 11);
	cout << "Enter m1: ";
	cin >> m1;
	cout << "Enter m2: ";
	cin >> m2;
	cout << "Enter r: ";
	cin >> r;
	F = g * (m1 * m2 / (r * r));
	cout << "F= "<<fixed <<F <<endl;
	return 0;
}