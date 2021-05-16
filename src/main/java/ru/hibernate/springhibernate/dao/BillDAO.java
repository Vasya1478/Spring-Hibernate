package ru.hibernate.springhibernate.dao;

import ru.hibernate.springhibernate.dto.BillDTO;
import ru.hibernate.springhibernate.entity.Bill;

public interface BillDAO extends MainDAO<BillDTO, Bill> {

    BillDTO saveById(Bill bill);
}
