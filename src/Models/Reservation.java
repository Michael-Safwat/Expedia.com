package Models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Reservation
{
    private int ID;
    private int ResCat;
    private double Price;
    private int AvailableSlots;
    private Lookup ResCatObj;

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public void setResCat(int resCat)
    {
        ResCat = resCat;
    }

    public void setPrice(double price)
    {
        Price = price;
    }

    public void setAvailableSlots(int availableSlots)
    {
        AvailableSlots = availableSlots;
    }

    public int getID()
    {
        return ID;
    }

    public int getResCat()
    {
        return ResCat;
    }

    public double getPrice()
    {
        return Price;
    }

    public int getAvailableSlots()
    {
        return AvailableSlots;
    }

    public Reservation(int ID)
    {
        try
        {
            DataBaseConnection db=DataBaseConnection.getInstance();
            String sql="SELECT * FROM reservation WHERE ID="+ID;
            ResultSet rs=db.ExecuteSQL(sql);

            setID(ID);
            setResCat(rs.getInt(2));
            setPrice(rs.getDouble(3));
            setAvailableSlots(rs.getInt(4));
            ResCatObj=new Lookup(getResCat(),"reservationcategory");
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

    }

    public void printReservation()
    {
        System.out.println(getID()+" "+getResCat()+" "+getPrice()+" "+getAvailableSlots());
        ResCatObj.printLookup();
    }
}
