package hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
               Member member1 = new Member();
               member1.setUsername("member1");
               em.persist(member1);

               Member member2 = new Member();
               member2.setUsername("member2");
               em.persist(member2);

               Team team = new Team();
               team.setName("teamA");
               em.persist(team);

               em.flush();
               em.clear();

               List<Member> members = em.createQuery("slect m from Member m join fetch m.team",Member.class).getResultList();

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

    private static void printMemberAndTeam(Member member) {
        String username = member.getUsername();
        System.out.println(username);
        Team team = member.getTeam();
        System.out.println(team.getName());
    }
}
