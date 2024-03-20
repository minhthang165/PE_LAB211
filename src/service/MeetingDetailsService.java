package service;

import Model.MeetingDetails;
import repository.MeetingDetailsRepository;
import repository.MeetingLocationRepository;
import view.Validation;

import java.util.ArrayList;

public class MeetingDetailsService {
    ArrayList<MeetingDetails> meetingDetailList = new ArrayList<>();
    Validation val;
    MeetingDetailsRepository mdr = new MeetingDetailsRepository();

    private MeetingDetailsService(){
        val = new Validation();
        meetingDetailList = mdr.readFile();
    }

    public void addNewMeetingDetails(){
        String meetingDetailsID = val.getAndValidString("Enter meeting details ID: ");
        String meetingID = val.getAndValidString("Enter meeting ID: ");
        String empID = val.getAndValidString("Enter employee ID: ");
        String readOn = val.getAndValidString("Enter Date: ");
        MeetingDetails newMeetingDetail = new MeetingDetails(meetingDetailsID, meetingID, empID, readOn);
        meetingDetailList.add(newMeetingDetail);
        System.out.println("Add successfully");
    }

    public MeetingDetails findByID(String id){
        for(MeetingDetails meetingDetail: meetingDetailList){
            if(meetingDetail.getMeetingDetailsID().equalsIgnoreCase(id)){
                System.out.println(meetingDetail);
                return meetingDetail;
            }
        }
        System.out.println("Can not find that room");
        return null;
    }
}
