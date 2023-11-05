package homework03;

import java.util.*;

public class Office implements Iterable<Employee> {
    private List<Employee> repo;

    public Office() {
        repo = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        repo.add(employee);
    }

    public void sort() {
        Collections.sort(repo);
    }

    public void sortBySalary() {
        repo.sort(new SalaryComparator());
    }

    @Override
    public String toString() {
        return "Office{" +
                "repo=" + repo +
                '}';
    }

    @Override
    public Iterator<Employee> iterator() {
        return new Iterator<Employee>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < repo.size();
            }

            @Override
            public Employee next() {
                return repo.get(index++);
            }
        };
    }

    private static class SalaryComparator implements Comparator<Employee> {

        @Override
        public int compare(Employee o1, Employee o2) {
            return Double.compare(o1.getSalaryMonth(), o2.getSalaryMonth());
        }
    }
}
