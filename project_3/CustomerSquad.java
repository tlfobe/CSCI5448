import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CustomerSquad {
    CustomerFactory fact;
    Shop shop;
    float fullTotal = 0.0f;
    int rents = 0;
    int casual_rents = 0;
    int business_rents = 0;
    int regular_rents = 0;
    
    List<Customer> customers = new ArrayList<Customer>();

    public CustomerSquad(Shop shop, int number_customers) {
        String[] names = new String[] {
            "Laura", "Liam", "Yash", 
            "Lenny", "Chandler", "Jim",
            "Phoebe", "Ross", "Rachel", 
            "Joey", "Monica", "Marcel"};
        this.shop = shop;
        fact = new CustomerFactory(this.shop);

        for(int i = 0; i<number_customers; i++) {
            int n = new Random().nextInt(3);
            Customer t = fact.createCustomer(n, names[i]);
            shop.attach(t);
            customers.add(t);    
        }
    }

    public void runDay() {

        System.out.println(" # # # Current Rental Situation # # # ");
        int cars_out_for_rent = 0;
        for(Customer c: customers) {
            if(c.rented_cars.size() > 0) {
                System.out.println(c.name + " currently has: ");
                for(Car rented : c.rented_cars) {
                    System.out.print(rented.licensePlate + ", ");
                    cars_out_for_rent ++;
                }
                System.out.println(); System.out.println();
            }
        }
        System.out.println("Number of cars out for rental: " + cars_out_for_rent + " \n ");

        // day cycle (renting cars)
        System.out.println(" # # # Rents for the Day # # # ");
        for(Customer c : customers) {
            if(new Random().nextFloat() > 0.5f && c.getViable()) {
                // System.out.println(c.name + " is renting a car.");
                System.out.println(c.name + ", is a " + c.getClass().getSimpleName() + ", rents the following car(s): ");
                int customer_rents = c.rentCars(shop);
                rents += customer_rents;
                if(c.getClass().getSimpleName().equals("BusinessCustomer")) {
                    business_rents += customer_rents;
                } else if(c.getClass().getSimpleName().equals("CasualCustomer")) {
                    casual_rents += customer_rents;
                } else if(c.getClass().getSimpleName().equals("RegularCustomer")) {
                    regular_rents += customer_rents;
                }


                System.out.println();
                shop.setState();
            }
        }
        
        // night cycle
        for(Customer c : customers) {c.endDay();}
        float dailyTotal = shop.getDailyTotal();
        fullTotal += dailyTotal;
        System.out.println("Daily Total: " + dailyTotal);
        shop.resetDay();
    }


}


