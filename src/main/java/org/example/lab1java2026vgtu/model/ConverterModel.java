package org.example.lab1java2026vgtu.model;

/**
 * Модель конвертера.
 * Содержит логику перевода единиц измерения.
 */
public class ConverterModel {

    /**
     * Конвертация значения из одной единицы в другую.
     *
     * @param value значение
     * @param from исходная единица (m, cm, km)
     * @param to целевая единица (m, cm, km)
     * @return результат конвертации
     */
    public double convert(double value, String from, String to) {
        double fromFactor = getFactor(from);
        double toFactor = getFactor(to);

        return value * fromFactor / toFactor;
    }

    /**
     * Коэффициенты перевода в метры.
     */
    private double getFactor(String unit) {
        return switch (unit) {
            case "cm" -> 0.01;
            case "m" -> 1.0;
            case "km" -> 1000.0;
            default -> throw new IllegalArgumentException("Неизвестная единица: " + unit);
        };
    }
}
