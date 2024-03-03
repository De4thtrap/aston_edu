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

        List<Integer> emptyArrayList = new ArrayList<>();
        emptyArrayList.add(5);
        System.out.println("The 1st element of emptyArrayList: " + emptyArrayList.get(1));
        emptyArrayList.remove(25);
        emptyArrayList.sort();
        System.out.println(emptyArrayList);


        List<Integer> linkedList = new LinkedList<>(java.util.List.of(array));
        linkedList.add(3);
        linkedList.add(22, 4);
        System.out.println("The 7th element of linkedList: " + linkedList.get(7));
        linkedList.remove(25);
        linkedList.sort();
        System.out.println(linkedList);

        List<Integer> emptyLinkedList = new LinkedList<>();
        emptyLinkedList.add(5);
        System.out.println("The 1st element of emptyLinkedList: " + emptyLinkedList.get(1));
        emptyLinkedList.remove(25);
        emptyLinkedList.sort();
        System.out.println(emptyLinkedList);
    }
}
