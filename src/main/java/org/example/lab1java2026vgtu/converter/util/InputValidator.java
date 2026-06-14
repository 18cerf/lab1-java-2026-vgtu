package org.example.lab1java2026vgtu.converter.util;


/**
 * Класс для проверки пользовательского ввода.
 */
public class InputValidator {

    /**
     * Проверка: пустая ли строка.
     */
    public static boolean isEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    /**
     * Проверка: является ли строка числом.
     */
    public static boolean isNumeric(String input) {
        if (isEmpty(input)) return false;

        try {
            Double.parseDouble(input.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Проверка: число положительное.
     */
    public static boolean isPositive(String input) {
        if (!isNumeric(input)) return false;
        return Double.parseDouble(input.trim()) > 0;
    }

    /**
     * Проверка: не превышает ли число максимум.
     */
    public static boolean isUnderMax(String input, double maxValue) {
        if (!isNumeric(input)) return false;
        return Double.parseDouble(input.trim()) <= maxValue;
    }
}