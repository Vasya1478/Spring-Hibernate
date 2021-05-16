package ru.hibernate.springhibernate.spring.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.hibernate.springhibernate.MappingService;
import ru.hibernate.springhibernate.dao.TransactionDAO;
import ru.hibernate.springhibernate.dto.TransactionDTO;
import ru.hibernate.springhibernate.entity.Transaction;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class TransactionService implements TransactionDAO {
    private MappingService mappingService;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private BillRepository billRepository;

    public TransactionService(MappingService mappingService) {
        this.mappingService = mappingService;
    }

    @Override
    public List<TransactionDTO> getAll() {
        List<Transaction> transactions = transactionRepository.findAll();
        List<TransactionDTO> list = mappingService.mapList(transactions, TransactionDTO.class);
        return list;
    }

    @Override
    public TransactionDTO save(Transaction transaction) {

        transaction.setDatetransaction(LocalDateTime.now());
        Transaction newTransaction = transactionRepository.save(transaction);
        TransactionDTO transactionDTO = mappingService.map(newTransaction, TransactionDTO.class);
        return transactionDTO;
    }

    @Override
    public TransactionDTO saveById(Transaction transaction) {
        Transaction newTransaction = new Transaction(transaction.getId(),
                billRepository.findById(transaction.getFrombill2()).get(),
                billRepository.findById(transaction.getTobill2()).get(),
                transaction.getSum(), LocalDateTime.now(), transaction.getDescription());
        Transaction saveTransaction = transactionRepository.save(newTransaction);
        billRepository.updateBill(saveTransaction.getFrombill().getTotal() - saveTransaction.getSum(),
                saveTransaction.getFrombill().getId());
        TransactionDTO transactionDTO = mappingService.map(saveTransaction, TransactionDTO.class);

        billRepository.updateBill(saveTransaction.getTobill().getTotal() + saveTransaction.getSum(),
                saveTransaction.getTobill().getId());
        return transactionDTO;
    }

    public List<TransactionDTO> transactionById(Integer id) {
        List<Transaction> transactions = transactionRepository.transactionByClient(id);
        List<TransactionDTO> trans = mappingService.mapList(transactions, TransactionDTO.class);
        return trans;
    }
}
