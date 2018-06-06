package com.qpi.server;

import com.qpi.client.DatabaseHandler;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.sql.*;

/**
 * Created by pingp on 6/1/2018.
 */
public class DatabaseHandlerImpl extends RemoteServiceServlet
        implements DatabaseHandler{

    private final String connection_URL = "jdbc:postgresql://qpidata.cnux5xpemugc.us-west-2.rds.amazonaws.com:5432/MVPData?user=qpiAdmin&password=QpiRaspberry";

    public String validateLogin(String user, String pw) throws Exception{
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DriverManager.getConnection(connection_URL);
            ps = connection.prepareStatement("SELECT password FROM users WHERE user_name = '" + user+"'");
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString("password").equals(pw)) {
                    return "You're Logged in!";
                }
                return "Wrong Password.";
            }
            return "Wrong username or password.";
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (connection != null) connection.close();
        }
    }
}
