package homework_lists;

public class Main {
    public static void main(String[] args) {

        Integer[] array = {5, 7, -3, 0, 1, 25, 72, 51, 14, 24};

        List<Integer> arrayList = new ArrayList<>(java.util.List.of(array));

        arrayList.add(3);
        arrayList.add(22, 4);
        System.out.println("The 7th element of arrayList: " + arrayList.get(7));
        arrayList.remove(25);
        arrayList.sort();
        System.out.println(arrayList);
    }
}