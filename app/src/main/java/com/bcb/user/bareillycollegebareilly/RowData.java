package com.bcb.user.bareillycollegebareilly;

public class RowData {
    private String main_title,sub_title;
    private int image_title;
    public Object add;

    public RowData(String main_title, String sub_title, int image_title) {
        this.main_title=main_title;
        this.sub_title=sub_title;
        this.image_title=image_title;
    }

    public String getMain_title() {
        return main_title;
    }

    public void setMain_title(String main_title) {
        this.main_title = main_title;
    }

    public String getSub_title() {
        return sub_title;
    }

    public void setSub_title(String sub_title) {
        this.sub_title = sub_title;
    }

    public int getImage_title() {
        return image_title;
    }

    public void setImage_title(int image_title) {
        this.image_title = image_title;
    }


}
