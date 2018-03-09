import java.util.Random;

public class SortBenchmark {
    private int elements, numAverages;
    private int[] assorted;
    public SortBenchmark(int elements, int numAverages){
    	this.elements = elements;
        this.numAverages = numAverages;
    	assorted = new int[elements];
    	for (int i=0;i<assorted.length;i++)
    		assorted[i] = i;
    	randomize(assorted);
    }

    public long bubbleSort(int a[]) {
    	long time = System.nanoTime();
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
        return System.nanoTime() - time;
    }

    public long bubbleSortAvgTime() {
    	long totalTime = 0;
    	for(int i=0;i<numAverages;i++) {
    		totalTime += bubbleSort(randomize(assorted));
    	}
    	return totalTime/numAverages;
    }
    
    public long selectionSort(int a[]) {
    	long time = System.nanoTime();
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
        return System.nanoTime() - time;
    }

    public long selectionSortAvgTime() {
    	long totalTime = 0;
    	for(int i=0;i<numAverages;i++) {
    		totalTime += selectionSort(randomize(assorted));
    	}
    	return totalTime/numAverages;
    }
    
    public long insertionSort(int a[]) {
    	long time = System.nanoTime();
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
        return System.nanoTime() - time;
    }

    public long insertionSortAvgTime() {
    	long totalTime = 0;
    	for(int i=0;i<numAverages;i++) {
    		totalTime += insertionSort(randomize(assorted));
    	}
    	return totalTime/numAverages;
    }
    
    public long quickSort(int a[ ], int left, int right) {
    	long time = System.nanoTime();
        if (left >= right) return System.nanoTime() - time;
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
        return System.nanoTime() - time;
    }

    public long quickSortAvgTime() {
    	long totalTime = 0;
    	for(int i=0;i<numAverages;i++) {
    		totalTime += quickSort(randomize(assorted), 0, elements-1);
    	}
    	return totalTime/numAverages;
    }
    
    public long mergeSort(int a[ ], int left, int right) {
    	long time = System.nanoTime();
    	if (right == left) return System.nanoTime() - time;
        int middle = (left + right) /2; //salient feature #1
        mergeSort(a, left, middle); //salient feature #2 (recursion)
        mergeSort(a, middle + 1, right); //salient feature #3
        merge(a, left, middle, right); //salient feature #4
		return System.nanoTime() - time;
    }

    private void merge(int[] a, int left, int middle, int right) {
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

    public long mergeSortAvgTime() {
    	long totalTime = 0;
    	for(int i=0;i<numAverages;i++) {
    		totalTime += mergeSort(randomize(assorted), 0, elements-1);
    	}
    	return totalTime/numAverages;
    }
    
    public long radixSort(int a[]) {
    	long time = System.nanoTime();
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
        return System.nanoTime() - time;
    }
    
    public long radixSortAvgTime() {
    	long totalTime = 0;
    	for(int i=0;i<numAverages;i++) {
    		totalTime += radixSort(randomize(assorted));
    	}
    	return totalTime/numAverages;
    }
    
    public int getElements() {
    	return elements;
    }
    
    public static int[] randomize(int[] a){
        Random rand = new Random();
        for (int A : a) {
            int randPos = rand.nextInt(a.length);
            int temp = A;
            A = a[randPos];
            a[randPos] = temp;
        }
        return a;
    }
    
    public void display() {
        System.out.printf("%10d%21d%13d%18d%14d%16d%15d\n", getElements(), selectionSortAvgTime(), insertionSortAvgTime()
                                                    , mergeSortAvgTime(), bubbleSortAvgTime()
                                                    , quickSortAvgTime(), radixSortAvgTime());
    }
}
