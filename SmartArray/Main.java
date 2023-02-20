package SmartArray;

public class Main {
    public static void main(String[] args) {

        SmartArray smartArray = new SmartArray();
        smartArray.add(0);
        smartArray.add(1);
        smartArray.add(2);
        smartArray.add(3);
        smartArray.add(4);
        smartArray.remove(1);

        System.out.println(smartArray.contains(13));

       smartArray.forEach(p-> System.out.println(p));
    }
}
