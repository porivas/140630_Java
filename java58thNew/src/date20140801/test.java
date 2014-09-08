package date20140801;

import java.util.Arrays;
import java.util.Scanner;

public class test {

   public static String[] trimWithIndex(String[] originarr, int idx) {
      String[] temp = new String[originarr.length - 1];
      System.arraycopy(originarr, 0, temp, 0, idx);
      System.arraycopy(originarr, idx + 1, temp, idx, originarr.length- (idx + 1));
      return temp;
   }
   
   public static String[] selectNames(String[] nameList, int penal) {
      int loopCnt = penal;
      String[] resultArr = new String[loopCnt];
      for (int i = 0; i < loopCnt; i++) {
         int idx = (int) (Math.random() * nameList.length);
         resultArr[i] = nameList[idx];
         nameList = trimWithIndex(nameList, idx);
      }
      return resultArr;
   }
   
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      System.out.print("몇명할거에요??");
      int member = Integer.parseInt(sc.nextLine());

      System.out.print("벌칙의 갯수를 입력하세요: ");
      int penal = Integer.parseInt(sc.nextLine());

      String[][] arr = new String[member][2];

      for (int i = 0; i < arr.length; i++) {
         System.out.print("↓↓이름을 입력하세요↓↓");
         String memberName = sc.nextLine();
         arr[i][0] = memberName;
      }

      for (int i = 0; i < penal; i++) {
         System.out.println("↓↓벌칙을 입력하세요↓↓");
         String penalName = sc.nextLine();
         arr[i][1] = penalName;
      }

      for (int i = 0; i < member; i++) {
         int idx3 = (int) (Math.random() * penal);

      }
      
      // member 인원수  arr[i][0] 이름값 penal 벌칙수  arr[i][1] 벌칙명
      
      String[] arr2 = new String [member];
      for (int i = 0; i < arr2.length; i++) {
         arr2[i] = arr[i][0];
      }
      arr2 = selectNames(arr2, penal);
      System.out.print("당황하지 말고 Enter");
      String nextGo = sc.nextLine();
      String[] arr3 = new String [member];
      for (int i = 0; i < arr2.length; i++) {
         arr3[i] = arr[i][1];
      }
//      for (int i = 0; i < member-penal; i++) {
//          arr[i][1] = "면죄";
//       }
      for (int i = 0; i <penal; i++) {
         System.out.println("당첨자명: " + arr2[i] + "   벌칙명: "+ arr3[i]);
      }

//      System.out.println(Arrays.toString(arr3));
      
      
            

//      for (int j = 0; j <member; j++) {
//         System.out.print("2당황하지 말고 Enter");
//         String nextGo = sc.nextLine();
//         int idx2 = (int) (Math.random() * member);
//         // 중복제거
//
//         System.out.printf(arr[idx2][0]+"는 " + arr[j][1]+"에 걸렸습니다");
//         arr[idx2]=trimWithIndex(arr[idx2],0);
//         System.out.println(""); 
//   
//      }

   }

//   public static void main(String[] args) {
//      int[] a = selectBalls();
//      Arrays.sort(a);
//      System.out.println(Arrays.toString(a));
//      
//   }
   
}
