package helper;

import error.EmptyList;
import error.ListLimit;

public class Data {
    public static int MAXIMUM_LENGTH = 10; //change this
    public int[] list;

    public Data() {
        this.list = new int[0];
    }

    public void addNumber(int i) {
        if (list.length == MAXIMUM_LENGTH) throw new ListLimit();
        int[] copy = new int[list.length + 1];
        if (i >= 0) System.arraycopy(list, 0, copy, 0, list.length);
        copy[list.length] = i;
        list = copy;
    }

    private void merge(int[] array, int l, int m, int r) {
        int lLength = m - l + 1;
        int rLength = r - m;

        int[] left = new int[lLength];
        int[] right = new int[rLength];

        if (lLength >= 0) System.arraycopy(array, l, left, 0, lLength);
        if (rLength >= 0) System.arraycopy(array, m + 1, right, 0, rLength);

        int i = 0, j = 0;

        int k = l;
        while (i < lLength && j < rLength) {
            if (left[i] <= right[j]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < lLength) {
            array[k] = left[i];
            i++;
            k++;
        }

        while (j < rLength) {
            array[k] = right[j];
            j++;
            k++;
        }
    }

    private void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            merge(array, left, middle, right);
        }
    }

    public void mergeSort() {
        if (list.length == 0) throw new EmptyList();
        mergeSort(list, 0, list.length - 1);
    }

    private int binarySearch(int[] array, int left, int right, int search) {
        if (left <= right && left <= array.length - 1) {
            int middle = (right + left) / 2;
            if (array[middle] == search) return middle;
            else if (array[middle] < search) return binarySearch(array, middle + 1, right, search);
            else return binarySearch(array, left, middle - 1, search);
        }
        return -1;
    }

    public int binarySearch(int search){
        mergeSort();
        return binarySearch(list, 0, list.length - 1, search);
    }
}
