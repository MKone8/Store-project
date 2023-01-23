package Rest;

import java.util.ArrayList;

public class List {
    public int list_id;
    public String list_name;
    public String list_name_encoded;
    public String display_name;
    public String updated;
    public Object list_image;
    public Object list_image_width;
    public Object list_image_height;
    public ArrayList<Book> books;
    public int getList_id() {
        return list_id;
    }
    public void setList_id(int list_id) {
        this.list_id = list_id;
    }
    public String getList_name() {
        return list_name;
    }
    public void setList_name(String list_name) {
        this.list_name = list_name;
    }
    public String getList_name_encoded() {
        return list_name_encoded;
    }
    public void setList_name_encoded(String list_name_encoded) {
        this.list_name_encoded = list_name_encoded;
    }
    public String getDisplay_name() {
        return display_name;
    }
    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }
    public String getUpdated() {
        return updated;
    }
    public void setUpdated(String updated) {
        this.updated = updated;
    }
    public Object getList_image() {
        return list_image;
    }
    public void setList_image(Object list_image) {
        this.list_image = list_image;
    }
    public Object getList_image_width() {
        return list_image_width;
    }
    public void setList_image_width(Object list_image_width) {
        this.list_image_width = list_image_width;
    }
    public Object getList_image_height() {
        return list_image_height;
    }
    public void setList_image_height(Object list_image_height) {
        this.list_image_height = list_image_height;
    }
    public ArrayList<Book> getBooks() {
        return books;
    }
    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
    
}
