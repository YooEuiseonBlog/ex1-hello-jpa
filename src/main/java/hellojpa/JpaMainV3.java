package hellojpa;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class JpaMainV3 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //JPQL 사용
//            String qlString = "select m from MemberV1 m where m.name like '%kim%'";
//
//            List<MemberV1> result = em.createQuery(
//                    qlString,
//                    MemberV1.class
//            ).getResultList();
//
//            for (MemberV1 member : result) {
//                System.out.println("member = " + member);
//            }

            //Criteria 사용 준비
//            CriteriaBuilder cb = em.getCriteriaBuilder();
//            CriteriaQuery<MemberV1> query = cb.createQuery(MemberV1.class);
//
//            Root<MemberV1> m = query.from(MemberV1.class);
//
//            CriteriaQuery<MemberV1> cq = query.select(m);
//
//            String username = "dsdds";
//            if (username != null) {
//                cq.where(cb.equal(m.get("name"), "kim"));
//            }
//            List<MemberV1> resultList = em.createQuery(cq)
//                    .getResultList();

            MemberV1 member = new MemberV1();
            member.setName("member1");
            em.persist(member);

            // flush -> commit, query

            //em.flush(); // 이 경우엔 flush 사용

            String sql = "select MEMBER_ID, city, street, zipcode, USERNAME from MEMBER_V1";
            List<MemberV1> resultList = em.createNativeQuery(sql, MemberV1.class)
                    .getResultList();

            // 결과 0 // 만약 위에 createQuery 쓰지 않고, jdbc template이든 다른 라이브러리로 데이터베이스 직접 넣을 때
            //dbconn.executeQuery("select * from memberV1);

            for (MemberV1 members : resultList) {
                System.out.println("members = " + members);
            }


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
