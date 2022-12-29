public class Main {
    public static void main(String[] args) throws Exception {
        Injector obj = new Injector();
        String path = "src/main/java/Initialization.properites";
        CompanyEmployee e = (CompanyEmployee) obj.inject(new CompanyEmployee(), path);
        e.employeeInformation();
    }
}
