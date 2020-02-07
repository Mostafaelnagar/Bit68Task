package app.bt68.fmapp.home.models;

import com.google.gson.annotations.SerializedName;

public class ProductsItem {

    @SerializedName("price")
    private String price;

    @SerializedName("name")
    private String name;

    @SerializedName("weight")
    private String weight;

    @SerializedName("id")
    private int id;

    @SerializedName("product_img")
    private String productImg;
    private boolean clicked;

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getWeight() {
        return weight;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public String getProductImg() {
        return productImg;
    }
}