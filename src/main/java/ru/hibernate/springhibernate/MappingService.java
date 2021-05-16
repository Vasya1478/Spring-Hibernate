package ru.hibernate.springhibernate;

import lombok.AllArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.hibernate.springhibernate.dto.BillDTO;
import ru.hibernate.springhibernate.dto.ClientDTO;
import ru.hibernate.springhibernate.entity.Bill;
import ru.hibernate.springhibernate.entity.Client;
import ru.hibernate.springhibernate.spring.repository.BillRepository;
import ru.hibernate.springhibernate.spring.repository.ClientRepository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MappingService implements BaseMapping {
    private final ModelMapper modelMapper;
//    private final ClientRepository clientRepository;
    private final BillRepository billRepository;

//    @PostConstruct
//    public void init() {
//        Converter<Integer, List<BillDTO>> bill =
//                context -> mapList(billRepository.findAllByClientid(context.getSource()), BillDTO.class);
//
//        modelMapper.typeMap(Client.class, ClientDTO.class)
//                .addMappings(mapper -> mapper.using(bill).map(Client::getId, ClientDTO::setBills));
//
//    }

    public <S, D> D map(S source, Class<D> clazz) {
        return modelMapper.map(source, clazz);
    }

    public <S, D> void map(S source, D dest) {
        modelMapper.map(source, dest);
    }
    public <S, D> List<D> mapList(List<S> sources, Class<D> clazz) {
        return sources.stream()
                .map(s -> map(s, clazz))
                .collect(Collectors.toList());
    }
}
