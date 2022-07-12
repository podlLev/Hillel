public class Warehouse {

    public <T> void handlingOfProduct(T product){
        System.out.println("A new product came to the warehouse:\n" + product);
    }

    public void seasonOfReceiptProduct(Month month){
        if (month.compareTo(Month.FEBRUARY) < 1) {
            System.out.println("Product came in winter");
        } else if (month.compareTo(Month.MAY) < 1) {
            System.out.println("Product came in spring");
        } else if (month.compareTo(Month.AUGUST) < 1){
            System.out.println("Product came in summer");
        } else if (month.compareTo(Month.NOVEMBER) < 1) {
            System.out.println("Product came in autumn");
        } else{
            System.out.println("Product came in winter");
        }
    }
}
