import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(Product product);
}

interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

class Product implements Observable {
    public String description;
    public double price;
    public int stock;
    private List<Observer> observers;

    public Product(String description, double price, int stock) {
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.observers = new ArrayList<>();
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }

    public void setStock(int stock) {
        this.stock = stock;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        if (price > 0 && stock > 0) {
            for (Observer observer : observers) {
                observer.update(this);
            }
        }
    }
}

class ProductObserver1 implements Observer {
    @Override
    public void update(Product product) {
        System.out.println("Observer 1: Producto actualizado - Descripción: " + product.description + ", Precio: " + product.price + ", Stock: " + product.stock);
    }
}

class ProductObserver2 implements Observer {
    @Override
    public void update(Product product) {
        System.out.println("Observer 2: Producto actualizado - Descripción: " + product.description + ", Precio: " + product.price + ", Stock: " + product.stock);
    }
}


