public class Simulator {
    public static void main(String[] args) {
        Shop lennyYash = new Shop(24);
        CustomerSquad squad = new CustomerSquad(lennyYash, 12);
        
        for(int i=0; i < 35; i++) {
            System.out.println("----------------------------------------");
            System.out.println("Day: " + i);
            lennyYash.listRemainingCars();
            System.out.println();
            squad.runDay();
            lennyYash.setState();
        }
        System.out.println("----------------------------------------");
        
        System.out.println("Total amount made: $" + squad.fullTotal);
        System.out.println("Total number of rentals made: " + squad.number_of_rentals);

    }
}



