import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        int[] prev = {3,9,6,-8,-11,2,8,6,5,0,-4,6,1,8,4,7};
        Scanner scanner = new Scanner(System.in);
        boolean bool = true;
        while (bool) {
            int[] arr = Arrays.copyOfRange(prev,0,prev.length);
            System.out.print("Перед: ");
            System.out.println(Arrays.toString(arr));
            System.out.println("Виберіть алгоритм сортування або вийдіть із програми: ");
            System.out.println("1. Bubble\n" + "2. Insertion\n" + "3. Merge\n" + "4. Quick\n" + "5. Insertion\n" + "6. Exit");
            System.out.print("Оберіть номер: ");
            switch (scanner.nextInt()) {
                case 1:
                    bubble(arr);
                    print(arr);
                    break;
                case 2:
                    insertion(arr);
                    print(arr);
                    break;
                case 3:
                    merge(arr);
                    print(arr);
                    break;
                case 4:
                    quick(arr);
                    print(arr);
                    break;
                case 5:
                    insertion(arr);
                    print(arr);
                    break;
                case 6:
                    System.out.println("Програму завершено.");
                    bool = false;
            }
        }
    }

    private static void print(int[] arr) {
        System.out.print("Після: ");
        System.out.println(Arrays.toString(arr));
        System.out.println();
    }

    //----------------------Bubble----------------------------------
    private static void bubble(int[] arr) {
        int in;
        do {
            in = 0;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    in++;
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }

        } while (in != 0);
    }

    //----------------------Selection----------------------------------
    private static void selection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i + 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (arr[min] < arr[i]) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

    //----------------------Insertion----------------------------------
    private static void insertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int pos = i;
            for (int j = i - 1; j >= 0 && key < arr[j]; j--) {
                int temp = arr[pos];
                arr[pos] = arr[j];
                arr[j] = temp;
                pos--;
            }
        }
    }

    //----------------------Quick----------------------------------
    private static void quick(int[] arr){
        sort(arr,0,arr.length-1);
    }

    private static void sort(int[] arr, int start, int end){
        if (start < end) {
            int i = start-1;
            for (int j=start; j<end; j++)
            {
                if (arr[j] < arr[end]) {
                    int temp = arr[++i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            int temp = arr[++i];
            arr[i] = arr[end];
            arr[end] = temp;
            sort(arr, start, i-1);
            sort(arr, i+1, end);
        }
    }

    //----------------------Merge----------------------------------
    private static void merge(int[] arr) {
        mergeSort(arr, 0, arr.length-1);
    }

    private static void mergeSort(int[] arr, int l, int r) {
        if (l != r){
            int mid = (l+r)/2;
            mergeSort(arr,l,mid);
            mergeSort(arr,mid+1,r);
            mergeBound(arr,l,mid,r);
        }
    }

    private static void mergeBound(int[] arr, int l, int mid, int r) {
        int[] leftArr = Arrays.copyOfRange(arr,l,mid+1);
        int[] rightArr = Arrays.copyOfRange(arr,mid+1,r+1);
        int i = 0, j = 0, k = l;

        while (i < leftArr.length || j < rightArr.length) {
            int rightSide  = j >= rightArr.length ? Integer.MAX_VALUE : rightArr[j];
            int leftSide  =  i >= leftArr.length  ? Integer.MAX_VALUE : leftArr[i] ;
            if (leftSide <= rightSide) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

    }


}
