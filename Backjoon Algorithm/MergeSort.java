
public class MergeSort {

	static int[] temp;
	
	public static void main(String[] args) {

		int[] num = new int[] {5,3,1,2,4,8,0};
		temp = new int[num.length];
		
		mergeSort(num, 0, num.length-1);
		
		System.out.println(num[0] + " / " + num[1] + " / " + num[2] + " / " + num[3] + " / " + num[4] + " / " + num[5] +" / " + num[6]);
	}
	

	public static void mergeSort(int[] num, int left, int right) {
		if (left < right) {			
			int mid = (left +right) / 2 ;
			
			mergeSort(num, 0, mid);
			mergeSort(num, mid + 1, right);

			merge(num, left, mid, right);
		}
	}

	public static void merge(int[] num, int left, int mid, int right) {
		int pos = left;
		int midP = mid+1;
		int size = right - left + 1;

		while (left <= mid && midP <= right) {
			if (num[left] > num[midP]) {
				temp[pos] = num[midP];
				midP++;
			} else {
				temp[pos] = num[left];
				left++;
			}
			pos++;
		}

		while (left <= mid) {
			temp[pos] = num[left];
			left++;
			pos++;
		}
		while (midP <= right) {
			temp[pos] = num[midP];
			midP++;
			pos++;
		}

		for (int i = 0; i < size; i++) {
			num[right] = temp[right];
			right--;
		}
	}
}
