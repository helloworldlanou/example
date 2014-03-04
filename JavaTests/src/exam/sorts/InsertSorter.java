package exam.sorts;

import java.util.Arrays;

/**
 * 插入排序
 * @author wz
 *
 * @param <E>
 */
public class InsertSorter<E extends Comparable<E>> extends Sorter<E> {
	 public void sort(E[] array, int from, int len) {
         E tmp=null;
          for(int i=from+1;i<from+len;i++)
          {
              tmp=array[i];
              int j=i;
              for(;j>from;j--)
              {
                  if(tmp.compareTo(array[j-1])<0)
                  {
                      array[j]=array[j-1];
                  }
                  else break;
              }
              array[j]=tmp;
          }
    }
	 /**
	  * 插入排序 每次找一个新的数值，往已有顺序的序列中通过比较找到合适位置插入
	  * 稳定 
	  * 时间1+2+ ... +n = n(n+1)/2
	  * 时间复杂度n^2
	  * @param data
	  */
	 public static void sort2(int[] data){
		 for (int i = 0; i< data.length-1; i++){
			 int j = i +1;
			 for(;j>0;j--){
				 if(data[j]<data[j-1]){
					 int tmp = data[j];
					 data[j] = data[j-1];
					 data[j-1] = tmp;
				 }
			 }
		 }
	 }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] data = {4,2,3,9,6,8};
		System.out.println(data + Arrays.toString(data));
		sort2(data);//排序成功，说明数组是引用传递
		System.out.println(data + Arrays.toString(data));
	}

}
