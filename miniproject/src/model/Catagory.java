package model;

import java.io.Serializable;

import static constant.Constant.CateStatus.APPEAR;



public class Catagory implements Serializable {
    private static final long serialVersionUID = 2l;
    private int CatelogId;
    private String CatelogName;
    private boolean CateStatus;
    public Catagory() {
    }

    public Catagory(int catelogId, String catelogName, boolean cateStatus) {
        CatelogId = catelogId;
        CatelogName = catelogName;
        CateStatus = cateStatus;
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

    public boolean isCateStatus() {
        return CateStatus;
    }

    public void setCateStatus(boolean cateStatus) {
        CateStatus = cateStatus;
    }

    public String toString() {
        final StringBuilder catalog = new StringBuilder("Catagory{");
        catalog.append("Mã danh mục: ").append(CatelogId);
        catalog.append(", Tên danh mục: '").append(CatelogName).append('\'');
        catalog.append(", Trạng thái danh mục: ").append(CateStatus == APPEAR ? "'APPEAR'" : "'HIDDEN'");
        catalog.append('}');
        return catalog.toString();
    }
}
