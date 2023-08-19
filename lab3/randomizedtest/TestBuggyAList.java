package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  //TODO: YOUR TESTS HERE
  @Test
  public void testThreeAddThreeRemove(){
      AListNoResizing<Integer> NoResizing = new AListNoResizing<>();
      BuggyAList<Integer> Buggy = new BuggyAList<>();
      NoResizing.addLast(4); Buggy.addLast(4);
      NoResizing.addLast(5); Buggy.addLast(5);
      NoResizing.addLast(5); Buggy.addLast(5);
      assertEquals(NoResizing.removeLast(),Buggy.removeLast());
      assertEquals(NoResizing.removeLast(),Buggy.removeLast());
      assertEquals(NoResizing.removeLast(),Buggy.removeLast());
  }
  @Test
  public void randomizedTest(){
      AListNoResizing<Integer> L = new AListNoResizing<>();
      BuggyAList<Integer>  Buggy = new BuggyAList<>();
      int N = 900;
      for (int i = 0; i < N; i += 1) {
          int operationNumber = StdRandom.uniform(0, 4);
          if (operationNumber == 0) {
              // addLast
              int randVal = StdRandom.uniform(0, 100);
              L.addLast(randVal);
              Buggy.addLast(randVal);
              System.out.println("addLast(" + randVal + ")");
          }
          else if (operationNumber == 1){
              // TODO:getLast
              if(L.size()>0){
                  System.out.println("getLast()");
                  assertEquals(L.getLast(),Buggy.getLast());
              }
          }
          else if (operationNumber == 2){
              // TODO:removeLast
              if(L.size()>0){
                  int numL = L.removeLast();
                  int numBuggy = Buggy.removeLast();
                  System.out.println("removeLast()");
                  assertEquals(numL,numBuggy);
              }
          }
          else if (operationNumber == 3) {
              // size
              int sizeL = L.size();
              int sizeBuggy = Buggy.size();
              System.out.println("size: " + sizeL);
              assertEquals(sizeL,sizeBuggy);
          }
      }
  }
}
