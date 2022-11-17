package model;

public class Game extends Product {

    public Game(String title, String category) {
        super(title, category);
        //TODO Auto-generated constructor stub
    }
    public Game(String title, String category, double price){
        super(title,category,price);
        //NOT GENERATED AUTOMATICALLY
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
