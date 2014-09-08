package date20140801;
import java.util.Arrays;

public class Lotto {

   public static int[] selectBalls() {
      int[] balls = new int[45];
      for (int i = 0; i < balls.length; i++) {
         balls[i] = i + 1;
      }
      int loopCnt = 6;
      int[] resultArr = new int[loopCnt];
      for (int i = 0; i < loopCnt; i++) {
         int idx = (int) (Math.random() * balls.length);
         resultArr[i] = balls[idx];
         trimWithIndex(balls, idx);
      }
      return resultArr;
   }

   public static int[] trimWithIndex(int[] originarr, int idx) {
      int[] temp = new int[originarr.length - 1];
      System.arraycopy(originarr, 0, temp, 0, idx);
      System.arraycopy(originarr, idx + 1, temp, idx, originarr.length
            - (idx + 1));
      System.out.println("Á¦°ÅµÊ");
      return temp;
   }

   public static void main(String[] args) {
      int[] a = selectBalls();
      System.out.println(Arrays.toString(a));
   }

}