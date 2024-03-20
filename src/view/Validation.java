package view;

import Model.Registration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;

public class Validation {
    final String DATE_FORMAT = "yyyy-MM-dd";
    final String stringRegex = "[a-zA-Z]+";
    private final String intRegex = ".*\\d+.*";
    ArrayList<Registration> schedules = new ArrayList<>();

    public String getValue(String msg) {
        Scanner sc = new Scanner(System.in);
        System.out.println(msg);
        return sc.nextLine().trim();
    }

    public void warnIfOverlap(String empID,
                              Date startDate) {
        for (int i = 0; i < schedules.size(); i++) {
            Registration currentSchedule = schedules.get(i);
            if(currentSchedule.getEmpID().equalsIgnoreCase(empID)){
                if (isOverlap(currentSchedule, startDate)) {
                    System.out.println("Warning: Schedule overlap detected!");
                }
            }
        }
    }

    // check if overlaps
    private boolean isOverlap(Registration schedule1, Date startDate) {
        return !schedule1.getEndDate().before(startDate)
                && !startDate.before(schedule1.getStartDate());
    }

    public String getAndValidRegisType(String msg) {
        String input;
        Set<String> validQualification = new HashSet<>(Set.of("Meeting", "Work", "Study", "Vacation"));
        while (true) {
            try {
                input = getValue(msg);
                if (!validQualification.contains(input)) {
                    System.out.println("Invalid qualification, please type again");
                    continue;
                }
                return input;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String getAndValidString(String msg) {
        String input;
        while (true) {
            try {
                input = getValue(msg);
                if (!(input.matches(stringRegex) && input.matches(intRegex))){
                    System.out.println("Invalid input, please type again!");
                    continue;
                }
                return input;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getAndValidInt(String msg) {
        String input;
        while (true) {
            try {
                input = getValue(msg);
                if (!input.matches(intRegex)) {
                    System.out.println("Invalid input, please type again!");
                    continue;
                }

                return Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Date getAndCheckDate(String msg) {
        String input;
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        sdf.setLenient(false); // ensure that the input strict validation.
        while (true) {
            try {
                input = getValue(msg);
                Date date = sdf.parse(input);
                if (!validateDateAndMonth(date)) {
                    System.out.println("Invalid date, please input again");
                    continue;
                }
                return date;
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean validateDateAndMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return (month >= 1 && month <= 12) && (day >= 1 && day <= cal.getActualMaximum(Calendar.DAY_OF_MONTH));
    }

    public LocalTime getTimeValue(String msg) {
        String input;
        while (true) {
            try {
                input = getValue(msg);
                LocalTime time = LocalTime.parse(input);
                return time;
            } catch (Exception e) {
                System.out.println("Invalid time format, please try again (HH:mm:ss)");
            }
        }
    }
}
