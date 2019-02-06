public class Main {

    public static void main(String[] args) {
	// write your code here
        test1();
        test2();
        test3();
        test4();
    }

    public static void test1() {
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        System.out.println("Test1");
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println("Expected 1 Actual " + cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println("Expected -1 Actual " + cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println("Expected -1 Actual " + cache.get(1));       // returns -1 (not found)
        System.out.println("Expected 3 Actual " + cache.get(3));       // returns 3
        System.out.println("Expected 4 Actual " + cache.get(4));       // returns 4
        System.out.println();
    }

    public static void test2() {
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        System.out.println("Test2");
        cache.put(2, 1);
        cache.put(1, 1);
        System.out.println("Expected 1 Actual " + cache.get(2));       // returns 1
        cache.put(4, 1);    // evicts key 1
        System.out.println("Expected -1 Actual " + cache.get(1));       // returns -1 (not found)
        System.out.println("Expected 1 Actual " + cache.get(2));       // returns 1 (not found)
        System.out.println();
    }

    public static void test3() {
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        System.out.println("Test3");
        System.out.println("Expected -1 Actual " + cache.get(2));
        cache.put(2, 6);
        System.out.println("Expected -1 Actual " + cache.get(1));
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println("Expected 2 Actual " + cache.get(1));       // returns 1
        System.out.println("Expected 6 Actual " + cache.get(2));
        System.out.println();
    }

    public static void test4() {
        LRUCache cache = new LRUCache( 10 /* capacity */ );

        System.out.println("Test4");
        cache.put(10, 13);
        cache.put(3, 17);
        cache.put(6, 11);
        cache.put(10, 5);
        cache.put(9, 10);
        cache.put(2,19);
        cache.put(5, 25);

        cache.put(9, 22);
        cache.put(5, 5);
        cache.put(1, 30);
        cache.put(9, 12);
        cache.put(4, 30);
        cache.put(9, 3);
        cache.put(6, 14);
        cache.put(3,1);
        cache.put(10, 11);

        cache.put(2, 14);
        cache.put(11, 4);
        cache.put(12, 24);
        cache.put(5, 18);
        cache.put(7, 23);
        cache.put(7, 23);
        cache.put(3, 27);
        cache.put(2, 12);

        cache.put(2,9);
        cache.put(13, 4);
        cache.put(8, 18);
        cache.put(1, 7);
        cache.put(9, 29);
        cache.put(8, 21);
        cache.put(6, 30);
        cache.put(1, 12);
        cache.put(4, 15);
        cache.put(7, 22);
        cache.put(11, 26);

        cache.put(8, 17);
        cache.put(9, 29);
        cache.put(3, 4);
        cache.put(11, 30);
        cache.put(4, 29);
        cache.put(3, 4);
        cache.put(3, 29);
        cache.put(10, 28);

        cache.put(1,20);
        cache.put(11, 13);
        cache.put(3, 12);
        cache.put(3, 8);
        cache.put(10, 9);
        cache.put(3, 26);
        cache.put(13, 17);
        cache.put(2, 27);
        cache.put(11, 15);
        System.out.println("Expected -1 Actual " + cache.get(12));

    }
}
