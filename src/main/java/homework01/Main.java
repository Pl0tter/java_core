package homework01;

import homework01.logic.Car;
import homework01.logic.CarBuilder;
import homework01.logic.EngineType;

public class Main {
    /**
     * Создать проект из трёх классов (основной с точкой входа и два класса в другом пакете),
     * которые вместе должны составлять одну программу, позволяющую
     * производить четыре основных математических действия и осуществлять форматированный
     * вывод результатов пользователю (ИЛИ ЛЮБОЕ ДРУГОЕ ПРИЛОЖЕНИЕ НА ВАШ ВЫБОР,
     * которое просто демонстрирует работу некоторого механизма).
     * <p>
     * Необходимо установить Docker Desktop.
     * Создать Dockerfile, позволяющий откопировать исходный код вашего приложения в образ для демонстрации работы
     * вашего приложения при создании соответствующего контейнера.
     * <p>
     * Подобную процедуру мы с вами проделали на уроке, теперь необходимо проделать данную процедуру самостоятельно.
     *
     * @param args
     */
    public static void main(String[] args) {
        Car car = CarBuilder.getInstance().setVin(65656565).setModel("Camry").build();

        Car car2 = CarBuilder.getInstance().setVin(65656565).setOwner("Vladimir").setModel("Camry").setColor("black")
                .setEngine(EngineType.PETROL).build();
        System.out.println(car2);
    }
}
