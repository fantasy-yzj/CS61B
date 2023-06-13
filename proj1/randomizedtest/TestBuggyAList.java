package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> AL = new AListNoResizing();
        BuggyAList<Integer> BL =new BuggyAList();
        AL.addLast(4);
        BL.addLast(4);

        AL.addLast(5);
        BL.addLast(5);

        AL.addLast(6);
        BL.addLast(6);

        assertEquals(AL.size(), BL.size());

        assertEquals(AL.removeLast(), BL.removeLast());
        assertEquals(AL.removeLast(), BL.removeLast());
        assertEquals(AL.removeLast(), BL.removeLast());
    }
    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                System.out.println("size: " + size);
                assertEquals(L.size(), B.size());
            } else if (operationNumber == 2) {
                if (L.size() > 0 && B.size() > 0) {
                    System.out.println("getLast: " + L.getLast());
                    assertEquals(L.getLast(), B.getLast());
                }
            } else if (operationNumber == 3) {
                if (L.size() > 0 && B.size() > 0) {
                    assertEquals(L.removeLast(), B.removeLast());
                    System.out.println("remove Success");
                }
            }
        }
    }
}
