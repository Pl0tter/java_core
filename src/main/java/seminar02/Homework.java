package seminar02;

import java.util.Random;
import java.util.Scanner;

/**
 * 1. Полностью разобраться с кодом программы разработанной на семинаре, переписать программу.
 * Это минимальная задача для сдачи домашней работы.
 * Усложняем задачу:
 * 2.* Переработать метод проверки победы, логика проверки победы должна работать для поля 5х5 и
 * количества фишек 4. Очень желательно не делать это просто набором условий для каждой из
 * возможных ситуаций! Используйте вспомогательные методы, используйте циклы!
 * 3.**** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.
 */

public class Homework {

    private static final char DOT_HUMAN = 'X'; // Фишка игрока - человека
    private static final char DOT_AI = '0'; // Фишка игрока - компьютер
    private static final char DOT_EMPTY = '*'; // Признак пустого поля
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static char[][] field; // Двумерный массив хранит состояние игрового поля
    private static int fieldSizeX; // Размерность игрового поля
    private static int fieldSizeY; // Размерность игрового поля
    private static int WIN_COUNT; // Кол-во фишек для победы

    public static void main(String[] args) {
        WIN_COUNT = 5;
        while (true) {
            initialize(5, 5);
            printField();
            while (true) {
                humanTurn();
                printField();
                if (gameCheck(DOT_HUMAN, "Вы победили!"))
                    break;
                aiTurn();
                printField();
                if (gameCheck(DOT_AI, "Победил компьютер!"))
                    break;
            }
            System.out.print("Желаете сыграть еще раз? (Y - да): ");
            if (!scanner.next().equalsIgnoreCase("Y"))
                break;
        }
    }

    /**
     * Инициализация начального состояния игры
     */
    private static void initialize(int sizeX, int sizeY) {
        fieldSizeX = sizeX;
        fieldSizeY = sizeY;
        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    /**
     * Отрисовать текущее состояние игрового поля
     */
    private static void printField() {
        System.out.print("+");
        for (int i = 0; i < fieldSizeX * 2 + 1; i++) {
            System.out.print((i % 2 == 0) ? "-" : i / 2 + 1);
        }
        System.out.println();

        for (int i = 0; i < fieldSizeY; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < fieldSizeX; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }

        for (int i = 0; i < fieldSizeX * 2 + 2; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    /**
     * Обработка хода игрока (человека)
     */
    private static void humanTurn() {
        int x, y;
        int max = (fieldSizeX > fieldSizeY) ? fieldSizeX : fieldSizeY;
        do {
            System.out.print("Укажите координаты хода X и Y (от 1 до " + max + ")\nчерез пробел: ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        }
        while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[x][y] = DOT_HUMAN;
    }

    /**
     * Обработка хода компьютера
     */
    static void aiTurn() {
        int x, y;
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if (isCellEmpty(i, j)) {
                    field[i][j] = DOT_HUMAN;
                    if (checkWin(DOT_HUMAN)) {
                        field[i][j] = DOT_AI;
                        return;
                    } else {
                        field[i][j] = DOT_EMPTY;
                    }
                }
            }
        }
        do {
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        }
        while (!

                isCellEmpty(x, y));
        field[x][y] = DOT_AI;
    }

    /**
     * Проверка, ячейка является пустой (DOT_EMPTY)
     *
     * @param x
     * @param y
     * @return
     */
    static boolean isCellEmpty(int x, int y) {
        return field[x][y] == DOT_EMPTY;
    }

    /**
     * Проверка состояния игры
     *
     * @param dot    фишка игрока
     * @param winStr победный слоган
     * @return признак продолжения игры (true - завершение игры)
     */
    static boolean gameCheck(char dot, String winStr) {
        if (checkWin(dot)) {
            System.out.println(winStr);
            return true;
        }
        if (checkDraw()) {
            System.out.println("Ничья!");
            return true;
        }
        return false; // Продолжим игру
    }

    /**
     * Проверка корректности ввода
     *
     * @param x
     * @param y
     * @return
     */
    static boolean isCellValid(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    /**
     * Проверка победы
     *
     * @param c фишка игрока (X или 0)
     * @return
     */
    static boolean checkWin(char c) {
        int countX;
        int countY;
        int countD1;
        int countD2;
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                if (field[x][y] == c) {
                    countX = 1;
                    countY = 1;
                    countD1 = 1;
                    countD2 = 1;
                    for (int i = 1; i < WIN_COUNT; i++) {
                        // проверка по горизонтали
                        if (y + WIN_COUNT <= fieldSizeY) {
                            if (field[x][y + i] == c) countX += 1;
                        }
                        // проверка по вертикали
                        if (x + WIN_COUNT <= fieldSizeX) {
                            if (field[x + i][y] == c) countY += 1;
                        }
                        // проверка по диагонали вниз
                        if (y + WIN_COUNT <= fieldSizeY && x + WIN_COUNT <= fieldSizeX) {
                            if (field[x + i][y + i] == c) countD1 += 1;
                        }
                        // проверка по диагонали вверх
                        if (y + WIN_COUNT <= fieldSizeY && x - WIN_COUNT >= -1) {
                            if (field[x - i][y + i] == c) countD2 += 1;
                        }
                    }
                    if (countX == WIN_COUNT || countY == WIN_COUNT || countD1 == WIN_COUNT || countD2 == WIN_COUNT)
                        return true;
                }
            }
        }
        return false;
    }

    /**
     * Проверка на ничью
     *
     * @return
     */
    static boolean checkDraw() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (isCellEmpty(i, j)) return false;
            }
        }
        return true;
    }

}
