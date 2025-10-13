package calculator;

import java.util.Scanner;

public class Calculator {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continueCalculation = true;

        System.out.println("Привет! Это улучшенный калькулятор.");

        while (continueCalculation) {
            showMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1 -> performAddition();
                case 2 -> performSubtraction();
                case 3 -> performMultiplication();
                case 4 -> performDivision();
                case 5 -> performPower();
                case 6 -> performSquareRoot();
                case 0 -> continueCalculation = false;
                default -> System.out.println("Неверный выбор. Попробуйте ещё раз.");
            }
        }

        System.out.println("Спасибо за использование калькулятора. До свидания!");
        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\nВыберите операцию:");
        System.out.println("1. Сложение");
        System.out.println("2. Вычитание");
        System.out.println("3. Умножение");
        System.out.println("4. Деление");
        System.out.println("5. Возведение в степень");
        System.out.println("6. Извлечение квадратного корня");
        System.out.println("0. Выход");
    }

    private static void performAddition() {
        try {
            System.out.print("Введите первое число: ");
            double num1 = scanner.nextDouble();
            System.out.print("Введите второе число: ");
            double num2 = scanner.nextDouble();
            double result = num1 + num2;
            System.out.printf("Результат: %.2f%n", result); // Форматирование до 2 знаков
        } catch (Exception e) {
            System.out.println("Ошибка! Пожалуйста, введите число.");
            scanner.nextLine(); // Очищаем буфер ввода
        }
    }

    //В методах добавить try-catch
    private static void performSubtraction() {
        System.out.print("Введите первое число: ");
        double a = scanner.nextDouble();
        System.out.print("Введите второе число: ");
        double b = scanner.nextDouble();

        System.out.printf("Результат: %.2f", a - b);
    }

    private static void performMultiplication() {
        System.out.print("Введите первое число: ");
        double a = scanner.nextDouble();
        System.out.print("Введите второе число: ");
        double b = scanner.nextDouble();

        System.out.printf("Результат: %.2f", a * b);
    }

    private static void performDivision() {
        System.out.print("Введите первое число: ");
        double a = scanner.nextDouble();
        System.out.print("Введите второе число: ");
        double b = scanner.nextDouble();

        if (b != 0) {
            System.out.printf("Результат: %.2f", a / b);
        } else {
            throw new ArithmeticException("❌ На ноль делить нельзя!");
        }
    }

    private static void performPower() {
        System.out.print("Введите основание: ");
        double base = scanner.nextDouble();
        System.out.print("Введите показатель степени: ");
        double exponent = scanner.nextDouble();
        System.out.println("Результат: " + Math.pow(base, exponent));
    }

    private static void performSquareRoot() {
        System.out.print("Введите число: ");
        double num = scanner.nextDouble();

        if (num >= 0) {
            System.out.println("Результат: " + Math.sqrt(num));
        } else {
            throw new ArithmeticException("❌ Ошибка! Нельзя извлечь корень из отрицательного числа.");
        }
    }

    private static int getUserChoice() {
        while (true) {
            try {
                System.out.println("Ваш выбор: ");
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Ошибка! Введите нужную операцию. 1 - 6 или 0");
                scanner.nextLine();
            }
        }
    }
}
