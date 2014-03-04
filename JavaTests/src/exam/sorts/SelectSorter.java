package exam.sorts;

import java.util.Arrays;

public class SelectSorter<E extends Comparable<E>> extends Sorter<E> {

    /* (non-Javadoc)
     * @see algorithms.Sorter#sort(E[], int, int)
     */
    @Override
    public void sort(E[] array, int from, int len) {
        for(int i=0;i<len;i++)
        {
            int smallest=i;
            int j=i+from;
            for(;j<from+len;j++)
            {
                if(array[j].compareTo(array[smallest])<0)
                {
                    smallest=j;
                }
            }
            swap(array,i,smallest);
                   
        }

    }
    /**
     *  选择排序
     *  不稳定 举例：序列5 8 5 2 9， 我们知道第一遍选择第1个元素5会和2交换，那么原序列中2个5的相对前后顺序就被破坏了，所以选择排序不是一个稳定的排序算法
     *  时间复杂度n^2
     * @param data
     */
    public static void sort2(int[] data){
    	 for(int i=0;i<data.length;i++){
    		 int j = i + 1;
    		 int tmp = i;
    		 for(;j<data.length;j++){
    			 if(data[j]<data[tmp]){
    				 tmp = j;
    			 }
    		 }
    		 int tmp2 = data[tmp];
    		 data[tmp] = data[i];
    		 data[i] = tmp2;
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
