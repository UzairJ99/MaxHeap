package maxHeapLab;

public class MaxHeap 
{
	private Integer[] maxHeap;
	private int arrSize, heapSize = 0;
	
	public MaxHeap(int size)
	{
		//create empty heap with allocated size
		arrSize = size;
		heapSize = 0;
		maxHeap = new Integer[arrSize];
	}
	
	public MaxHeap(Integer[] arr)
	{
		maxHeap = arr;
		arrSize = arr.length;
		heapSize = 0;
		
		//creates a heap from the array, ensuring that the max stays at the root
		for(int i = 0; i < arr.length; i++)
		{
			insert(arr[i]);
		}
	}
	
	public void insert(int n)
	{
		ensureSpace(); //check if there's space and create space if needed
		maxHeap[heapSize] = n; //sets the item to the bottom of the heap
		int currIndex = heapSize; //current index is the bottom of the heap
		
		//loop while the current item is larger than the parent
		while(maxHeap[currIndex] > maxHeap[parentChildIndex(currIndex)])
		{
			//swap the item with the parent
			swap(currIndex, parentChildIndex(currIndex));
			//set the current index to that of the parent
			currIndex = parentChildIndex(currIndex);
		}
		//increase heap size
		heapSize++;
	}
	
	public int deleteMax() 
	{
		if(heapSize == 0)
			throw new IllegalArgumentException();
		
		int max = maxHeap[0];
		heapSize--;
		maxHeap[0] = maxHeap[heapSize];
		maxHeap[heapSize] = null;
		int index = 0;
		int largestChildIndex = 0;
		
		while(leftChildIndex(index) < heapSize)
		{
			if(maxHeap[leftChildIndex(index)] == null)
			{
				largestChildIndex = rightChildIndex(index);
			}
			else if (maxHeap[rightChildIndex(index)] == null)
			{
				largestChildIndex = leftChildIndex(index); 
			}
			else
			{
				if (maxHeap[leftChildIndex(index)] > maxHeap[rightChildIndex(index)])
				{
					largestChildIndex = leftChildIndex(index);
				}
				else
				{
					largestChildIndex = rightChildIndex(index);
				}
			}
			
			if (maxHeap[index] < maxHeap[largestChildIndex])
            {
            	swap(largestChildIndex,index); 
            	index = largestChildIndex; 
                continue;
            }
            break;
		}
		return max;
	}
	
	public String toString()
	{
		String result = "";
		
		for(int i = 0; i < heapSize; i++)
		{
			result += maxHeap[i] + "\n";
		}
		
		return result;
	}
	
	public Integer[] getMaxHeap()
	{
		return maxHeap;
	}
	
	public int getLength()
	{
		return arrSize;
	}
	
	public int getSize()
	{
		return heapSize;
	}
	
	//this method will make sure that there is enough space in the array to insert new elements into the heap
	public void ensureSpace() 
	{
    	if (heapSize == arrSize)
    	{
    		//make a new array of double the size of the original
    		Integer [] copy = new Integer[arrSize*2]; 
    		
    		//copy over all elements
    		for (int i = 0; i <heapSize; i++)
    		{
    			copy[i] = maxHeap[i]; 
    		}
    		
    		maxHeap = copy; 
    		arrSize *=2; 
    	}
    }
	
	public static void heapSort(Integer[] arr)
	{
		MaxHeap heap = new MaxHeap(arr);
		
		//loop through array in reverse order
		for(int i = arr.length - 1; i >= 0; i--)
		{
			//deleting max each time will sort out the heap for us
			arr[i] = heap.deleteMax();
		}
	}
	
    public int rightChildIndex(int n)
    {
        return (2*n+2);
    }
    
    public int leftChildIndex(int n)
    {
        return (2*n+1);
    }
    
    public int parentChildIndex(int n)
    {
        return (n/2);
    
    }
    
    //swap two items in the array
    public void swap(int item1, int item2)
    {
    	int temp = maxHeap[item1];
    	maxHeap[item1] = maxHeap[item2];
    	maxHeap[item2] = temp;
    }
}
