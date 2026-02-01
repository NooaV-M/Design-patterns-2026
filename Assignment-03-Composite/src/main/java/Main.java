public class Main {
    public static void main(String[] args) {
        Department headOffice = new Department("Head Office");

        Employee emp1 = new Employee("Alice", 5000);
        Employee emp2 = new Employee("Bob", 6000);
        headOffice.add(emp1);
        headOffice.add(emp2);

        Department itDepartment = new Department("IT Department");
        Employee emp3 = new Employee("Charlie", 7000);
        Employee emp4 = new Employee("David", 8000);
        itDepartment.add(emp3);
        itDepartment.add(emp4);

        headOffice.add(itDepartment);

        Department salaryOffice = new Department("Salary Office");
        Employee emp5 = new Employee("Eve", 5500);
        salaryOffice.add(emp5);
        headOffice.add(salaryOffice);

        Department salaryDepartment = new Department("Salary Department");
        Employee emp6 = new Employee("Frank", 6500);
        salaryDepartment.add(emp6);
        salaryOffice.add(salaryDepartment);

        headOffice.printStructure();

        System.out.println();

        System.out.println("Total Salary in Head Office: " + headOffice.getTotalSalary());
    }
}
