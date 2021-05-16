package ru.hibernate.springhibernate.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "transactions", schema = "public", catalog = "postgres")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
public class Transaction  implements Serializable {

    public Transaction(int id, int frombill2, int tobill2,
                       double sum, LocalDateTime datetransaction, String description) {
        this.id = id;
        this.frombill2 = frombill2;
        this.tobill2 = tobill2;
        this.sum = sum;
        this.datetransaction = datetransaction;
        this.description = description;
    }

    public Transaction(int id, Bill frombill, Bill tobill,
                       double sum, LocalDateTime datetransaction, String description) {
        this.id = id;
        this.frombill = frombill;
        this.tobill = tobill;
        this.sum = sum;
        this.datetransaction = datetransaction;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "frombill")
    private Bill frombill;

    @Column(name = "frombill",insertable = false, updatable = false)
    private int frombill2;

    @ManyToOne
    @JoinColumn(name = "tobill")
    private Bill tobill;

    @Column(name = "tobill",insertable = false, updatable = false)
    private int tobill2;

    @Column(name = "sum")
    private double sum;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    @Column(name = "datetransaction")
    private LocalDateTime datetransaction;

    @Column(name = "descriptions")
    private String description;
}
