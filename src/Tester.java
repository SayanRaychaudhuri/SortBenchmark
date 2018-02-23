
public class Tester {
    static Sorting sorting = new Sorting();
    public static void main(String[] args) {
        System.out.println(sorting.selectionSortAvgTime());
        System.out.println(sorting.insertionSortAvgTime());
        System.out.println(sorting.mergeSortAvgTime());
        System.out.println(sorting.bubbleSortAvgTime());
        System.out.println(sorting.quickSortAvgTime());
        System.out.println(sorting.radixSortAvgTime());
    }
}
