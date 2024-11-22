import json

employees = []


def add_employee():
    employee = {}
    employee["id"] = input("Enter ID: ")
    employee["surname"] = input("Enter surname: ")
    employee["name"] = input("Enter name: ")
    employee["address"] = input("Enter the address : ")
    employee["position"] = input("Enter a position in the organization: ")

    employees.append(employee)
    print("Successfully added!")


def save_to_file(filename):
    with open(filename, "w", encoding="utf-8") as f:
        json.dump(employees, f, ensure_ascii=False, indent=4)
    print("Data saved to file:", filename)


def load_from_file(filename):
    try:
        with open(filename, "r", encoding="utf-8") as f:
            employees.clear()
            employees.extend(json.load(f))
        print("Data loaded from file:", filename)
    except FileNotFoundError:
        print("File not found!")


def display_employees():
    if employees:
        for emp in employees:
            print(
                f"ID: {emp['id']}, Surname: {emp['surname']}, Name: {emp['name']}, Address: {emp['address']}, Position: {emp['position']}"
            )
    else:
        print("The list is empty.")


def main():
    while True:
        print("\nMenu:")
        print("1. Add employee")
        print("2. Save list to file")
        print("3. Load list from file")
        print("4. Display employees")
        print("5. Exit")

        choice = input("Enter your choice: ")

        if choice == "1":
            add_employee()
        elif choice == "2":
            filename = input("Enter the name of the file to save: ")
            save_to_file(filename)
        elif choice == "3":
            filename = input("Enter the name of the file to load: ")
            load_from_file(filename)
        elif choice == "4":
            display_employees()
        elif choice == "5":
            print("Exit.")
            break
        else:
            print("Invalid choice.")


if __name__ == "__main__":
    main()
