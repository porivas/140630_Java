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

      System.out.print("����Ұſ���??");
      int member = Integer.parseInt(sc.nextLine());

      System.out.print("��Ģ�� ������ �Է��ϼ���: ");
      int penal = Integer.parseInt(sc.nextLine());

      String[][] arr = new String[member][2];

      for (int i = 0; i < arr.length; i++) {
         System.out.print("����̸��� �Է��ϼ�����");
         String memberName = sc.nextLine();
         arr[i][0] = memberName;
      }

      for (int i = 0; i < penal; i++) {
         System.out.println("����Ģ�� �Է��ϼ�����");
         String penalName = sc.nextLine();
         arr[i][1] = penalName;
      }

      for (int i = 0; i < member; i++) {
         int idx3 = (int) (Math.random() * penal);

      }
      
      // member �ο���  arr[i][0] �̸��� penal ��Ģ��  arr[i][1] ��Ģ��
      
      String[] arr2 = new String [member];
      for (int i = 0; i < arr2.length; i++) {
         arr2[i] = arr[i][0];
      }
      arr2 = selectNames(arr2, penal);
      System.out.print("��Ȳ���� ���� Enter");
      String nextGo = sc.nextLine();
      String[] arr3 = new String [member];
      for (int i = 0; i < arr2.length; i++) {
         arr3[i] = arr[i][1];
      }
//      for (int i = 0; i < member-penal; i++) {
//          arr[i][1] = "����";
//       }
      for (int i = 0; i <penal; i++) {
         System.out.println("��÷�ڸ�: " + arr2[i] + "   ��Ģ��: "+ arr3[i]);
      }

//      System.out.println(Arrays.toString(arr3));
      
      
            

//      for (int j = 0; j <member; j++) {
//         System.out.print("2��Ȳ���� ���� Enter");
//         String nextGo = sc.nextLine();
//         int idx2 = (int) (Math.random() * member);
//         // �ߺ�����
//
//         System.out.printf(arr[idx2][0]+"�� " + arr[j][1]+"�� �ɷȽ��ϴ�");
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
