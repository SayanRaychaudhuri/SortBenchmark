import java.util.Arrays;
public class Tester {
    static SortBenchmark sorting = new SortBenchmark();
    public static void main(String[] args) {
        System.out.printf("%s%15s%15s%15s%15s%15s\n", "selection", "insertion", "merge", "bubble", "quick", "radix");
        System.out.printf("%d%15d%15d%15d%15d%15d\n", sorting.selectionSortAvgTime(), sorting.insertionSortAvgTime()
                                                    , sorting.mergeSortAvgTime(), sorting.bubbleSortAvgTime()
                                                    , sorting.quickSortAvgTime(), sorting.radixSortAvgTime());
        // Used to check consistency
        sorting.addPoints(SortBenchmark.Sort.SELECTION);
        System.out.println(Arrays.toString(sorting.points.toArray()));
    }

}
