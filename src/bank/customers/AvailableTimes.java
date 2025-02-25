package bank.customers;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public final class AvailableTimes {

    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("h:mm");
    private static final List<LocalTime> availableTimes = new ArrayList<>();

    static {
        // Initialize available times once.
        for (int minutes = 9 * 60; minutes <= 14 * 60; minutes += 30) {
            int hour = minutes / 60;
            int minute = minutes % 60;
            availableTimes.add(LocalTime.of(hour, minute));
        }
    }

    private AvailableTimes() {}

    public static synchronized List<LocalTime> getAvailableTimes() {
        return new ArrayList<>(availableTimes);
    }

    public static synchronized boolean removeTime(LocalTime time) {
        return availableTimes.remove(time);
    }

    public static DateTimeFormatter getTimeFormatter() {
        return TIME_FORMATTER;
    }
}
