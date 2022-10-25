package moduleNine;

public class MyArrayListTester {
    public static void main(String[] args) {
        MyArrayList <Integer> numbers = new MyArrayList<>();
        numbers.add(1);
        for (int i = 0; i < 17; i++) {
            numbers.add(i);
        }
        System.out.println("numbers = " + numbers);
        numbers.remove(0);
        System.out.println("numbers = " + numbers);
        System.out.println("numbers.get(16) = " + numbers.get(16));

        MyArrayList  <String> strings = new MyArrayList<>();
        strings.add("Strings");
        strings.add("1");
        System.out.println("strings = " + strings);
        strings.clear();
        System.out.println("strings = " + strings);
    }
}
