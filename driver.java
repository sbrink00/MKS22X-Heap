import java.util.Arrays;
public class driver{
  public static void main(String[]args){
    int[] ary = {4, 3, 6, 1, 2, 8, 7, 6};
    MyHeap.heapSort(ary);
    System.out.println(Arrays.toString(ary));
  }
}
