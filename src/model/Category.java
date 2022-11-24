package model;

public class Category extends Product {

    public Category(int id, String title, String category) {
        super(id, title, category);
    }

    public Category(int id, String title, String category, double price) {
        super(id, title, category, price);
    }

    public Category(int id, String category) {
        super(id, category);
        //TODO Auto-generated constructor stub
        // zmieniłem tu z title na category (ciekawe co sie stanie)
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }

    @Override
    public String getCategory() {
        // TODO Auto-generated method stub
        return super.getCategory();
    }

    @Override
    public int getId() {
        // TODO Auto-generated method stub
        return super.getId();
    }

    @Override
    public Double getPrice() {
        // TODO Auto-generated method stub
        return super.getPrice();
    }

    @Override
    public String getTitle() {
        // TODO Auto-generated method stub
        return super.getTitle();
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }

    @Override
    public void setCategory(String category) {
        // TODO Auto-generated method stub
        super.setCategory(category);
    }

    @Override
    public void setId(int id) {
        // TODO Auto-generated method stub
        super.setId(id);
    }

    @Override
    public void setPrice(Double price) {
        // TODO Auto-generated method stub
        super.setPrice(price);
    }

    @Override
    public void setTitle(String title) {
        // TODO Auto-generated method stub
        super.setTitle(title);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }


    
}
