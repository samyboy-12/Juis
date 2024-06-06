package Soal2;
abstract class Employee {
    private String name;
    private String dateOfBirth;
    private String department;
    private String id;
    private String position;

    public Employee(String name, String dateOfBirth, String department, String position) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.department = department;
        this.position = position;
        this.id = generateId(department, dateOfBirth);
    }

    public static String[] getDepartment() {
        return new String[]{"Product", "Human Resources"};
    }

    private String generateId(String department, String dateOfBirth) {
        String deptCode = department.equals("Product") ? "PROD" : "HR";
        int randomNum = (int) (Math.random() * 9000) + 1000;
        return "000" + deptCode + dateOfBirth + randomNum;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Date of Birth: " + dateOfBirth + ", Department: " + department + ", Position: " + position;
    }
}