package model;

import java.io.Serializable;


public class Catagory implements Serializable {
    private static final long serialVersionUID = 2l;
    private int CatelogId;
    private String CatelogName;
    public Catagory() {
    }

    public Catagory(int catelogId, String catelogName) {
        CatelogId = catelogId;
        CatelogName = catelogName;
    }

    public int getCatelogId() {
        return CatelogId;
    }

    public void setCatelogId(int catelogId) {
        CatelogId = catelogId;
    }

    public String getCatelogName() {
        return CatelogName;
    }

    public void setCatelogName(String catelogName) {
        CatelogName = catelogName;
    }

    public String toString() {
        final StringBuilder catalog = new StringBuilder("Catagory{");
        catalog.append("Mã danh mục=").append(CatelogId);
        catalog.append(", Tên Danh mục='").append(CatelogName).append('\'');
        catalog.append('}');
        return catalog.toString();
    }
}
