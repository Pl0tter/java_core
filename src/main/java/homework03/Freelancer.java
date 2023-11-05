package homework03;

public class Freelancer extends Employee {
    double rateSalary;

    public Freelancer(int id, String name, double rateSalary) {
        super(id, name);
        this.rateSalary = rateSalary;
    }

    @Override
    double getSalaryMonth() {
        return 20.8 * 8 * rateSalary;
    }

    @Override
    public int compareTo(Employee o) {
        return Integer.compare(this.getId(), o.getId());
    }
}
