import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int a[] = { 10, 4, 2, 77, 43, 86, 12, 100 };
        int n = a.length;
        mergeSort(a, 0, n - 1);
        System.out.println(Arrays.toString(a));
    }

    static void mergeSort(int a[], int l, int h) {
        if (l < h) {
            int mid = (l + h) / 2;
            mergeSort(a, l, mid);
            mergeSort(a, mid + 1, h);
            merge(a, l, mid, h);
        }
    }

    static void merge(int a[], int l, int mid, int h) {
        int i = l, j = mid + 1;
        int k = 0;
        int b[] = new int[h - l + 1];
        while (i <= mid && j <= h) {
            if (a[i] < a[j])
                b[k++] = a[i++];
            else
                b[k++] = a[j++];
        }
        while (i <= mid) {
            b[k++] = a[i++];
        }
        while (j <= h) {
            b[k++] = a[j++];
        }
        k = 0;
        for (int x = l; x <= h; x++) {
            a[x] = b[k++];
        }
    }
}