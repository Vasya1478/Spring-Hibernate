package ru.hibernate.springhibernate.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.hibernate.springhibernate.entity.Transaction;

import java.util.List;

@Repository
public interface TransactionRepository  extends JpaRepository<Transaction, Integer> {

    @Query("select new ru.hibernate.springhibernate.entity.Transaction(t.id, t.frombill," +
            "t.tobill, t.sum, t.datetransaction, t.description) " +
            "from Transaction t where t.frombill.clientid.id =:par")
    List<Transaction> transactionByClient(@Param("par")int par);
}
