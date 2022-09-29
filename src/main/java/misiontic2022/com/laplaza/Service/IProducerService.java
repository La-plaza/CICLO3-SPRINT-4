package misiontic2022.com.laplaza.Service;

import java.util.List;

import misiontic2022.com.laplaza.Entity.Producer;

public interface IProducerService {

    List<Producer> getAllProducer();

    List<Producer> getProducerByName(String name);

    List<Producer> getProducerByCelular(Integer celular);

    Producer saveProducer(Producer producer);

    Producer getProducerById(Long id);

    Producer updatProducer(Producer producer);

    void deleteProducerById(Long id);

    
    
}

