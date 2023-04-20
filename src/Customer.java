public class Customer  {
    //private String customerName;
    private int customerType;
    public  int[] customerTypeSet = {0,5,10}; 
    
    Customer(int customerType) {
        this.customerType = customerType;
    }


    //CLI validation
    /*public int getCustomerType() {
        while (true) {
            int counter=0;
                for(int i=0;i<customerTypeSet.length;i++) {
                    if (customerType != customerTypeSet[i]) {
                        counter++;
                    }
                }
                if (counter != customerTypeSet.length) {
                    break;
                }
        } 
       return customerType;
        }*/

    public double customerMargin() {
        double margin = customerType * 0.01 + 1;
        return margin;
    }


}
