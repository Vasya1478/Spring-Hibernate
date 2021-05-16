package ru.hibernate.springhibernate.dao;

import ru.hibernate.springhibernate.dto.BillDTO;
import ru.hibernate.springhibernate.dto.TransactionDTO;
import ru.hibernate.springhibernate.entity.Bill;
import ru.hibernate.springhibernate.entity.Transaction;

public interface TransactionDAO extends MainDAO<TransactionDTO, Transaction> {
    TransactionDTO saveById(Transaction transaction);
}
