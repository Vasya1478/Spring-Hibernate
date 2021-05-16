package ru.hibernate.springhibernate.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hibernate.springhibernate.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {


}
