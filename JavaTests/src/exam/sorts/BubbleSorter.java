package exam.sorts;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BubbleSorter<E extends Comparable<E>> extends Sorter<E> {

    private static  boolean DWON=true;
    
    public final void bubble_down(E[] array, int from, int len)
    {
        for(int i=from;i<from+len;i++)
        {
            for(int j=from+len-1;j>i;j--)
            {
                if(array[j].compareTo(array[j-1])<0)
                {
                    swap(array,j-1,j);
                }
            }
        }
    }
    
    public final void bubble_up(E[] array, int from, int len)
    {
        for(int i=from+len-1;i>=from;i--)
        {
            for(int j=from;j<i;j++)
            {
                if(array[j].compareTo(array[j+1])>0)
                {
                    swap(array,j,j+1);
                }
            }
        }
    }
    @Override
    public void sort(E[] array, int from, int len) {
        
        if(DWON)
        {
            bubble_down(array,from,len);
        }
        else
        {
            bubble_up(array,from,len);
        }
    }
    /**
     * 冒泡排序 
     * 稳定
     * 时间 1+2+...+n = n(n+1)/2
     * 时间复杂度 n^2
     * @param data
     */
    public static void sort2(int[] data){
    	for (int i=0;i<data.length;i++){
    		for(int j=data.length-1;j>i;j--){
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
