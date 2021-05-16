package ru.hibernate.springhibernate.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.hibernate.springhibernate.dto.BillDTO;
import ru.hibernate.springhibernate.dto.ClientDTO;
import ru.hibernate.springhibernate.dto.TransactionDTO;
import ru.hibernate.springhibernate.entity.Bill;
import ru.hibernate.springhibernate.entity.Client;
import ru.hibernate.springhibernate.entity.Transaction;
import ru.hibernate.springhibernate.spring.repository.BillService;
import ru.hibernate.springhibernate.spring.repository.ClientService;
import ru.hibernate.springhibernate.spring.repository.TransactionService;


import java.util.List;

@RestController
@RequestMapping(value = "/rest")
public class RestClient {

    @Autowired
    private ClientService clientService;

    @Autowired
    private BillService billService;

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/client/list")
    public List<ClientDTO> getList() {
    List<ClientDTO> clients = clientService.getAll();
        return clients;
    }

    @GetMapping("/{id}/bills")
    public List<BillDTO> getListBills(@PathVariable(name = "id") Integer id) {
        List<BillDTO> bills = billService.list(id);
        return bills;
    }

    @GetMapping("/bill/byClient")
    public List<BillDTO> getListBills2(@RequestParam("id") Integer id) {
        List<BillDTO> bills2 = billService.listid(id);
        return bills2;
    }

    @GetMapping("/transaction/byClient")
    public List<TransactionDTO> getListTransactions(@RequestParam("id") Integer id) {
        List<TransactionDTO> transactions = transactionService.transactionById(id);
        return transactions;
    }

    @PostMapping("/client/add")
    public ClientDTO create(@RequestBody Client client) {
        ClientDTO clientDTO = clientService.save(client);
        return clientDTO;
    }

    @PostMapping("/bill/add")
    public BillDTO create(@RequestBody Bill bill) {
        BillDTO billDTO = billService.saveById(bill);
        return billDTO;
    }

    @PostMapping("/transaction/add")
    public TransactionDTO create(@RequestBody Transaction transaction) {
        TransactionDTO transactionDTO = transactionService.saveById(transaction);
        return transactionDTO;
    }

    @RequestMapping(value = "/name", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getFirstName(){
        return clientService.getAll().get(0).getName();
    }
}
