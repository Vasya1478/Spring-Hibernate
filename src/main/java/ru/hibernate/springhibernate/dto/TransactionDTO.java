package ru.hibernate.springhibernate.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import ru.hibernate.springhibernate.entity.Bill;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {

    private int id;

    @JsonIgnore
    private Bill frombill;

    private int frombill2;

    @JsonIgnore
    private Bill tobill;

    private int tobill2;

    private double sum;

    private LocalDateTime datetransaction;

    private String description;

    public TransactionDTO(int id, int frombill2, int tobill2,
                          double sum, LocalDateTime datetransaction, String description) {
        this.id = id;
        this.frombill2 = frombill2;
        this.tobill2 = tobill2;
        this.sum = sum;
        this.datetransaction = datetransaction;
        this.description = description;
    }
}
