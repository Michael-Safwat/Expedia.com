package Models;

import java.sql.ResultSet;

public class Customer extends User
{
    public Customer(int ID)
    {
        try
        {
            setID(ID);
            DataBaseConnection db = DataBaseConnection.getInstance();
            String sql = "SELECT * FROM user WHERE ID=" + ID;
            ResultSet rs = db.ExecuteSQL(sql);

            setFullName(rs.getString(2));
            setEMail(rs.getString(3));
            setPassword(rs.getString(4));
            setDOB(rs.getDate(5));
            Type = new Lookup((rs.getInt(6)), "usertype");
            setDeleted(rs.getBoolean(7));
            setGeneratedOn(rs.getDate(8));
        } catch (Exception e)
        {
            System.out.println(e);
        }
    }

}
