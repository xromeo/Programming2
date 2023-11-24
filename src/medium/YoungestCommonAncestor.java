package medium;

public class YoungestCommonAncestor {
    public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
        int descendantOneDepth = getDepth(descendantOne, topAncestor);
        int descendantTwoDepth = getDepth(descendantTwo, topAncestor);
        if (descendantOneDepth > descendantTwoDepth) {
            return getYoungestCommonAncestor(descendantOne, descendantTwo, descendantOneDepth - descendantTwoDepth);
        } else {
            return getYoungestCommonAncestor(descendantTwo, descendantOne, descendantTwoDepth - descendantOneDepth);
        }
    }

    public static int getDepth(AncestralTree descendant, AncestralTree topAncestor) {
        AncestralTree node = descendant;
        int depth = 1;
        while (node != topAncestor) {
            node = node.ancestor;
            depth++;
        }
        return depth;
    }

    public static AncestralTree getYoungestCommonAncestor(AncestralTree lowerDescendant, AncestralTree higherDecendant,
            int diff) {
        if (diff > 0) {
            int counter = diff;
            while (counter > 0) {
                lowerDescendant = lowerDescendant.ancestor;
                counter--;
            }
        }

        while (lowerDescendant != higherDecendant) {
            lowerDescendant = lowerDescendant.ancestor;
            higherDecendant = higherDecendant.ancestor;
        }
        return lowerDescendant;
    }

    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }
}
