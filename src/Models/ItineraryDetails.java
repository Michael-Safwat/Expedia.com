package Models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItineraryDetails
{
    private int ID;
    private int ItID;
    private int ResID;
    private int ResCount;
    private double ResPrice;
    private Itinerary itinerary;

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public void setItID(int itID)
    {
        ItID = itID;
    }

    public void setResID(int resID)
    {
        ResID = resID;
    }

    public void setResCount(int resCount)
    {
        ResCount = resCount;
    }

    public void setResPrice(double resPrice)
    {
        ResPrice = resPrice;
    }

    public int getID()
    {
        return ID;
    }

    public int getItID()
    {
        return ItID;
    }

    public int getResID()
    {
        return ResID;
    }

    public int getResCount()
    {
        return ResCount;
    }

    public double getResPrice()
    {
        return ResPrice;
    }

    public ItineraryDetails(int ID)
    {
        try
        {
            DataBaseConnection db=DataBaseConnection.getInstance();
            String sql="SELECT * FROM itinerarydetails WHERE ID="+ID;
            ResultSet rs=db.ExecuteSQL(sql);
            setID(ID);
            setItID(rs.getInt(2));
            itinerary=new Itinerary(getItID());
            setResID(rs.getInt(3));
            setResCount(rs.getInt(4));
            setResPrice(rs.getDouble(5));
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

    }
    public void Print()
    {
        System.out.println(getID()+" "+getItID()+" "+getResID()+" "+getResCount()+" "+getResPrice());
    }
}
