
public class Tester {
    static Sorting sorting = new Sorting();
    public static void main(String[] args) {
        System.out.printf("%s%15s%15s%15s%15s%15s\n", "selection", "insertion", "merge", "bubble", "quick", "radix");
        System.out.printf("%d%15d%15d%15d%15d%15d\n", sorting.selectionSortAvgTime(), sorting.insertionSortAvgTime()
                                                    , sorting.mergeSortAvgTime(), sorting.bubbleSortAvgTime()
                                                    , sorting.quickSortAvgTime(), sorting.radixSortAvgTime());
        main(null);
    }
}
