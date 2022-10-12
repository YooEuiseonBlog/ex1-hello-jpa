package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class JpaMainV2 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {

//            Parent parent = new Parent();
//
//            Child child1 = new Child();
//            Child child2 = new Child();
//
//            parent.addChild(child1);
//            parent.addChild(child2);
//
//            em.persist(parent);
////            em.persist(child1);
////            em.persist(child2);
//
//            em.flush();
//            em.clear();
//
//            Parent findParent = em.find(Parent.class, parent.getId());
//            em.remove(findParent);
//            findParent.getChildList().remove(0); // 고아객체 제거

//            MemberV1 member = new MemberV1();
//            member.setName("hello");
//            member.setHomeAddress(new Address("city", "street", "1000"));
//            member.setWorkPeriod(new Period(LocalDateTime.now().withNano(0), LocalDateTime.now().withNano(0)));

            // 값타입, 객체타입 -- 불변객체으로 바꿔서 사용 / set은 지양하고, 생성자나 빌더를 활용해 변화요소를 고정시킨다.
//            Address address = new Address("city", "street", "10000");
//
//            MemberV1 member = new MemberV1();
//            member.setName("member1");
//            member.setHomeAddress(address);
//            em.persist(member);
//
//            Address newAddress = new Address("newCity", address.getStreet(), address.getZipcode());
//            member.setHomeAddress(newAddress);


//            Address copyAddress = new Address(address.getCity(), address.getStreet(), address.getZipcode());
//
//            MemberV1 member2 = new MemberV1();
//            member2.setName("member2");
//            member2.setHomeAddress(copyAddress);
//            em.persist(member2);

            // 값 타입 컬렉션

            MemberV1 member = new MemberV1();
            member.setName("member1");
            member.setHomeAddress(new Address("homeCity", "street", "10000"));

            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("족발");
            member.getFavoriteFoods().add("피자");

            member.getAddressHistory().add(new AddressEntity("old1", "oldStreet1", "o-10000"));
            member.getAddressHistory().add(new AddressEntity("old2", "oldStreet2", "o-10000"));

            em.persist(member);

            em.flush();
            em.clear();

            System.out.println("================= Start =================");
            MemberV1 findMember = em.find(MemberV1.class, member.getId()); // 컬렉션은 지연로딩(프록시)
            
            // 값 타입 컬렉션 조회
//            List<Address> addressHistory = findMember.getAddressHistory();
//            for (Address address : addressHistory) {
//                System.out.println("address = " + address.getCity());
//            }
//
//            Set<String> favoriteFoods = findMember.getFavoriteFoods();
//            for (String favoriteFood : favoriteFoods) {
//                System.out.println("favoriteFood = " + favoriteFood);
//            }

            // 값 타입 컬렉션 수정

            //homeCity -> newCity
//            findMember.getHomeAddress().setCity("newCity"); // 잘못된 방식
//            Address a = findMember.getHomeAddress();
//            findMember.setHomeAddress(new Address("newCity", a.getStreet(), a.getZipcode()));
//
//            //치킨 -> 한식
//            findMember.getFavoriteFoods().remove("치킨");
//            findMember.getFavoriteFoods().add("한식");

//            findMember.getAddressHistory().remove(new Address("old1", "oldStreet1", "o-10000"));
//            findMember.getAddressHistory().add(new Address("newCity1", "Street1", "n-10000"));

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        emf.close();
    }
}
