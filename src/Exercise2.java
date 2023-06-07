import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Please complete the following exercise using Java Programming Language.
// Your solution should compile and execute successfully.

public class Exercise2 {
    public static class Category {

        // Define the following fields with getters and setters:
        // id: a unique numeric identifier of the category
        // parentId: id of the parent category or null if it doesn't have the parent
        // name: a string representation of category name

        private int id;
        private Integer parentId;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Integer getParentId() {
            return parentId;
        }

        public void setParentId(Integer parentId) {
            this.parentId = parentId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void printPath(List<Category> categories) {
        // Input is an _unordered_ collection of categories, where "id", "parentId", and
        // "name" are pre-populated.
        // Implement this method to print the full path for each category in the
        // collection.
        //
        // For example, if category A is parent of category B and category B is parent
        // of category C, then
        // the path for category A is "A"
        // the path for category B is "A > B"
        // the path for category C is "A > B > C"
        // where "A" is the name of category A
        // "B" is the name of category B
        // "C" is the name of category C
        //
        // Notes: Number of categories in a specific path can be greater than 3 as
        // provided in this example.
        // Your solution should work with any number of parents (e.g. A > B > C > D >
        // ... > X)
        // There may be multiple categories that do not have a parent (i.e. multiple
        // root categories)
        // A category may have zero, one or more children
        // A parent category may have a category id which is higher or lower than its
        // children's
        // The category ids in the categories parameter are not sorted
        // Category names are strings and may be longer than one character

        Map<Integer, Category> categoryMap = new HashMap<>();

        for (Category category : categories) {
            categoryMap.put(category.getId(), category);
        }

        Map<Integer, String> cache = new HashMap<>();

        for (Category category : categories) {
            StringBuilder pathBuilder = new StringBuilder();
            pathBuilder.append(category.getName());
            Integer parentId = category.getParentId();

            if (parentId != null) {
                if (cache.containsKey(parentId)) {
                    StringBuilder sbCache = new StringBuilder(cache.get(parentId) + " > ");
                    pathBuilder.insert(0, sbCache);
                } else{
                    while (parentId != null) {
                        Category parentCategory = categoryMap.get(parentId);
                        if (parentCategory != null) {
                            pathBuilder.insert(0, " > ");
                            pathBuilder.insert(0, parentCategory.getName());
                            parentId = parentCategory.getParentId();
                        } else {
                            break;
                        }
                    }
                }
            }            

            cache.put(category.id, pathBuilder.toString());
            System.out.println(pathBuilder.toString());
        }
    }

    public static void main(String... args) {
        // Define a collection of Category instances
        // Invoke "printPath" method above to print the path for all the categories in
        // the collection
        List<Category> categories = new ArrayList<>();

        Category categoryS = new Category();
        categoryS.setId(42);
        categoryS.setParentId(31);
        categoryS.setName("S");
        categories.add(categoryS);

        Category category1 = new Category();
        category1.setId(1);
        category1.setParentId(null);
        category1.setName("A");
        categories.add(category1);

        Category category2 = new Category();
        category2.setId(2);
        category2.setParentId(1);
        category2.setName("B");
        categories.add(category2);

        Category category3 = new Category();
        category3.setId(3);
        category3.setParentId(2);
        category3.setName("C");
        categories.add(category3);

        Category categoryK = new Category();
        categoryK.setId(30);
        categoryK.setParentId(3);
        categoryK.setName("K");
        categories.add(categoryK);

        Category categoryM = new Category();
        categoryM.setId(31);
        categoryM.setParentId(3);
        categoryM.setName("M");
        categories.add(categoryM);

        Category categoryR = new Category();
        categoryR.setId(41);
        categoryR.setParentId(31);
        categoryR.setName("R");
        categories.add(categoryR);

        Category category6 = new Category();
        category6.setId(40);
        category6.setName("Z");
        categories.add(category6);

        printPath(categories);
    }
}
