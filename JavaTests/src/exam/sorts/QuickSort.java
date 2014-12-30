package exam.sorts;

public class QuickSort {

public static int Partition(int a[],int p,int r){
		int x=a[r];
		int i=p-1;
		int temp;
	    for(int j=p;j<=r-1;j++){
	    	if(a[j]<=x){
	    		// swap(a[j],a[i]);
	    		i++;
	    		System.out.println(j+" "+i);
	    		temp=a[j];
	    		a[j]=a[i];
	    		a[i]=temp;
		    	show(a);
	    	}
	    }
	    //swap(a[r,a[i+1]);
	    temp=a[r];
	    a[r]=a[i+1];
	    a[i+1]=temp;
	    show(a);
	    return i+1;
	}
public static int Partition2(int a[],int p,int r){
	int x=a[p];
	int i=p+1;
	int j=r;
	int temp;
	do{
		while(a[i]<x){
			i++;
		}
		while(a[j]>x){
			j--;
		}
		if(i<j){
			 temp=a[i];
		    a[i]=a[j];
		    a[j]=temp;
		}else{
			break;
		}
		show(a);
	}while(true);
    temp=a[p];
    a[p]=a[j];
    a[j]=temp;
    show(a);
	return j;
}
	public static void QuickSort(int a[],int p,int r){
		
		if(p<r){
			int q=Partition2(a,p,r);
			QuickSort(a,p,q-1);
			QuickSort(a,q+1,r);
			
		}
		
	}
	public static void show(int a[]){
		for (int i=0;i<10;i++)
			 System.out.print(a[i]+ " ");
		System.out.println();
	}
public static void main(String[] stra){
		
		int a[]={23,53,77,36,84,76,93,13,45,23};
		show(a);
		QuickSort(a,0,9);
		show(a);
		

}

}