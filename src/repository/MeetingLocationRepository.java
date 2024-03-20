package repository;

import Model.MeetingLocation;
import Model.Meetings;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;

public class MeetingLocationRepository {
    private final String srcPath = new File("src").getAbsolutePath();
    final String meetingLocatePath = "\\data\\MeetingLocation.txt";
    final String DATE_FORMAT = "yyyy-MM-dd";
    final String HOUR_FORMAT = "HH:mm:ss";
    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
//    SimpleDateFormat hourFormat = new SimpleDateFormat(HOUR_FORMAT);

    public MeetingLocationRepository() {
    }

    public ArrayList<MeetingLocation> readFile() {
        String line;
        try {
            BufferedReader input = new BufferedReader(new FileReader(srcPath + meetingLocatePath));
            ArrayList<MeetingLocation> meetingLocates = new ArrayList<>();
            while ((line = input.readLine()) != null) {
                String[] attributes = line.split(";");
                for (int i = 0; i < attributes.length; i++) {
                    attributes[i] = attributes[i].trim();
                }
                MeetingLocation meetingLocate = new MeetingLocation(attributes[0], attributes[1]);
                meetingLocates.add(meetingLocate);
            }
            return meetingLocates;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
