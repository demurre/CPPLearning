#include <iostream>
#include <fstream>
#include <string>
using namespace std;
string encryptText(const string& text, int key) { // Text encryption function
    string encryptedText = "";
    int n = text.length();
    for (int i = 0; i < n; i++) {
        if (isalpha(text[i])) {
            char encryptedChar = text[i] + key;
            if (isupper(text[i]) && encryptedChar > 'Z')
                encryptedChar = 'A' + (encryptedChar - 'Z' - 1);
            else if (islower(text[i]) && encryptedChar > 'z')
                encryptedChar = 'a' + (encryptedChar - 'z' - 1);

            encryptedText += encryptedChar;
        }
        else {
            encryptedText += text[i];
        }
    }
    return encryptedText;
}
string decryptText(const string& encryptedText, int key) { // Text decoding function
    string decryptedText = "";
    int n = encryptedText.length();
    for (int i = 0; i < n; i++) {
        if (isalpha(encryptedText[i])) {
            char decryptedChar = encryptedText[i] - key;
            if (isupper(encryptedText[i]) && decryptedChar < 'A')
                decryptedChar = 'Z' - ('A' - decryptedChar - 1);
            else if (islower(encryptedText[i]) && decryptedChar < 'a')
                decryptedChar = 'z' - ('a' - decryptedChar - 1);

            decryptedText += decryptedChar;
        }
        else {
            decryptedText += encryptedText[i];
        }
    }
    return decryptedText;
}
int main() {
    string inputFilename = "input.txt";
    string outputFilename = "output.txt";
    string text;
    int key;
    // Reading text from a file
    ifstream inputFile(inputFilename);
    if (inputFile.is_open()) {
        getline(inputFile, text);
        inputFile.close();
    }
    else {
        cout << "The file could not be opened " << inputFilename << endl;
        return 1;
    }
    // Display of the read text on the screen
    cout << "The read text: " << text << endl;
    // Entering the key for text encryption
    cout << "Enter the encryption key: ";
    cin >> key;
    // Text encryption
    string encryptedText = encryptText(text, key);
    // Display of encrypted text on the screen
    cout << "Encrypted text: " << encryptedText << endl;
    // Writing encrypted text to an external file
    ofstream outputFile(outputFilename);
    if (outputFile.is_open()) {
        outputFile << encryptedText;
        outputFile.close();
        cout << "The encrypted text was written to a file " << outputFilename << endl;
    }
    else {
        cout << "The file could not be opened " << outputFilename << " for recording" << endl;
        return 1;
    }
    // Text decoding
    string decryptedText = decryptText(encryptedText, key);
    // Displaying the decoded text on the screen
    cout << "Decoded text: " << decryptedText << endl;
    return 0;
}