package hellojpa;

import org.hibernate.Hibernate;
import org.hibernate.LazyInitializationException;

import javax.persistence.*;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
//            //회원 등록
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");
//            em.persist(member);

//            //회원 조회
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());

//            //회원 삭제
//            Member findMember = em.find(Member.class, 1L);
//            em.remove(findMember);

//            //회원 수정
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("HelloJPA");

//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
////                    .setFirstResult(5)
////                    .setMaxResults(8)
//                    .getResultList();
//            for (Member member : result) {
//                System.out.println("member.name = " + member.getName());
//            }

//            //비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");

//            //영속
//            System.out.println("=== BEFORE ===");
//            em.persist(member);

            //준영속
//            em.detach(member);

            //삭제
//            em.remove(member);

//            System.out.println("=== AFTER ===");

//            Member findMember1 = em.find(Member.class, 101L);
//            Member findMember2 = em.find(Member.class, 101L);
//
//            // 같은 영속 엔티티의 동일성 보장
//            System.out.println("result = " +(findMember1 == findMember2));

//            // 엔티티 등록 - 쓰기지연
//            //영속
//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//
//            em.persist(member1);
//            em.persist(member2);
//            System.out.println("======================");

//            // 엔티티 수정 - 변경감지(dirty checking)
//            Member member = em.find(Member.class, 150L);
//            member.setName("ZZZZZ");

//            // flush --> 데이터베이스에 변경된 내용을 반영
//            Member member = new Member(200L, "member200");
//            em.persist(member);
//
//            em.flush();

//            //준영속
//            Member member = em.find(Member.class, 150L); // 영속상태
//            member.setName("AAAAA");
//
////            em.detach(member); // 특정 엔티티만 준영속
//            em.clear();
//            Member member2 = em.find(Member.class, 150L); // 영속상태
//
//            System.out.println("======================");

            // Enumerated --> Ordinal
//            Member member = new Member();
////            member.setId("ID_A");
//            member.setUsername("D");
//
//            System.out.println("=======================");
//            em.persist(member);
//            System.out.println("member.id = " + member.getId());
//            System.out.println("=======================");


//            // allocation default 50 미리 확보하고 메모리를 통해서 50까지 채운 후 시퀸스를 다시 당김
//            Member member1 = new Member();
//            member1.setUsername("A");
//
//            Member member2 = new Member();
//            member2.setUsername("B");
//
//            Member member3 = new Member();
//            member3.setUsername("C");
//
//            System.out.println("=======================");
//
//            //DB SEQ = 1    |   1
//            //DB SEQ = 51   |   2
//            //DB SEQ = 51   |   3
//
//            em.persist(member1); // 1, 51
//            em.persist(member2); // MEM
//            em.persist(member3); // MEM
//
//            System.out.println("member1 = " + member1.getId());
//            System.out.println("member2 = " + member2.getId());
//            System.out.println("member3 = " + member3.getId());
//
//            System.out.println("=======================");

//            //저장
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            TestMember member = new TestMember();
//            member.setUsername("member1");
////            member.changeTeam(team); //**
//
//            em.persist(member);
//
//            team.addMember(member);
//
//
////            team.getMembers().add(member); //**
//
//            em.flush();
//            em.clear();
//
//            Team findTeam = em.find(Team.class, team.getId()); // 1차 캐시
//            List<TestMember> members = findTeam.getMembers();
//
//            System.out.println("=============================");
//            for (TestMember m : members) {
//                System.out.println("m = " + m.getUsername());
//            }
//
////            System.out.println("members = " + findTeam); // 무한루프 : toString에서 Member <----> Team 서로 참조하기 때문에
//            System.out.println("=============================");

//            TestMember member = new TestMember();
//            member.setUsername("member1");
//
//            em.persist(member); // 영속화 --> 1차캐시
//
//            Team team = new Team();
//            team.setName("teamA");
//            team.getMembers().add(member);
//
//            em.persist(team);


//            Movie movie = new Movie();
//            movie.setDirector("aaaa");
//            movie.setActor("bbbb");
//            movie.setName("바람과함께사라지다");
//            movie.setPrice(10000);
//
//            em.persist(movie);
//
//            em.flush();
//            em.clear();
//
////            Movie findMovie = em.find(Movie.class, movie.getId());
//            Item findItem = em.find(Item.class, movie.getId());
////            System.out.println("findMovie = " + findMovie);
//            System.out.println("findItem = " + findItem);

