package maxHeapLab;

public class TestClass 
{

	public static void main(String[] args) 
	{
		System.out.println("Uzair Jawaid; jawaidu; 400114899");
		System.out.println("Testing constructors");
		System.out.println("----------------------------------------------------------------------------");
		Integer[] arr = {5,1,6,8,10,11,125,67,9,81,3}; 
        MaxHeap test1 = new MaxHeap(arr);
        System.out.println("----------------------------------------------------------------------------");
        
        System.out.println("Testing heatSort method");
		System.out.println("----------------------------------------------------------------------------");
        System.out.println(test1.toString());
        test1.heapSort(arr);
        System.out.println(test1.toString());
        
        System.out.println("----------------------------------------------------------------------------");
 
        MaxHeap test2 = new MaxHeap(6); 
        System.out.println(test2.toString()); 

        System.out.println("Testing insert method");
		System.out.println("----------------------------------------------------------------------------");
        Integer[] array = {91,3,51,9,467}; 
        test2 = new MaxHeap(array); 
        System.out.println(test2.toString()); 
        test2.insert(72);
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Testing deleteMax method");
		System.out.println("----------------------------------------------------------------------------");
        System.out.println(test2.toString()); 
        test2.deleteMax(); 
        System.out.println(test2.toString()); 
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Testing heapSort method");
		System.out.println("----------------------------------------------------------------------------");
        test2.heapSort(array);
        System.out.println(test2.toString()); 
        
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Testing completed.");
		System.out.println("----------------------------------------------------------------------------");

	}

}
