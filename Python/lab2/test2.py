import os
import unittest
from unittest.mock import mock_open, patch
from task2 import *


class TestEmployeeManagement(unittest.TestCase):
    @patch(
        "builtins.input",
        side_effect=["1", "Smith", "John", "New York", "Manager"],
    )
    def test_add_employee(self, mock_input):
        employees = []

        add_employee(employees)

        self.assertEqual(len(employees), 1)
        self.assertEqual(employees[0]["id"], "1")
        self.assertEqual(employees[0]["surname"], "Smith")
        self.assertEqual(employees[0]["name"], "John")
        self.assertEqual(employees[0]["address"], "New York")
        self.assertEqual(employees[0]["position"], "Manager")

    def setUp(self):
        filename = "test_employees.json"
        if os.path.exists(filename):
            os.remove(filename)

    def test_save_to_file_creates_file(self):
        employees = [
            {
                "id": "1",
                "surname": "Smith",
                "name": "John",
                "address": "New York",
                "position": "Manager",
            }
        ]

        filename = "test_employees.json"

        save_to_file(filename, employees)

        self.assertTrue(os.path.exists(filename))

        with open(filename, "r", encoding="utf-8") as f:
            data = json.load(f)
            self.assertEqual(data, employees)

    @patch("builtins.open", new_callable=mock_open)
    def test_load_from_file(self, mock_file):
        employees_data = [
            {
                "id": "1",
                "surname": "Smith",
                "name": "John",
                "address": "New York",
                "position": "Manager",
            }
        ]

        mock_file().read.return_value = json.dumps(
            employees_data, ensure_ascii=False, indent=4
        )

        test_employees = []

        filename = "test_employees.json"
        load_from_file(filename, test_employees)

        read_data = mock_file().read.return_value
        print("Data read from file:", read_data)

        self.assertEqual(test_employees, employees_data)

        mock_file.assert_any_call(filename, "r", encoding="utf-8")

    @patch("builtins.print")
    def test_display_employees(self, mock_print):
        employees = [
            {
                "id": "1",
                "surname": "Smith",
                "name": "John",
                "address": "New York",
                "position": "Manager",
            }
        ]

        display_employees(employees)

        self.assertGreater(mock_print.call_count, 0)


if __name__ == "__main__":
    unittest.main()
