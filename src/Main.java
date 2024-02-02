import Models.*;

import java.sql.SQLException;

public class Main
{
    public static void main(String[] args) throws SQLException
    {
        User user = new User();
        user.printUser();

        Reservation r=new Reservation(1);
        r.printReservation();
        PaymentMethod p= new PaymentMethod(1);
        p.PrintPaymentMethod();

        Itinerary i=new Itinerary(1);
        i.printItinerary();
        ItineraryDetails id=new ItineraryDetails(1);
        id.Print();
    }
}