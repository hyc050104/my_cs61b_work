package randomizedtest;

import static org.junit.Assert.*;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

/**
 * Created by hug.
 */

public class TestBuggyAList {
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> lst1 = new AListNoResizing<Integer>();
        BuggyAList<Integer> lst2 = new BuggyAList<Integer>();
        lst1.addLast(1);
        lst1.addLast(2);
        lst1.addLast(3);
        lst2.addLast(1);
        lst2.addLast(2);
        lst2.addLast(3);
        assertEquals(lst1.size(), lst2.size());
        assertEquals(lst1.removeLast(), lst2.removeLast());
        assertEquals(lst1.removeLast(), lst2.removeLast());
        assertEquals(lst1.removeLast(), lst2.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L1 = new AListNoResizing<>();
        BuggyAList<Integer> L2 = new BuggyAList<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                int randVal = StdRandom.uniform(0, 100);
                L1.addLast(randVal);
                L2.addLast(randVal);
                assertEquals(L1.size(), L2.size());
            } else if (operationNumber == 1) {
                assertEquals(L1.size(), L2.size());
                if (L1.size() > 0 && L2.size() > 0) {
                    assertEquals(L1.removeLast(), L2.removeLast());
                }
            } else {
                assertEquals(L1.size(), L2.size());
                if (L1.size() > 0 && L2.size() > 0) {
                    assertEquals(L1.getLast(), L2.getLast());
                }
            }
        }
    }
}
