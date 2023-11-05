package homework03;

/**
 * 1. Построить три класса (базовый и 2 потомка), описывающих некоторых работников с почасовой оплатой
 * (один из потомков - Freelancer) и фиксированной оплатой (второй потомок - Worker).
 * <p>
 * а) Описать в базовом классе абстрактный метод для расчёта среднемесячной заработной платы.
 * Для «повременщиков» формула для расчета такова: «среднемесячная заработная плата = 20.8 * 8 * почасовая ставка»,
 * для работников с фиксированной оплатой «среднемесячная заработная плата = фиксированная месячная оплата».
 * <p>
 * б) Создать на базе абстрактного класса массив/коллекцию сотрудников и заполнить его.
 * <p>
 * в) ** Реализовать интерфейсы для возможности сортировки массива/коллекции
 * (обратите ваше внимание на интерфейсы Comparator, Comparable), добавьте новое состояние на уровне базового типа и
 * создайте свой уникальный компаратор.
 * <p>
 * г) ** Создать класс, содержащий массив или коллекцию сотрудников (как Worker, так и Freelancer),
 * и реализовать возможность вывода данных с использованием foreach
 * (подсказка: вам потребуется поработать с интерфейсом Iterable).
 */
public class Program {
    public static void main(String[] args) {
        Office office = new Office();
        office.addEmployee(new Worker(6, "Worker01", 50000));
        office.addEmployee(new Worker(2, "Worker02", 60000));
        office.addEmployee(new Worker(1, "Worker03", 40000));
        office.addEmployee(new Freelancer(4, "Freelancer01", 400));
        office.addEmployee(new Freelancer(5, "Freelancer02", 500));
        office.addEmployee(new Freelancer(3, "Freelancer03", 300));

        System.out.println("Исходный список");
        System.out.println(office);

        System.out.println("Сортировка по id");
        office.sort();
        System.out.println(office);

        System.out.println("Сортировка по зарплате");
        office.sortBySalary();
        System.out.println(office);

        System.out.println("Итерация по списку");
        for (Employee e: office) {
            System.out.println("\t" + e);
        }
    }
}
