package hellojpa;

import javax.persistence.*;

@Entity
@Table(name = "locker")
public class Locker {
    @Id @GeneratedValue
    private Long id;

    private  String string;

    @OneToOne(mappedBy = "locker")
    private  Member member;
}