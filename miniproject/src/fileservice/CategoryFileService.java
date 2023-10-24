package fileservice;

import data.Data;
import model.Catagory;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class CategoryFileService {
    private static List<Catagory> catagories;
    private Data<Catagory> catagoryData = new Data();

    public CategoryFileService() {
        List<Catagory> catagoryList = catagoryData.readFromFile(Data.CATEGORY_DATA);
        if (catagoryList == null) {
            catagoryList = new ArrayList<>();
        }
        this.catagories = catagoryList;
    }
    // lấy ra một danh sách
    public List<Catagory> getAllCategory() {
        return catagories;
    }


    // hàm nạp dữ liệu vào file
    public void saveToFileCategory(Catagory category) {
        if (findByIdCategory(category.getCatelogId()) == null) {
            catagories.add(category);
        } else {
            catagories.set(catagories.indexOf(findByIdCategory(category.getCatelogId())), category);
        }
        catagoryData.writeToFile(catagories, Data.CATEGORY_DATA);

    }

    public Catagory findByIdCategory(int id) {
        for (Catagory cata : catagories) {
            if (cata.getCatelogId() == id) {
                return cata;
            }
        }
        return null;
    }

}
