#include <iostream>
#include <iomanip>
using namespace std;
string booltostring(bool x) {//function to convert a machine value to a literal
	if (x) {
		return "true";
	}
	return "false";
}
int main() {
	unsigned int x = 1, y = 4, a = 7, b = 3, c = 2, d = 0;
	unsigned int* xp = &x, * yp = &y;
	cout << "Size x, y, a, b, c, d: " << sizeof(x) << ", " << sizeof(y) << ", " << sizeof(a) << ", " << sizeof(b) << ", " << sizeof(c) << ", " << sizeof(d) << endl
		<< "Size pointers: " << sizeof(xp) << ", " << sizeof(yp) << endl
		<< "Values ​​of variables: " << x << ", " << y << ", " << a << ", " << b << ", " << c << ", " << d << endl
		<< "Values of pointers: " << xp << ", " << yp << endl
		<< "Addresses in OP variable: " << &x << ", " << &y << ", " << &a << ", " << &b << ", " << &c << ", " << &d << endl
		<< "Addresses in OP pointers: " << &xp << ", " << &yp << endl
		<< "Result of removing pointers: " << xp - yp << endl
		<< "Adding pointers with an integer: " << xp + a << endl
		<< "Subtraction from the pointers of an integer: " << xp - a << endl
		<< "Decrement: " << --xp << ", " << --yp << endl
		<< "Increment: " << ++xp << ", " << ++yp << endl
		<< "Relation operations " << booltostring(xp == yp) << ", " << booltostring(xp <= yp) << ", " << booltostring(xp < yp)
		<< ", " << booltostring(xp < yp) << ", " << booltostring(xp >= yp) << ", " << booltostring(xp != yp) << endl;
	unsigned int** xpp = &xp;
	cout << "Address in OP pointer to pointer: " << &xpp << endl
		<< "Its meaning: " << &xpp, xpp;
	void* np = &x;
	int* np2 = static_cast<int*>(np);
	cout << endl << "The value of the unassigned indicator: " << *np2;
}
