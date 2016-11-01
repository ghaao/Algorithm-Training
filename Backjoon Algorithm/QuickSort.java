
public class QuickSort {

	public static void main(String[] args) {

		int[] A = new int[] { 5, 3, 1, 2, 4, 8, 0 };

		quickSorting(A, 0, A.length - 1);

		System.out.println(
				A[0] + " / " + A[1] + " / " + A[2] + " / " + A[3] + " / " + A[4] + " / " + A[5] + " / " + A[6]);
	}

	public static void quickSorting(int[] data, int l, int r) {
		int left = l;
		int right = r;
		int pivot = data[(l + r) / 2];

		while (left <= right) {
			while (data[left] < pivot)
				left++;
			while (data[right] > pivot)
				right--;
			if (left <= right) {
				int temp = data[left];
				data[left] = data[right];
				data[right] = temp;
				left++;
				right--;
			}
		}
		if (l < right)
			quickSorting(data, l, right);
		if (r > left)
			quickSorting(data, left, r);
	}
}
