package date20140801;

public class professorFloor {

 public static void main(String[] args) {
  
  int end = 100;
  int totalCount = 0;
  int floorCount = 1;
  
  outer:
  for(; ; floorCount++){
   for(int i = 0; i < floorCount; i++){
    totalCount++;
    if(totalCount >= end)
     break outer;
   }   
  }
  System.out.println(floorCount);
  
//  outer:
//  while (true){
//   
//   start = floorCount;
//   
//   for(; start > 0; start--){
//    totalCount++;
//    System.out.println(floorCount +":" +start);
//    if (totalCount == end){
//     break outer;
//    }
//   }   
//   floorCount++;
//  }
//  System.out.println(floorCount);
  
  
  
 }
}
