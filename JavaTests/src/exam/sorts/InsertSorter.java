package exam.sorts;

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
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
