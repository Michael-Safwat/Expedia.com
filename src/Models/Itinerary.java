package Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;

public class Itinerary
{
    private int ID;
    private int CID;
    private Date ReservationDate;
    private Time ReservationTime;
    private double TotalPayedAmount;
    private int PaymentMethod;
    private boolean IsCancelled;
    private boolean IsFinished;
    private Customer customer;
    private PaymentMethod paymentMethod;
    public void setReservationTime(Time reservationTime)
    {
        ReservationTime = reservationTime;
    }

    public Time getReservationTime()
    {
        return ReservationTime;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public void setCID(int CID)
    {
        this.CID = CID;
    }

    public void setReservationDate(Date reservationDate)
    {
        ReservationDate = reservationDate;
    }

    public void setTotalPayedAmount(double totalPayedAmount)
    {
        TotalPayedAmount = totalPayedAmount;
    }

    public void setPaymentMethod(int paymentMethod)
    {
        PaymentMethod = paymentMethod;
    }

    public void setCancelled(boolean cancelled)
    {
        IsCancelled = cancelled;
    }

    public void setFinished(boolean finished)
    {
        IsFinished = finished;
    }

    public int getID()
    {
        return ID;
    }

    public int getCID()
    {
        return CID;
    }

    public Date getReservationDate()
    {
        return ReservationDate;
    }

    public double getTotalPayedAmount()
    {
        return TotalPayedAmount;
    }

    public int getPaymentMethod()
    {
        return PaymentMethod;
    }

    public boolean isCancelled()
    {
        return IsCancelled;
    }

    public boolean isFinished()
    {
        return IsFinished;
    }

    public Itinerary(int ID)
    {
        try
        {
            DataBaseConnection db=DataBaseConnection.getInstance();
            String sql="SELECT * FROM Itinerary WHERE ID="+ID;
            ResultSet rs=db.ExecuteSQL(sql);
            setID(ID);
            setCID(rs.getInt(2));
            customer=new Customer(getCID());
            setReservationDate(rs.getDate(3));
            setReservationTime(rs.getTime(4));
            setTotalPayedAmount(rs.getDouble(5));
            setPaymentMethod(rs.getInt(6));
            paymentMethod=new PaymentMethod(getPaymentMethod());
            setCancelled(rs.getBoolean(7));
            setFinished(rs.getBoolean(8));
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }


    }

    public void printItinerary()
    {
        System.out.println(getID()+" "+getCID()+" ");
    }

}
