package stringAndArray;

public class RotateArray {
	private int[] arr;
	private int length;
	
	public RotateArray(int length) {
		// TODO Auto-generated constructor stub
		this.arr = new int[length];
		this.length = length;
	}
	
	public void rotateArrayBruteForce(int value){
		if(length == 1 || length == value)
			return;
		if(value > length)
			value %= length;
		int valueTemp = value;
		while(valueTemp > 0){
			int temp = arr[length-1];
			for(int i = length - 1; i > 0; i--){
				arr[i] = arr[i-1];
			}
			arr[0] = temp;
			valueTemp--;
		}
	}
	
	public void rotateArrayNonOptimal(int value){
		if(length == 1 || length == value)
			return;
		if(value > length)
			value %= length;
		int[] arrCopy = new int[length];
		for(int i = 0; i < length; i++)
			arrCopy[i] = arr[i];
		for(int i = 0; i < length; i++){
			arrCopy[(i+value)%(length)] = arr[i];
		}
		arr = arrCopy;
	}
	
	public void rotateArrayBubble(int value){
		if(length == 1 || length == value)
			return;
		if(value > length)
			value %= length;
		for(int i = 0; i < value; i++){
			for(int j = length-1; j > 0; j--){
				int temp = arr[j];
				arr[j]  = arr[j-1];
				arr[j-1] = temp;
			}
		}
	}
	
	
/*	
    Logic Used:
    1. Divide the array two parts: 1,2,3,4 and 5, 6
	2. Rotate first part: 4,3,2,1,5,6
	3. Rotate second part: 4,3,2,1,6,5
	4. Rotate the whole array: 5,6,1,2,3,4*/
	
	public void rotateArray(int value){
		if(length == 1 || length == value)
			return;
		if(value > length)
			value %= length;
		int a = length - value;
		reverse(0, a-1);
		reverse(a,length-1);
		reverse(0,length-1);
	}
	
	private void reverse(int i, int j) {
		if(arr == null || i-j == 1 )
			return;
		while(i < j){
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
	}

	public static void main(String argc[]){
		int rotValue = 5;
		RotateArray ra = new RotateArray(5);
		for(int i = 0; i < 5; i++)
			ra.arr[i] = i;
		ra.rotateArrayBruteForce(rotValue);
		for(int i : ra.arr)
			System.out.print(i);
		System.out.println();
		for(int i = 0; i < 5; i++)
			ra.arr[i] = i;
		ra.rotateArrayNonOptimal(rotValue);
		for(int i : ra.arr)
			System.out.print(i);
		System.out.println();
		for(int i = 0; i < 5; i++)
			ra.arr[i] = i;
		ra.rotateArrayBubble(rotValue);
		for(int i : ra.arr)
			System.out.print(i);
		System.out.println();
		for(int i = 0; i < 5; i++)
			ra.arr[i] = i;
		ra.rotateArray(rotValue);
		for(int i : ra.arr)
			System.out.print(i);
	}
}
