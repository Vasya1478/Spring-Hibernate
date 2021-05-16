package ru.hibernate.springhibernate.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import ru.hibernate.springhibernate.entity.Bill;

import java.util.List;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {
    private int id;

    private int uid;

    private String name;

    private String address;

    private int age;

    @JsonIgnore
    private List<Bill> bills;
}
