package repository;

import Model.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class UserRepository {
    private final String srcPath = new File("src").getAbsolutePath();
    final String usersPath = "\\data\\Users.txt";

    public UserRepository() {
    }

    public ArrayList<User> readFile() {
        String line;
        try {
            BufferedReader input = new BufferedReader(new FileReader(srcPath + usersPath));
            ArrayList<User> users = new ArrayList<>();
            while((line = input.readLine())!= null){
                String[] attributes = line.split(";");
                for (int i = 0; i < attributes.length; i++) {
                    attributes[i] = attributes[i].trim();
                }
                User user = new User(attributes[0], attributes[1], attributes[2], attributes[3], attributes[4]);
                users.add(user);
            }
            return users;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
