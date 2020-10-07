package hw5;

/**
 * This class for employee.
 */
public class Employee {
    String firstName;
    String lastName;
    String middleName;
    String position;
    String email;
    String phone;
    int salary;
    int age;

    public Employee(String firstName, String lastName, String middleName
            , String position, String email, String phone, int salary, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo() {
        System.out.printf("Сотрудник:\nФИО: %s %s %s\nДолжность: %s\nEmail: %s\n" +
                "Телефон: %s\nЗараплата: %d руб.\nВозраст: %d\n\n",lastName,firstName,middleName,position,
                email,phone,salary,age);
    }
}
