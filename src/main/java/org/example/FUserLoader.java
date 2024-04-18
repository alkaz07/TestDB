package org.example;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class FUserLoader implements IUsersLoader{

    String fileName;

    public FUserLoader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public ArrayList<User> loadUsers() throws Exception {
        ArrayList<User> users= new ArrayList<>();
        Scanner scanner = new Scanner(new File(fileName));
        while (scanner.hasNextLine()){
            String s = scanner.nextLine();
            String[] parts = s.split(",");
            int id = Integer.parseInt(parts[0]);
            double money = Double.parseDouble(parts[2]);
            String fio = parts[1];
            User u = new User(id, fio, money);
            users.add(u);
        }
        return users;
    }
}
