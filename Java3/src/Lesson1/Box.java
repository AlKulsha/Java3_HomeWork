package Lesson1;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruit>{

    private List<T> list;

    public Box(){
        list = new ArrayList<T>();
    }

    void add(T obj){
        list.add(obj);
    }


    float getWeight(){
        if(list.isEmpty()){
            return 0;
        }else{
            return list.size() * list.get(0).getWeight();
        }
    }

    boolean compare(Box<? extends Fruit> box){
        return (Math.abs(this.getWeight()-box.getWeight()) < 0.001);
    }

    void moveToAnotherBox(Box<T> box){
        for (T obj: list){
            box.add(obj);
        }
        list.clear();
    }



    void info(){
        if(list.isEmpty()){
            System.out.println("Коробка пуста");
        }else{
            System.out.println("В коробке: " + list.get(0).toString()+ " " + list.size() + " шт.");
        }
    }

}
