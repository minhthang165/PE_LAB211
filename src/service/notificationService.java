package service;

import Model.Notification;
import Model.Registration;
import repository.NotificationRepository;
import repository.RegisterRepository;
import view.Validation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class notificationService {
    ArrayList<Notification> notiList = new ArrayList<>();
    NotificationRepository nr = new NotificationRepository();
    Validation val;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public notificationService(){
        notiList = nr.readFile();
    }

    public void viewNotifications(){
        System.out.println(notiList);
    }
}
