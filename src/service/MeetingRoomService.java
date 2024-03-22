package service;

import Model.Department;
import Model.MeetingDetails;
import Model.MeetingLocation;
import repository.MeetingLocationRepository;
import view.Validation;

import java.util.ArrayList;

public class MeetingRoomService {

    ArrayList<MeetingLocation> meetingLocationList = new ArrayList<>();
    Validation val;
    MeetingLocationRepository mlr = new MeetingLocationRepository();
    public MeetingRoomService(){
        val = new Validation();
        mlr.readFile(meetingLocationList);
    }

    //view meeting room
    public void viewMeetingRoom(){
        for(MeetingLocation meetingLocation: meetingLocationList){
            System.out.println(meetingLocation);
        }
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

    //delete location
    public void deleteMeetingLocation(MeetingLocation location){
        meetingLocationList.remove(location);
        System.out.println("Delete Succesfully");
    }

    //update room
    public void updateMeetingLocation(MeetingLocation location){
        String locateID = val.getAndValidString("Enter new locate ID ");
        String roomName = val.getAndValidString("Enter new room name");
        location.setLocateID(locateID);
        location.setLocation(roomName);
        System.out.println("Update successfully");
    }

    public static void main(String[] args) {
        MeetingRoomService mrs = new MeetingRoomService();
        mrs.viewMeetingRoom();
    }
}
