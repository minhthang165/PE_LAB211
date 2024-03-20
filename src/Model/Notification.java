package Model;

public class Notification {
    private String notiID;
    private String personNoticeID;
    private String personNoticedID;
    private String info;

    public Notification(String notiID, String personNoticeID, String personNoticedID, String info) {
        this.notiID = notiID;
        this.personNoticeID = personNoticeID;
        this.personNoticedID = personNoticedID;
        this.info = info;
    }

    public String getNotiID() {
        return notiID;
    }

    public void setNotiID(String notiID) {
        this.notiID = notiID;
    }

    public String getPersonNoticeID() {
        return personNoticeID;
    }

    public void setPersonNoticeID(String personNoticeID) {
        this.personNoticeID = personNoticeID;
    }

    public String getPersonNoticedID() {
        return personNoticedID;
    }

    public void setPersonNoticedID(String personNoticedID) {
        this.personNoticedID = personNoticedID;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
