package mydatastructure.setandmap;

import java.util.ArrayList;

public class TestSet {
    private static double testSet(String filename, Set<String> set) {
        long startTime = System.nanoTime();

        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());
            for (String word : words)
                set.add(word);
            System.out.println("Total different words: " + set.getSize());
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        String filename = "/Users/zzq/Documents/workspaces/IDEA_workspace/java-practise/src/main/java/datastructure/setandmap/pride-and-prejudice.txt";

        Set<String> bstSet = new BSTSet<>();
        double t1 = testSet(filename, bstSet);
        System.out.println("BST set: " + t1);

        Set<String> linkedListSet = new LinkedListSet<>();
        double t2 = testSet(filename, linkedListSet);
        System.out.println("Linkedlist set: " + t2);
    }
}
