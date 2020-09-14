package com.joroovb.digitaalvaccinatie.contoller;

import com.joroovb.digitaalvaccinatie.model.Transponder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TransponderService {

    @Autowired
    TransponderRepository transponderRepository;

    public Transponder getTransponder(long id) {
        return transponderRepository.getOne(id);
    }

    public Transponder newTransponder(Transponder transponder) {
        return transponderRepository.save(transponder);
    }

    public void deleteTransponder(long id) {
        transponderRepository.deleteById(id);
    }
}
