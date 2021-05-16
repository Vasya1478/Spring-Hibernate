package ru.hibernate.springhibernate.spring.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.hibernate.springhibernate.MappingService;
import ru.hibernate.springhibernate.dao.ClientDao;
import ru.hibernate.springhibernate.dto.ClientDTO;
import ru.hibernate.springhibernate.entity.Client;

import java.util.List;

@Service
@Transactional
public class ClientService implements ClientDao {
    private MappingService mappingService;

    @Autowired
    private ClientRepository clientRepository;

    public ClientService(MappingService mappingService) {
        this.mappingService = mappingService;
    }


    @Override
    public ClientDTO save(Client client) {
        Client newClient = clientRepository.save(client);
        ClientDTO clientDTO = mappingService.map(newClient, ClientDTO.class);
        return clientDTO;
    }

    @Override
    public List<ClientDTO> getAll() {
        List<Client> clients = clientRepository.findAll();
        List<ClientDTO> list = mappingService.mapList(clients, ClientDTO.class);
        return list;
    }

}
