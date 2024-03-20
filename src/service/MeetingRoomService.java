package service;

import Model.MeetingDetails;
import Model.MeetingLocation;
import repository.MeetingLocationRepository;
import view.Validation;

import java.util.ArrayList;

public class MeetingRoomService {

    ArrayList<MeetingLocation> meetingLocationList = new ArrayList<>();
    Validation val;
    MeetingLocationRepository mlr = new MeetingLocationRepository();
    private MeetingRoomService(){
        val = new Validation();
        meetingLocationList = mlr.readFile();
    }

    public void addNewRoom(){
        String locateID = val.getAndValidString("Enter room ID: ");
        String location = val.getAndValidString("Enter name of room: ");
        MeetingLocation meetingLocation = new MeetingLocation(locateID, location);
        meetingLocationList.add(meetingLocation);
        System.out.println("Add successfully");
    }

    public MeetingLocation findByID(String locateID){
        for(MeetingLocation locate: meetingLocationList){
            if(locate.getLocateID().equalsIgnoreCase(locateID)){
                System.out.println(locate);
                return locate;
            }
        }
        System.out.println("Can not find that room!");
        return null;
    }
}
