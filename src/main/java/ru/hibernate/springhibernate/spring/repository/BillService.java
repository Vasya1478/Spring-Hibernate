package ru.hibernate.springhibernate.spring.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.hibernate.springhibernate.MappingService;
import ru.hibernate.springhibernate.dao.BillDAO;
import ru.hibernate.springhibernate.dao.ClientDao;
import ru.hibernate.springhibernate.dto.BillDTO;
import ru.hibernate.springhibernate.dto.ClientDTO;
import ru.hibernate.springhibernate.entity.Bill;
import ru.hibernate.springhibernate.entity.Client;

import java.util.List;

@Service
@Transactional
public class BillService implements BillDAO {
    private MappingService mappingService;

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private ClientRepository clientRepository;

    public BillService(MappingService mappingService) {
        this.mappingService = mappingService;
    }



    public List<BillDTO> list(Integer id) {
        List<Bill> bills = billRepository.findAllByClientid(id);
        List<BillDTO> list = mappingService.mapList(bills, BillDTO.class);
        return list;
    }

    public List<BillDTO> listid(Integer id) {
        List<Bill> bills1 = billRepository.hg(id);
        List<BillDTO> list1 = mappingService.mapList(bills1, BillDTO.class);
        return list1;
    }

    @Override
    public BillDTO saveById(Bill bill) {
        Bill newBill = new Bill(bill.getId(), bill.getUid(),
                clientRepository.findById(bill.getClientid2()).get(),bill.getTotal());
        Bill saveBill = billRepository.save(newBill);
        BillDTO billDTO = mappingService.map(saveBill, BillDTO.class);
        return billDTO;
    }

    @Override
    public List<BillDTO> getAll() {
        List<Bill> bills = billRepository.findAll();
        List<BillDTO> list = mappingService.mapList(bills, BillDTO.class);
        return list;
    }

    @Override
    public BillDTO save(Bill dest) {
        return null;
    }
}
