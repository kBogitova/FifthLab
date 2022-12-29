public class CompanyEmployee {

    @AutoInjectable
    private Programminglanguage pr;

    @AutoInjectable
    private Employee employee;

    public void employeeInformation()
    {
        System.out.println("Employee:");
        employee.getName();
        employee.getGender();
        employee.getDateOfBirth();
        System.out.println("Uses a programming language:");
        pr.getName();
        pr.getLevel();
        pr.dateOfCreation();
    }
}
