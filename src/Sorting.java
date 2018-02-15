
public class Sorting {

    public static void main(String[] args) {
        System.out.println(bubbleSortAvgTime());
        System.out.println(selectionSortAvgTime());
        System.out.println(insertionSortAvgTime());
        System.out.println(quickSortAvgTime());
        System.out.println(mergeSortAvgTime());
        System.out.println(radixSortAvgTime());
    }

    public static void bubbleSort(int a[]) {
        boolean loop;
        do {
            loop = false;
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    loop = true;
                }
            }
        } while (loop);
    }

    public static long bubbleSortAvgTime(){
        int a[] = {2,5,9,0,12,4,8,11,3,14,15,20,47,23,90,132,35,1,19};
        long startTime = System.nanoTime();
        for (int i=0;i<100;i++)
        bubbleSort(a);
        return (System.nanoTime() - startTime)/100;
    }

    public static void selectionSort(int a[]) {
        int min, minIndex;
        for (int i = 0; i < a.length; ++i) {
            min = a[i];
            minIndex = i;
            for (int j = i + 1; j < a.length; ++j) {
                if (a[j] < min) {
                    min = a[j];
                    minIndex = j;
                }
            }
            a[minIndex] = a[i];
            a[i] = min;
        }
    }

    public static long selectionSortAvgTime(){
        int a[] = {2,5,9,0,12,4,8,11,3,14,15,20,47,23,90,132,35,1,19};
        long startTime = System.nanoTime();
        for (int i=0;i<100;i++)
        selectionSort(a);
        return (System.nanoTime() - startTime)/100;
    }

    public static void insertionSort(int a[]) {
        int itemToInsert, j;
        boolean loop;
        for (int k = 1; k < a.length; k++) {
            itemToInsert = a[k];
            j = k - 1;
            loop = true;
            while ((j >= 0) && loop) {
                if (itemToInsert < a[j]) {
                    a[j + 1] = a[j];
                    j--;
                    if (j == -1)
                        a[0] = itemToInsert;
                } else {
                    loop = false;
                    a[j + 1] = itemToInsert;
                }
            }
        }
    }

    public static long insertionSortAvgTime(){
        int a[] = {2,5,9,0,12,4,8,11,3,14,15,20,47,23,90,132,35,1,19};
        long startTime = System.nanoTime();
        for (int i=0;i<100;i++)
        insertionSort(a);
        return (System.nanoTime() - startTime)/100;
    }

    public static void quickSort(int a[ ], int left, int right) {
        if (left >= right) return;
        int k = left;
        int j = right;
        int pivotValue = a[ (left + right) / 2 ];
        while ( k < j ) {
            while (a[k] < pivotValue) {
                k++;
            }
            while ( pivotValue < a[j] ) {
                j--;
            }
            if ( k <= j) {
                int temp = a[k];
                a[k] = a[j];
                a[j] = temp;
                k++;
                j--;
            }
        }
        quickSort(a, left, j);
        quickSort(a, k, right);
    }

    public static long quickSortAvgTime(){
        int a[] = {2,5,9,0,12,4,8,11,3,14,15,20,47,23,90,132,35,1,19};
        long startTime = System.nanoTime();
        for (int i=0;i<100;i++)
        quickSort(a, 0 ,18);
        return (System.nanoTime() - startTime)/100;
    }

    public static void mergeSort(int a[ ], int left, int right) {
        if (right == left) return;
        int middle = (left + right) /2; //salient feature #1
        mergeSort(a, left, middle); //salient feature #2 (recursion)
        mergeSort(a, middle + 1, right); //salient feature #3
        merge(a, left, middle, right); //salient feature #4
    }

    public static long mergeSortAvgTime(){
        int a[] = {2,5,9,0,12,4,8,11,3,14,15,20,47,23,90,132,35,1,19};
        long startTime = System.nanoTime();
        for (int i=0;i<100;i++)
        mergeSort(a, 0 ,18);
        return (System.nanoTime() - startTime)/100;
    }

    private static void merge(int[] a, int left, int middle, int right) {
        int tmpArray[ ] = new int[right - left +1];
        int index1 = left;
        int index2 = middle + 1;
        int index = 0;
        while (index1 <= middle && index2 <= right) {
            if ( a[index1] < a[index2] ) {
                tmpArray[index] = a[index1];
                index1++;
            }
            else {
                tmpArray[index] = a[index2];
                index2++;
            }
            index++;
        }
        while(index1 <= middle) {
            tmpArray[index] = a[index1];
            index1++;
            index++;
        }
        while(index2 <= right) {
            tmpArray[index] = a[index2];
            index2++;
            index++;
        }
        for (index = 0; index < tmpArray.length; index++) {
            a[left + index] = tmpArray[index];
        }
    }

    public static void radixSort(int a[]) {
        int zeros[] = new int[a.length];
        int ones[] = new int[a.length];
        int mask = 1;
        for(int i = 0; i < 31; i ++) {
            int zerosArrayCount = 0, onesArrayCount = 0;
            for(int j = 0; j < a.length; j++) {
                int testBit = a[j] & mask;
                if(testBit == 0)
                    zeros[zerosArrayCount++] = a[j];
                else
                    ones[onesArrayCount++] = a[j];
            }
            int indx = 0;
            for(int j = 0; j < zerosArrayCount; j++)
                a[indx++] = zeros[j];
            for(int j = 0; j < onesArrayCount; j++)
                a[indx++] = ones[j];
            mask *= 2;
        }
    }

    public static long radixSortAvgTime(){
        int a[] = {2,5,9,0,12,4,8,11,3,14,15,20,47,23,90,132,35,1,19};
        long startTime = System.nanoTime();
        for (int i=0;i<100;i++)
            radixSort(a);
        return (System.nanoTime() - startTime)/100;
    }
}