package service;

import Model.*;
import repository.RegisterRepository;
import view.Validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;

public class RegisterService {
    ArrayList<Registration> regisList = new ArrayList<>();
    Validation val;
    RegisterRepository rr = new RegisterRepository();
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    public RegisterService(){
        val = new Validation();
        rr.readFile(regisList);
    }

    public void viewRegister(){
        for(Registration regis: regisList){
//            if(regis.getRegisType().equalsIgnoreCase("Meeting")){
//                Meetings meeting = (Meetings) regis;
//                meeting.showMe();
//            }
//            if(regis.getRegisType().equalsIgnoreCase("Work")){
//                Work work = (Work) regis;
//                work.showMe();
//            }
//            if (regis.getRegisType().equalsIgnoreCase("Study")){
//                Study study = (Study) regis;
//                study.showMe();
//            }
//            if(regis.getRegisType().equalsIgnoreCase("Vacation")){
//                Vacation vacation = (Vacation) regis;
//                vacation.showMe();
//            }
            System.out.println(regis);
        }
    }
    public void addNewRegister(){
        Registration regis = null;
        String empID = val.getAndValidEmployeeId("Enter employee ID: ");
        String regisID = val.getAndValidRegisId("Enter regis ID: ");
        String regisType = val.getAndValidRegisType("Input Registration Type (Meeting/Work/Study/Vacation):");

        //regis vacation
        if(regisType.equalsIgnoreCase("Vacation")){
            Date regisDate = val.getAndCheckDate("Enter Regis Date");
            Date startDate = val.getAndCheckDate("Enter start date off: ");
            Date endDate = val.getAndCheckEndDate("Enter end date off: ", startDate);
            String info = val.getValue("Enter info: ");
            String vacationID = val.getAndValidVacationId("Enter vacation ID: ");
            int bound = val.getAndValidInt("Enter bound: ");
            String location = val.getAndValidString("Enter location: ");
            val.warnIfOverlap(empID, startDate);
            regis = new Vacation(empID, regisID, regisDate, startDate, endDate, info, vacationID, bound, location);
        }

        //regis work
        if(regisType.equalsIgnoreCase("Work")){
            Date regisDate = val.getAndCheckDate("Enter Regis Date");
            Date startDate = val.getAndCheckDate("Enter start date off: ");
            Date endDate = val.getAndCheckEndDate("Enter end date off: ", startDate);            String info = val.getValue("Enter info: ");
            String location = val.getAndValidString("Enter location: ");
            String workID = val.getAndValidString("Enter Work ID: ");
            String vehicle = val.getAndValidString("Enter vehicle: ");
            val.warnIfOverlap(empID, startDate);
            regis = new Work(empID, regisID, regisDate, startDate, endDate, info, location, workID, vehicle);
        }

        //regis study
        if(regisType.equalsIgnoreCase("Study")){
            Date regisDate = val.getAndCheckDate("Enter Regis Date");
            Date startDate = val.getAndCheckDate("Enter start date off: ");
            Date endDate = val.getAndCheckEndDate("Enter end date off: ", startDate);
            String info = val.getValue("Enter info: ");
            String location = val.getAndValidString("Enter location: ");
            String studyID = val.getAndValidStudyId("Enter study ID: ");
            LocalTime startStudyTime = val.getTimeValue("Enter Start Study Time: ");
            LocalTime endStudyTime = val.getTimeValue("Enter End Study Time: ");
            val.warnIfOverlap(empID, startDate);
            regis = new Study(empID, regisID, regisDate, startDate, endDate, info, location, studyID, startStudyTime, endStudyTime);
        }

        //regis meeting
        if(regisType.equalsIgnoreCase("Meeting")){
            Date regisDate = val.getAndCheckDate("Enter Regis Date");
            Date startDate = val.getAndCheckDate("Enter start date off: ");
            Date endDate = val.getAndCheckEndDate("Enter end date off: ", startDate);
            String info = val.getValue("Enter info: ");
            String meetingID = val.getAndValidMeetingId("Enter Meeting ID: ");
            LocalTime startMeetingTime = val.getTimeValue("Enter Start Meeting Time: ");
            LocalTime endMeetingTime = val.getTimeValue("Enter End Meeting Time: ");
            val.warnIfOverlap(empID, startDate);
            regis = new Meetings(regisID, regisDate, startDate, endDate, info, meetingID, startMeetingTime, endMeetingTime);
        }
        regisList.add(regis);
        System.out.println("Add successfully");
    }

    public void viewByTime(Date startTime, Date endTime){
        ArrayList<Registration> scheduleInRange = statisticScheduleByTime(startTime, endTime);
        System.out.println("Schedule In Range: ");
        for(Registration schedule: scheduleInRange){
            System.out.println(schedule);
        }

    }
    private ArrayList<Registration> statisticScheduleByTime(Date startDate, Date endDate){
        ArrayList<Registration> statisticSchedule = new ArrayList<>();
        for(Registration schedule: regisList){
            Date scheduleStartDate = schedule.getStartDate();
            Date scheduleEndDate = schedule.getEndDate();
            if((scheduleStartDate.after(startDate) && scheduleStartDate.before(endDate))
                    || (scheduleEndDate.after(startDate) && scheduleEndDate.before(endDate))){
                statisticSchedule.add(schedule);
            }
        }

        Collections.sort(statisticSchedule, Comparator.comparing(Registration :: getStartDate));
        return statisticSchedule;
    }

    public static void main(String[] args) throws ParseException {
        RegisterService rs = new RegisterService();
//        rs.viewRegister();
//        Date startDate = sdf.parse("2024-03-18");
//        Date endDate = sdf.parse("2024-03-20");
//         rs.viewByTime(startDate, endDate);
        rs.addNewRegister();
    }

}
