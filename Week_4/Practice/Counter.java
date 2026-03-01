package Week_4.Practice;
@SuppressWarnings("all")
public class Counter {
    static int count = 0;
    public Counter() {
        count++;
    }
    public static int getCount() {
        return count;
    }
    public static void main(String[] args) {
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        Counter c3 = new Counter();
        Counter c4 = new Counter();
        Counter[] c ={c1,c2,c3,c4};
        System.out.println("Total Counter objects created: " + Counter.getCount());
    }
}