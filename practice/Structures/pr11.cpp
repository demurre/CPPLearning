#include <iostream>
#include <vector>
using namespace std;
class Person {
public:
	string sname; string name;
	int vyear; int vday; int vmonth; int day; int month; int year; 
	int sp; int np; string p; string i; string pb;
	Person data() {//a function in which we record data about people
		Person datas;
		cout << "Surname " << "Name: ";
		cin >> datas.sname >> datas.name;
		cout << "Date of birth: ";
		cin >> datas.day >> datas.month >> datas.year;
		cout << "Passport series: ";
		cin >> datas.sp;
		cout << "Passport number ";
		cin >> datas.np;
		cout << "Issue date: ";
		cin >> datas.vday >> datas.vmonth >> datas.vyear;
		cout << "Issued by: ";
		cin >> datas.p >> datas.i >> datas.pb;
		return datas;
	};
};
int main() {
	Person pass;
	vector<Person>list;//we create a "container" to record our data
	cout << "Enter the data " << endl;
	char answer = 'Y';
	while (toupper(answer) == 'Y') {
		if (toupper(answer) == 'Y') {
			list.push_back(pass.data());//add an instance of the class to the end of the vector
		}
		cout << "Next? Y/N ";
		cin >> answer;
	}
	cout << "List of people who need to replace the photo ";
	for (Person e: list) {//e-element of the vector
		if (2022 - e.vyear >= 10) {
			cout << endl << e.sname << " " << e.name << endl;
		}
	}
	return 0;
}