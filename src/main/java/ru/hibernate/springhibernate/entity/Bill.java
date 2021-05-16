package ru.hibernate.springhibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "bills", schema = "public", catalog = "postgres")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
public class Bill implements Serializable {

    public Bill(int id, int uid, Client clientid, double total) {
        this.id = id;
        this.uid = uid;
        this.clientid = clientid;
        this.total = total;
    }

    public Bill(int id, int uid, int clientid2, double total) {
        this.id = id;
        this.uid = uid;
        this.clientid2 = clientid2;
        this.total = total;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "uid")
    private int uid;

    @ManyToOne
    @JoinColumn(name = "clientid")
//    @Column(name = "clientid")
    private Client clientid;

//    @Column(name = "clientid")
    @Column(name = "clientid",insertable = false, updatable = false)
    private int clientid2;

    @Column(name = "total")
    private double total;

    @OneToMany(mappedBy = "frombill")
    @Nullable
    private List<Transaction> frombills;

    @Nullable
    @OneToMany(mappedBy = "tobill")
    private List<Transaction> tobills;


}
