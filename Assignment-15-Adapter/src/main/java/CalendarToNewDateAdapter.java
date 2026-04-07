import java.util.Calendar;

public class CalendarToNewDateAdapter implements NewDateInterface{
    Calendar calendar;

    public CalendarToNewDateAdapter(Calendar calendar) {
        this.calendar = calendar;
    }

    @Override
    public void setDay(int day) {
        calendar.set(Calendar.DAY_OF_WEEK, day);
    }

    @Override
    public void setMonth(int month) {
        calendar.set(Calendar.MONTH, month);
    }

    @Override
    public void setYear(int year) {
        calendar.set(Calendar.YEAR, year);
    }

    @Override
    public int getDay() {
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    @Override
    public int getMonth() {
        return calendar.get(Calendar.MONTH);
    }

    @Override
    public int getYear() {
        return calendar.get(Calendar.YEAR);
    }

    @Override
    public void advanceDays(int days) {
        calendar.set(Calendar.DAY_OF_WEEK, calendar.get(Calendar.DAY_OF_WEEK) + days);
    }
}
