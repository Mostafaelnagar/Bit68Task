package app.bt68.fmapp.home.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Categories {
    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private int id;

    @SerializedName("category_img")
    private String categoryImg;

    @SerializedName("products")
    private List<ProductsItem> products;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setCategoryImg(String categoryImg) {
        this.categoryImg = categoryImg;
    }

    public String getCategoryImg() {
        return categoryImg;
    }

    public void setProducts(List<ProductsItem> products) {
        this.products = products;
    }

    public List<ProductsItem> getProducts() {
        return products;
    }
}
