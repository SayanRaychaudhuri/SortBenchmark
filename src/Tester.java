import javax.swing.*;

public class Tester {
    static Sorting sorting = new Sorting();
    public static void main(String[] args) {
        System.out.printf("%s%15s%15s%15s%15s%15s\n", "selection", "insertion", "merge", "bubble", "quick", "radix");
        System.out.printf("%d%15d%15d%15d%15d%15d\n", sorting.selectionSortAvgTime(), sorting.insertionSortAvgTime()
                                                    , sorting.mergeSortAvgTime(), sorting.bubbleSortAvgTime()
                                                    , sorting.quickSortAvgTime(), sorting.radixSortAvgTime());
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new GraphingData());
        f.setSize(400,400);
        f.setLocation(200,200);
        f.setVisible(true);
    }
}
