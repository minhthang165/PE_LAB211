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
    private final String EMPID_REGEX = "^EMP[0-9]{3}$";
    private final String REGID_REGEX = "^REG[0-9]{3}$";
    private final String MEETINGID_REGEX = "^MEET[0-9]{3}$";
    private final String DEPID_REGEX = "^DEP[0-9]{3}$";
    private final String VACATIONID_REGEX = "^VAC[0-9]{3}$";
    private final String USERID_REGEX = "^USR[0-9]{3}$";
    private final String NOTIFICATIONID_REGEX = "^NT[0-9]{3}$";
    private final String STUDYID_REGEX = "^STD[0-9]{3}$";
    ArrayList<Registration> schedules = new ArrayList<>();

    public String getValue(String msg) {
        Scanner sc = new Scanner(System.in);
        System.out.println(msg);
        return sc.nextLine().trim();
    }

    //valid Employee ID
    public String getAndValidEmployeeId(String msg){
        String input;
        while(true){
            try{
                input = getValue(msg);
                if(!input.matches(EMPID_REGEX)){
                    System.out.println("Invalid Employee ID, please type again!");
                    continue;
                }
                return input;
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    //valid registration id
    public String getAndValidRegisId(String msg){
        String input;
        while(true){
            try{
                input = getValue(msg);
                if(!input.matches(REGID_REGEX)){
                    System.out.println("Invalid Registration ID, please type again!");
                    continue;
                }
                return input;
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    //valid meeting id
    public String getAndValidMeetingId(String msg){
        String input;
        while(true){
            try{
                input = getValue(msg);
                if(!input.matches(MEETINGID_REGEX)){
                    System.out.println("Invalid Meeting ID, please type again!");
                    continue;
                }
                return input;
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    //valid department id
    public String getAndValidDepartmentId(String msg){
        String input;
        while(true){
            try{
                input = getValue(msg);
                if(!input.matches(DEPID_REGEX)){
                    System.out.println("Invalid Department ID, please type again!");
                    continue;
                }
                return input;
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }


    //valid vacation
    public String getAndValidVacationId(String msg){
        String input;
        while(true){
            try{
                input = getValue(msg);
                if(!input.matches(VACATIONID_REGEX)){
                    System.out.println("Invalid Vacation ID, please type again!");
                    continue;
                }
                return input;
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    //valid user id
    public String getAndValidUserId(String msg){
        String input;
        while(true){
            try{
                input = getValue(msg);
                if(!input.matches(USERID_REGEX)){
                    System.out.println("Invalid User ID, please type again!");
                    continue;
                }
                return input;
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    //valid notification id
    public String getAndValidNotificationId(String msg){
        String input;
        while(true){
            try{
                input = getValue(msg);
                if(!input.matches(NOTIFICATIONID_REGEX)){
                    System.out.println("Invalid Notification ID, please type again!");
                    continue;
                }
                return input;
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    //valid study ID
    public String getAndValidStudyId(String msg){
        String input;
        while(true){
            try{
                input = getValue(msg);
                if(!input.matches(STUDYID_REGEX)){
                    System.out.println("Invalid Study ID, please type again!");
                    continue;
                }
                return input;
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
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
                if (!(input.matches(stringRegex) || input.matches(intRegex))){
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

    //valid end date
    public Date getAndCheckEndDate(String msg, Date startDate) {
        String input;
        while (true) {
            try {
                input = getValue(msg);
                Date date = sdf.parse(input);
                if (!validateDateAndMonth(date)) {
                    System.out.println("Invalid date, please input again");
                    continue;
                }
                else if(date.before(startDate)){
                    System.out.println("Invalid date");
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
