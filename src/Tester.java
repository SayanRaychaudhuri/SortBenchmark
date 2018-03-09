
public class Tester {
	
    public static void main(String[] args) {
    	System.out.printf("%15s%15s%15s%15s%15s%15s%15s\n", "numberOfElements", "selection", "insertion", "merge", "bubble", "quick", "radix");
    	for (int i = 10000; i<=100000;i+=10000)
    		new SortBenchmark(i,10).display();
    }

}
