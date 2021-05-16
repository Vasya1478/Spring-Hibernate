package ru.hibernate.springhibernate.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillDTO {

    private int id;

    private int uid;

    private ClientDTO clientid;

    @JsonIgnore
    private int clientid2;

    private double total;

    public BillDTO(int id, int uid, int clientid2, double total) {
        this.id = id;
        this.uid = uid;
        this.clientid2 = clientid2;
        this.total = total;
    }
}
