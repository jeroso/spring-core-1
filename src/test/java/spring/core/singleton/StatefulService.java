package spring.core.singleton;

public class StatefulService {

//    스프링 빈은 항상 stateless(무상태)를 설계해야 한다.

//    private int price;  //상태를 유지하는 필드

//    public void order(String name, int price) {
    public int order(String name, int price) {
        System.out.println("name + \" price = \" + price = " + name + " price = " + price);
//        this.price = price; // 여기가 문제!
        return price;
    }

//    public int getPrice() {
//        return price;
//    }

}