//            TestMember member = new TestMember();
//            member.setUsername("user1");
//            member.setCreateBy("kim");
//            member.setCreateDate(LocalDateTime.now());
//            em.persist(member);

//            em.flush();
//            em.clear();

            Team team1 = new Team();
            team1.setName("teamA");
            em.persist(team1);

            Team team2 = new Team();
            team2.setName("teamB");
            em.persist(team2);

            TestMember member1 = new TestMember();
            member1.setUsername("member1");
            member1.setTeam(team1);
            em.persist(member1);

            TestMember member2 = new TestMember();
            member2.setUsername("member2");
            member2.setTeam(team2);
            em.persist(member2);

            em.flush();
            em.clear();

//            TestMember findMember = em.find(TestMember.class, member.getId());
//            TestMember findMember = em.getReference(TestMember.class, member1.getId());
//            System.out.println("before findMember = " + findMember.getClass()); // findMember = class hellojpa.TestMember$HibernateProxy$8VDcRtmg (프록시 객체)
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.username = " + findMember.getUsername());
//            System.out.println("after findMember = " + findMember.getClass()); // findMember = class hellojpa.TestMember$HibernateProxy$8VDcRtmg (프록시 객체)

////            TestMember m1 = em.find(TestMember.class, member1.getId());
//            TestMember refMember = em.getReference(TestMember.class, member1.getId());
////            TestMember m2 = em.find(TestMember.class, member2.getId());
////            TestMember m2 = em.getReference(TestMember.class, member2.getId());
////            logic(m1, m2);
////            System.out.println("m1 = " + m1.getClass());
//            System.out.println("refMember.class = " + refMember.getClass()); //Proxy
//            System.out.println("refMember.class.name = " + refMember.getClass().getName()); //Proxy
////            refMember.getUsername(); // 강제 초기화 --> 직접 속성 호출/ 강제 호출
//
//            Hibernate.initialize(refMember); // 강제 초기화
//            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refMember));

////            TestMember ref= em.getReference(TestMember.class, member1.getId());
//            TestMember findMember = em.find(TestMember.class, member1.getId());
////            System.out.println("ref = " + ref.getClass());
//            System.out.println("findMember = " + findMember.getClass()); //Member X -->Proxy proxy 또는 Entity든 먼저 조회한 참조타입을 따라간다.
//
//            System.out.println("refMember == findMember = " + (refMember == findMember));
////            System.out.println("a == a: " + (m1 == ref));

//            em.detach(refMember);
//            em.close();  // LazyInitializationException이 발생했어야 했으나, 버전이 올라가면, 트랜잭션을 종료하지 않은 상태에서 세션(엔티티메니져)을 닫았기 때문에 아직 트랜잭션이 살아있음.
                            // 기존에는 단순히 세션(엔티티메니져)이 끝나면 예외가 터졌어야 하는데, 이제부터는 트랜잭션이 유지되면 Lazy로딩을 사용
//           em.clear();  // LazyInitializationException 예외 발생
//           refMember.getUsername();

//            TestMember m = em.find(TestMember.class, member1.getId());

//            System.out.println("m.getClass() = " + m.getClass());
//            System.out.println("m.getTeam().getTeam().getClass() = " + m.getTeam().getClass());
//
//            System.out.println("==================");
//            m.getTeam(); //Proxy --> LAZY 지연로딩 일 떄
//            System.out.println("teamName = " + m.getTeam().getName()); //초기화 --> LAZY 지연로딩 일 떄
//            System.out.println("==================");

            List<TestMember> members = em.createQuery("select m from TestMember m join fetch m.team", TestMember.class)
                    .getResultList();
            //SQL: select * from Member;
            //SQL: select * from Team where TEAM_ID = xxx;

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        emf.close();


    }

    private static void logic(TestMember m1, TestMember m2) {
//        System.out.println("(m1 == m2) = " + (m1.getClass() == m2.getClass()));
        System.out.println("(m1 instanceof Member) = " + (m1 instanceof TestMember));
        System.out.println("(m2 instanceof Member) = " + (m2 instanceof TestMember));
    }


}
