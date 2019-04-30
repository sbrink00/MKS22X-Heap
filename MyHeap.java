
public class MyHeap{
  public static boolean hasLeft(int size, int idx){return 2*idx + 1 <= size;}
  public static boolean hasRight(int size, int idx){return 2*idx + 2 <= size;}
  public static int getLeft(int size, int idx){return 2*idx + 1;}
  public static int getRight(int size, int idx){return 2*idx + 2;}

  public static void swap(int[] ary, int idx1, int idx2){
    int temp = ary[idx2];
    ary[idx2] = ary[idx1];
    ary[idx1] = temp;
  }

  public static void pushDown(int[] data, int size, int idx){
    if (!hasLeft(size, idx)) return;
    else if (!hasRight(size, idx)){
      if ((data[getLeft(size, idx)] > data[idx])) swap(data, idx, getLeft(size, idx));
      return;
    }
    else{
      int leftIdx = getLeft(size, idx);
      int rightIdx = getRight(size, idx);
      int left = data[leftIdx];
      int right = data[rightIdx];
      int maxChild = Math.max(left, right);
      if (data[idx] >= maxChild) return;
      if (maxChild == left){
        swap(data, idx, leftIdx);
        pushDown(data, size, leftIdx);
      }
      else swap(data, idx, rightIdx);
      pushDown(data, size, rightIdx);
    }
  }

  public static void heapify(int[] data){
    int start = (data.length - 2)/2;
    for (int idx = start; idx >= 0; idx --) pushDown(data, data.length - 1, idx);
  }

  public static void heapSort(int data[]){
    heapify(data);
    int size = data.length - 1;
    while (size != 0){
      swap(data, 0, size);
      size --;
      pushDown(data, size, 0);
    }
  }
}
