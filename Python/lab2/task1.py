import random

def create_random_array(size=10):
    return [random.randint(1, 10) for _ in range(size)]

def replace_even_index_values(arr):
    for i in range(0, len(arr), 2):
        arr[i] = -1
    return arr


if __name__ == "__main__":
    array = create_random_array()

    print("Array:")
    for value in array:
        print(value, end=" ")
    print()

    modified_array = replace_even_index_values(array[:])

    print("Modifed array with while:")
    i = 0
    while i < len(modified_array):
        print(modified_array[i], end=" ")
        i += 1
    print()

    print("Modifed array with for:")
    for value in modified_array:
        print(value, end=" ")
    print()
