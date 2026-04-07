public class Main {
    public static void main(String[] args) {
        CalendarToNewDateAdapter calendarToNewDateAdapter = new CalendarToNewDateAdapter(java.util.Calendar.getInstance());
        calendarToNewDateAdapter.setDay(1);
        calendarToNewDateAdapter.setMonth(4);
        calendarToNewDateAdapter.setYear(2024);

        System.out.println("Current Date: " + calendarToNewDateAdapter.getDay() + "/" + calendarToNewDateAdapter.getMonth() + "/" + calendarToNewDateAdapter.getYear());

        calendarToNewDateAdapter.advanceDays(4);

        System.out.println("Date after advancing 4 days: " + calendarToNewDateAdapter.getDay() + "/" + calendarToNewDateAdapter.getMonth() + "/" + calendarToNewDateAdapter.getYear());
    }
}
