package ru.hibernate.springhibernate.spring.repository;

import org.hibernate.annotations.NamedNativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.hibernate.springhibernate.entity.Bill;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {
   List<Bill> findAllByClientid(Integer source);

    @Query("select new ru.hibernate.springhibernate.entity.Bill(b.id, b.uid, b.clientid, b.total) " +
            "from Bill b where b.clientid.id =:par")
    List<Bill> hg(@Param("par")int par);

    @Modifying
    @Query("update Bill b set b.total=:total where b.id =:id")
    void updateBill(@Param("total") double total, @Param("id") int id);

}
