package app.bt68.fmapp.home.models;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class MainResponse {
    private List<Categories> objectList;

    public List<Categories> getObjectList() {
        return objectList;
    }

    public void setObjectList(List<Categories> objectList) {
        this.objectList = objectList;
    }
}