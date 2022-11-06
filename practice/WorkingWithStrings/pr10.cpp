#include <iostream>
using namespace std;
int main() {
    cout << "Enter any symbol: ";
    string s;
    char y = 'Y';
    while (toupper(y) == 'Y') {
        cin >> y;
        s += y;
        cout << "Ще? Y/N ";
        cin >> y;
        if (toupper(y) == 'Y') {
            cout << "Enter the next symbol: ";
        }
    }
    cout << "Number of symbols entered: " << s.size();
}