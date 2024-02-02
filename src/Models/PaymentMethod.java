package Models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentMethod
{
    private int ID;
    private String Name;

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public void setName(String name)
    {
        Name = name;
    }

    public int getID()
    {
        return ID;
    }

    public String getName()
    {
        return Name;
    }

    public PaymentMethod(int ID) throws SQLException
    {
        DataBaseConnection db= null;
        try
        {
            db = DataBaseConnection.getInstance();
            String sql="SELECT * FROM paymentmethod WHERE ID="+ID;
            ResultSet rs=db.ExecuteSQL(sql);
            setID(ID);
            setName(rs.getString(2));
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void PrintPaymentMethod()
    {
        System.out.println(getID()+" "+getName());
    }
}
