package hellojpa;

public class ValueMain {
    public static void main(String[] args) {

//        Integer a = new Integer(10);
//        Integer b = a;

        // 값 타입
//        int a = 10;
//        int b = a;
//        b = 20;

//        System.out.println("a = " + a);
//        System.out.println("b = " + b);

        // season2

        int a = 10;
        int b = 10;

        System.out.println("(a==b) = " + (a == b));

        String str1 = "ok";
        String str2 = "ok";

        System.out.println("(str1==str2) = " + (str1 == str2));

        Address address1 = new Address("city", "street", "10000");
        Address address2 = new Address("city", "street", "10000");

        System.out.println("(address1==address2) = " + (address1 == address2));

        System.out.println("address1.equals(address2) = " + address1.equals(address2));

    }
}
