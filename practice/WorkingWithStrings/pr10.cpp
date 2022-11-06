#include <iostream>
using namespace std;
int main() {
    cout << "Enter any character: ";
    string s;
    char y = 'Y';
    while (toupper(y) == 'Y') {
        cin >> y;
        s += y;
        cout << "More? Y/N ";
        cin >> y;
        if (toupper(y) == 'Y') {
            cout << "Enter the next character: ";
        }
    }
    cout << "Number of characters entered: " << s.size();
}
