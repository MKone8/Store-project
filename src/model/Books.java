package model;

public class Books extends Product {
    

    public Books(int id, String title) {
        super(id, title);
    }

    public Books(int id, String title, int categoryId) {
        super(id, title, categoryId);
    }

    public Books(int id, String title, int categoryId, double price) {
        super(id, title, categoryId, price);
    }

    @Override
    public String toString() {
        return "Books []";
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }
    
}
