public class CustomerFactory {
    Shop shop;
    String name = "tmp";
    public CustomerFactory(Shop shop) {
        this.shop = shop;
    }

    public Customer createCustomer(int type) {
        if(type == 0){
            return new CasualCustomer(name, shop);
        }
        else if(type==1) {
            return new BusinessCustomer(name, shop);
        }
        else if(type==2) {
            return new RegularCustomer(name, shop);
        }
        else {
            return null;
        }
    }
}