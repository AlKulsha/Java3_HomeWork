package Lesson1;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        Задача 1.
//        Integer[] arr = {1, 2, 3, 4, 5};
        String[] arr = {"F","f","K","L","S","E"};
        System.out.println(Arrays.toString(arr));
        swapElem(arr, 2, 4);
        System.out.println(Arrays.toString(arr));

//        Задача 2.
        List<String> list = convertToList(arr);

        System.out.println(list.getClass());

//        Задача 3.
        Box<Orange> orangeBox = new Box<>();
        Box<Orange> orangeBox2 = new Box<>();
        Box<Apple> appleBox = new Box<>();

        for (int i = 0; i < 4; i++) {
            orangeBox.add(new Orange());
        }

        for (int i = 0; i < 4; i++) {
            orangeBox2.add(new Orange());
        }

        for (int i = 0; i < 7; i++) {
            appleBox.add(new Apple());
        }

        System.out.println("Коробка с апельсинами весит: " +  orangeBox.getWeight());
        System.out.println("Коробка с яблоками весит: " +  appleBox.getWeight());

        System.out.println(orangeBox.compare(appleBox));
        System.out.println(orangeBox.compare(orangeBox2));

        Box<Orange> anotherOrangeBox = new Box<>();

        orangeBox2.moveToAnotherBox(anotherOrangeBox);
        orangeBox2.info();
        anotherOrangeBox.info();
    }


    private static <T> void swapElem(T[] array, int index1, int index2){
        T temp = array[index2];
        array[index2] = array[index1];
        array[index1] = temp;
    }

    private static <E> List<E> convertToList(E[] array){
        return Arrays.asList(array);
    }



}
