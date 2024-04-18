package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBUserLoader implements IUsersLoader {
    Connection connection;

    public DBUserLoader(Connection connection) {
        this.connection = connection;
    }

    @Override
    public ArrayList<User> loadUsers() throws SQLException {
        ArrayList<User> users = new ArrayList<>();
        Statement st = this.connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM public.user");
        while (rs.next()) {
            int x = rs.getInt("id");
            String fio = rs.getString("fio");
            double m = rs.getDouble("money");
            users.add(new User(x, fio, m));
        }
        rs.close();
        st.close();
        return users;
    }
}