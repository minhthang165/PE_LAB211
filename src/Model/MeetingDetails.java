package Model;

public class MeetingDetails {
    private String meetingDetailsID;
    private String meetingID;
    private String empID;
    private String readOn;

    public MeetingDetails(String meetingDetailsID, String meetingID, String empID, String readOn) {
        this.meetingDetailsID = meetingDetailsID;
        this.meetingID = meetingID;
        this.empID = empID;
        this.readOn = readOn;
    }

    public String getMeetingDetailsID() {
        return meetingDetailsID;
    }

    public void setMeetingDetailsID(String meetingDetailsID) {
        this.meetingDetailsID = meetingDetailsID;
    }

    public String getMeetingID() {
        return meetingID;
    }

    public void setMeetingID(String meetingID) {
        this.meetingID = meetingID;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getReadOn() {
        return readOn;
    }

    public void setReadOn(String readOn) {
        this.readOn = readOn;
    }

    @Override
    public String toString() {
        return "MeetingDetails{" +
                "meetingDetailsID='" + meetingDetailsID + '\'' +
                ", meetingID='" + meetingID + '\'' +
                ", empID='" + empID + '\'' +
                ", readOn='" + readOn + '\'' +
                '}';
    }
}
