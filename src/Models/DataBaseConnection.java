package Models;

import java.sql.*;

public class DataBaseConnection
{

    private static DataBaseConnection instance = null;
    private Connection con = null;

    private DataBaseConnection()
    {
    }

    private void init()
    {
        try
        {
            String pass = "";
            String userName = "root";
            String url = "jdbc:mysql://localhost:3306/expedia.com";

            con = DriverManager.getConnection(url, userName, pass);
            System.out.println("Connected to Database");
        } catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public Connection getConnection()
    {
        return con;
    }

    public static DataBaseConnection getInstance() throws SQLException
    {
        if (instance == null || instance.getConnection().isClosed())
        {
            instance = new DataBaseConnection();
            instance.init();
        }
        return instance;
    }

    public ResultSet ExecuteSQL(String sql) throws SQLException
    {
        Statement st = instance.getConnection().createStatement();
        ResultSet rs = st.executeQuery(sql);
        rs.next();
        return rs;
    }
}
