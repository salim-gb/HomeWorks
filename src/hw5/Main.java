package hw5;

/**
 * This is homework of lesson #5
 * Educational portal "GeekBrains"
 * Geek University Android-development
 *
 * @author Alsado Salim
 */
public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("Иван", "Иванов", "Иванович",
                "Начальник отдела", "ivanov38@yandex.ru","+79265349800", 45000, 38);

//        employee.printInfo();

        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Кирилл", "Иванов", "Михаилович", "Инженир",
                "ivivan@mailbox.com", "+792312312", 43000, 30);
        employees[1] = new Employee("Александр", "Смирнов", "Семенович", "Строитель",
                "sasha45@yandex.ru", "+79262348901", 48000, 45);
        employees[2] = new Employee("Павел", "Матвеев", "Абрамович", "Программист",
                "prmt45@yandex.ru", "+79052018434", 90000, 41);
        employees[3] = new Employee("Ивановна", "Анна", "Василевна", "Инженир",
                "anna123@gmail.com", "+79678915461", 53000, 32);
        employees[4] = new Employee("Дмитрий", "Макаров", "Филиппович", "Продавец",
                "ivivan@mailbox.com", "+79658214107", 32000, 55);

        printEmployee(employees, 40);
    }

    /**
     * This method get an array of employees and print information about them.
     * @param arr The given array of employees.
     * @param age The age over will be show employees.
     */
    static void printEmployee(Employee[] arr, int age) {
        String msg = age > 0 ? "Здесь все сотрудники старше " + age + " лет." :
                "Здесь информации про всех сотрудников.";
        System.out.printf("%s\n", msg);

        for (Employee employee : arr) {
            if (employee.age > age) {
                employee.printInfo();
            }
        }
    }
}
