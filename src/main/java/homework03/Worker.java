package homework03;

public class Worker extends Employee {
    double monthSalary;

    public Worker(int id, String name, double monthSalary) {
        super(id, name);
        this.monthSalary = monthSalary;
    }

    @Override
    double getSalaryMonth() {
        return monthSalary;
    }

    @Override
    public int compareTo(Employee o) {
        return Integer.compare(this.getId(), o.getId());
    }
}
