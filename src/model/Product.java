package model;

public abstract class Product {
    private int id;
    private String title;
    private int categoryId;
    private Double price;

    public Product(int id, String title){
        this.id = id;
        this.title = title;
    }  

   

    public Product (int id, String title, int categoryId){
        this.id = id;
        this.title = title;
        this.categoryId = categoryId;
    }
    public Product (int id, String title, int categoryId, double price){
        this.id = id;
        this.title = title;
        this.categoryId = categoryId;
        this.price = price;
    }    

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getCategory() {
        return categoryId;
    }
    public void setCategory(int category) {
        this.categoryId = category;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", title=" + title + ", category=" + categoryId+ ", price=" + price + "]";
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + categoryId;
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (id != other.id)
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (categoryId != other.categoryId)
            return false;
        if (price == null) {
            if (other.price != null)
                return false;
        } else if (!price.equals(other.price))
            return false;
        return true;
    }
    
}
