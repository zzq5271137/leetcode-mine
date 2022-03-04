package mydatastructure.setandmap;

import java.util.ArrayList;

public class TestMap {
    private static double testMap(Map<String, Integer> map, String filename) {
        long start = System.nanoTime();

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {
            System.out.printf("%s---Total words: %d%n", Thread.currentThread().getName(), words.size());
            for (String word : words) {
                if (map.contains(word))
                    map.add(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }
            System.out.printf("%s---Total different words: %d%n%n", Thread.currentThread().getName(), map.getSize());
            System.out.printf("%s---Frequency of word \"PRIDE\": %d%n", Thread.currentThread().getName(), map.get("pride"));
            System.out.printf("%s---Frequency of word \"PREJUDICE\": %d%n", Thread.currentThread().getName(), map.get("prejudice"));
        }

        long end = System.nanoTime();
        return (end - start) / 1000000000.0;
    }

    public static void main(String[] args) throws InterruptedException {
        String filename = "/Users/zzq/Documents/workspaces/IDEA_workspace/java-practise/src/main/java/datastructure/setandmap/pride-and-prejudice.txt";

        Thread bstMapThread = new Thread(() -> {
            Map<String, Integer> bstMap = new BSTMap<>();
            double t2 = testMap(bstMap, filename);
            System.out.printf("BST map: %f.3s%n", t2);
        }, "BSTMapThread");

        Thread linkedListMapThread = new Thread(() -> {
            Map<String, Integer> linkedListMap = new LinkedListMap<>();
            double t1 = testMap(linkedListMap, filename);
            System.out.printf("LinkedList map: %f.3s%n", t1);
        }, "LinkedListMapThread");

        bstMapThread.start();
        linkedListMapThread.start();
        bstMapThread.join();
        linkedListMapThread.join();
    }
}
