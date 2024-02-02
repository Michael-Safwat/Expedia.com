package Models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Lookup
{
    private int ID;
    private String Name;
    public int getID()
    {
        return ID;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public void setName(String name)
    {
        Name = name;
    }

    public String getName()
    {
        return Name;
    }

    public Lookup(int ID,String TableName) throws SQLException
    {
        try
        {
            DataBaseConnection db=DataBaseConnection.getInstance();
            String sql="SELECT * FROM "+TableName+" WHERE ID="+ID;
            ResultSet rs=db.ExecuteSQL(sql);
            setID(rs.getInt(1));
            setName((rs.getString(2)));
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public void printLookup()
    {
        System.out.println(getID()+" "+getName());
    }
}
