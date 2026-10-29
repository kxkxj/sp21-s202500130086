package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */

//这里是在讲述测试找到bug的方法，第一种比较测试法，用一个已知正确的来测试未知的
public class TestBuggyAList {
    @Test
    public void testThreeAddThreeRemove(){
        AListNoResizing<Integer> l = new AListNoResizing<>();
        l.addLast(4);
        l.addLast(5);
        l.addLast(6);
        BuggyAList<Integer> l2 = new BuggyAList<>();
        l2.addLast(4);
        l2.addLast(5);
        l2.addLast(6);
        assertEquals(l.removeLast(),l2.removeLast());
        assertEquals(l.removeLast(),l2.removeLast());
        assertEquals(l.removeLast(),l2.removeLast());
    }

    @Test
    public void testsample1(){
        int N = 100;
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> L2= new BuggyAList<>();
        for(int i = 0; i < N;i++){
            L.addLast(i);
            L2.addLast(i);
        }
        for(int i = 0; i < N;i++){
            assertEquals(L.removeLast(),L2.removeLast());
        }
    }

    @Test
    public  void testsample2(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        int N = 500;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 2);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                //System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                //System.out.println("size: " + size);
            }
        }
    }

    @Test
    public  void testsample3(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        int N = 500;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                //System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 2) {
               if(L.size() == 0){
                   continue;
               }
               int value = L.getLast();
               //System.out.println("getSize: " + value);
            } else if (operationNumber == 3 ) {
                if(L.size() == 0){
                    continue;
                }
                int value = L.removeLast();
                //System.out.println("removeLast: " + value);
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                //System.out.println("size: " + size);
            }
        }
    }

    @Test
    public  void testsample4(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> L2 = new BuggyAList<>();
        int N = 500;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                L2.addLast(randVal);
                //System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 2) {
                if(L.size() == 0){
                    continue;
                }
                int value = L.getLast();
                int bvalue = L2.getLast();
                assertEquals(value,bvalue);
                //System.out.println("getSize: " + value);
            } else if (operationNumber == 3 ) {
                if(L.size() == 0){
                    continue;
                }
                int value = L.removeLast();
                int bvalue = L2.removeLast();
                assertEquals(value,bvalue);
                //System.out.println("removeLast: " + value);
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int bsize = L2.size();
                assertEquals(size,bsize);
                //System.out.println("size: " + size);
            }
        }
    }
}
