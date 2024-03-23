package dpatrefinedsolution;

import java.util.ArrayList;
import java.util.List;

public class CategoryManager {
    private List<String> categories = new ArrayList<>();

    public void addCategory(String category) {
        categories.add(category);
    }

    public List<String> getCategories() {
        return categories;
    }    
}
