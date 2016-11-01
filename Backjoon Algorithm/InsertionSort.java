
public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] num = new int[] {5,3,1,2,4,8,0};
	 	
		insertionSort(num);
		
		System.out.println(num[0] + " / " + num[1] + " / " + num[2] + " / " + num[3] + " / " + num[4] + " / " + num[5] +" / " + num[6]);

	}
	
	public static void insertionSort(int[] num){
	 
		for(int i = 1; i < num.length; ++i){
			int temp = num[i];
			int prev = i-1;
			
			while(prev>=0 && num[prev] > temp){
				num[prev+1] = num[prev];
				prev--;
			}
			
			num[prev+1] = temp;
		}
	}

}
