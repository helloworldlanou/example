package exam.sorts;  
  
import java.util.Arrays;  
/** 
 * 归并排序 
 * 稳定 
 * 基于分治法，把大的问题拆成小的问题来处理。拆到最后变成了合并，两个数字合并，之后两个顺序数列合并 
 * 时间复杂度nlgn 
 * @author wz 
 * 
 */  
public class MergeSort {  
    /** 
     * 归并函数,归并排序最重要的就归并函数，简单来说就是把两个有序序列归并为一个序列。
     * 要注意，例如以数字项排序，归并排序在递归的最底层其实是一个只有1个数字的序列，然后进行归并，不断的归并直到包含所有数字。
     * 归并排序算法稳定，数组需要O(n)的额外空间，链表需要O(log(n))的额外空间，时间复杂度为O(nlog(n))
     * @param data 
     * @param start 
     * @param mid 
     * @param end 
     */  
    public static void merge(int[] data,int start,int mid,int end){  
        int[] temp = new int[end - start + 1];  
        int temp_i = 0;  
        int i = start;  
        int j = mid + 1;  
        //对两个序列进行归并，都从最左侧起，不断地将小的值放入临时序列中
        do{  
            if(data[i]<=data[j]){  
                temp[temp_i] = data[i];  
                i++;  
                temp_i++;  
            }else{  
                temp[temp_i] = data[j];  
                j++;  
                temp_i++;  
            }  
        }while(i<=mid && j<=end);  
        //最后将还有剩余的序列的值都放入临时序列
        while(i<=mid){  
            temp[temp_i] = data[i];  
            i++;  
            temp_i++;  
        }  
        while(j<=end){  
            temp[temp_i] = data[j];  
            j++;  
            temp_i++;  
        }  
          //将临时序列的值拷贝回来
        j = start;  
        for(i = 0;i<temp.length;i++){  
            data[j] = temp[i];  
            j++;  
        }  
    }  
    /** 
     * 递归进行归并排序，分治策略，并合并 
     * @param data 
     * @param start 
     * @param end 
     */  
    public static void sort(int[] data,int start,int end){  
        if(start == end) return;  
        int mid = (end+start)/2;  
        sort(data,0,mid);  
        sort(data,mid+1,end);  
        merge(data,start,mid,end);  
        System.out.println(data + Arrays.toString(data));  
    }  
 
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        int[] data = {4,2,3,9,6,8};  
        System.out.println(data + Arrays.toString(data));  
        sort(data,0,data.length-1);//排序成功，说明数组是引用传递  
        System.out.println(data + Arrays.toString(data));  
    }  
  
}  