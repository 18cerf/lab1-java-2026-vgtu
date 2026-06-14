package org.example.lab1java2026vgtu.model;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * Модель конвертера дат и времени.
 */
public class ConverterModel {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public String convert(String input, String from, String to) {

        Instant instant = toInstant(input, from);

        return fromInstant(instant, to);
    }

    private Instant toInstant(String input, String from) {

        return switch (from) {

            case "DATE_TIME" -> LocalDateTime
                    .parse(input, FORMATTER)
                    .atZone(ZoneId.systemDefault())
                    .toInstant();

            case "UNIX" -> Instant.ofEpochSecond(Long.parseLong(input.trim()));

            case "HUMAN" -> parseHuman(input);

            default -> throw new IllegalArgumentException("Unknown type: " + from);
        };
    }

    private String fromInstant(Instant instant, String to) {

        return switch (to) {

            case "DATE_TIME" -> LocalDateTime
                    .ofInstant(instant, ZoneId.systemDefault())
                    .format(FORMATTER);

            case "UNIX" -> String.valueOf(instant.getEpochSecond());

            case "HUMAN" -> formatHuman(instant);

            default -> throw new IllegalArgumentException("Unknown type: " + to);
        };
    }

    /**
     * Парсинг "через 2 дня", "через 5 часов"
     */
    private Instant parseHuman(String input) {

        String s = input.toLowerCase().trim();

        String[] parts = s.split(" ");

        long value = Long.parseLong(parts[1]);
        String unit = parts[2];

        Duration duration = switch (unit) {
            case "сек", "секунд", "секунды" -> Duration.ofSeconds(value);
            case "мин", "минут", "минуты" -> Duration.ofMinutes(value);
            case "час", "часов", "часа" -> Duration.ofHours(value);
            case "день", "дня", "дней" -> Duration.ofDays(value);
            default -> throw new IllegalArgumentException("Unknown human unit");
        };

        return Instant.now().plus(duration);
    }

    /**
     * Формат обратно в человекочитаемый вид
     */
    private String formatHuman(Instant instant) {

        long seconds = instant.getEpochSecond() - Instant.now().getEpochSecond();

        if (seconds < 60) return "через " + seconds + " секунд";

        long minutes = seconds / 60;
        if (minutes < 60) return "через " + minutes + " минут";

        long hours = minutes / 60;
        if (hours < 24) return "через " + hours + " часов";

        long days = hours / 24;
        return "через " + days + " дней";
    }
}