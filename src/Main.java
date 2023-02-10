public class Main {
    public static void main(String[] args) {
        Product product = new Product("Producto 1", 10.0, 5);
        ProductObserver1 observer1 = new ProductObserver1();
        ProductObserver2 observer2 = new ProductObserver2();
        product.addObserver(observer1);
        product.addObserver(observer2);
        product.setPrice(20.0);
        product.setStock(0);
    }
}