import unittest
from task1 import *


class TestArrayFunctions(unittest.TestCase):
    def test_create_random_array(self):
        array = create_random_array()
        self.assertEqual(len(array), 10)
        for value in array:
            self.assertGreaterEqual(value, 1)
            self.assertLessEqual(value, 10)

    def test_replace_even_index_values(self):
        array = create_random_array()
        modified_array = replace_even_index_values(array[:])

        expected_array = array[:]
        for i in range(0, len(expected_array), 2):
            expected_array[i] = -1

        self.assertEqual(modified_array, expected_array)


if __name__ == "__main__":
    unittest.main()
