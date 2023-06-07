import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Please complete the following exercise using Java Programming Language.
// Your solution should compile and execute successfully.

public class Exercise {
    public static class Category {

        // Define the following fields with getters and setters:
        // id: a unique numeric identifier of the category
        // parentId: id of the parent category or null if it doesn't have the parent
        // name: a string representation of category name

        private int id;
        private Integer parentId;
        private String name;

        public Category(int id, String name, Integer parentId) {
            this.id = id;
            this.parentId = parentId;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public Integer getParentId() {
            return parentId;
        }

        public String getName() {
            return name;
        }

    }

    public static class Node<T> {
        private T data;
        private List<Node<T>> children;

        public Node(T data) {
            this.data = data;
            this.children = new ArrayList<>();
        }

        public T getData() {
            return this.data;
        }

        public List<Node<T>> getChildren() {
            return this.children;
        }

        public void addChild(Node<T> node) {
            this.children.add(node);
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

        List<Node<Category>> trees = new ArrayList<>();

        Map<Integer, Node<Category>> nodes = new HashMap<>();
        for (Category category : categories) {
            Node<Category> node = new Node<Category>(category);
            nodes.put(category.getId(), node);

            if (category.getParentId() == null) {
                trees.add(node);
            }
        }

        for (Node<Category> node : nodes.values()) {
            Integer parentId = node.getData().getParentId();
            if (parentId != null) {
                Node<Category> parent = nodes.get(parentId);
                if (parent != null) {
                    parent.addChild(node);
                }
            }
        }

        trees.stream().forEach(tree -> {
            printCategoryPaths(tree, "");
        });

    }

    private static void printCategoryPaths(Node<Category> node, String path) {
        Category category = node.getData();
        String categoryName = category.getName();
        String newPath = (path.isEmpty()) ? categoryName : path + " > " + categoryName;
        System.out.println(newPath);

        for (Node<Category> child : node.getChildren()) {
            printCategoryPaths(child, newPath);
        }
    }

    public static void main(String... args) {
        // Define a collection of Category instances
        // Invoke "printPath" method above to print the path for all the categories in
        // the collection
        List<Category> categories = new ArrayList<>();

        Category H = new Category(8, "H", 4);
        categories.add(H);

        Category G = new Category(7, "G", 5);
        categories.add(G);

        Category A = new Category(1, "A", null);
        categories.add(A);

        Category B = new Category(2, "B", null);
        categories.add(B);

        Category C = new Category(3, "C", 1);
        categories.add(C);

        Category D = new Category(4, "D", 2);
        categories.add(D);

        Category E = new Category(5, "E", 3);
        categories.add(E);

        Category F = new Category(6, "F", 4);
        categories.add(F);

        Category I = new Category(9, "I", 6);
        categories.add(I);

        Category J = new Category(10, "J", 7);
        categories.add(J);

        Category Z = new Category(25, "Z", null);
        categories.add(Z);

        printPath(categories);
    }
}
