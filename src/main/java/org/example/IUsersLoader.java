package org.example;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IUsersLoader {
    ArrayList<User> loadUsers() throws Exception;
}
