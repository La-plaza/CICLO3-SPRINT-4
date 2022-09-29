package misiontic2022.com.laplaza.Service;

import java.util.List;

import misiontic2022.com.laplaza.Entity.Producer;
import misiontic2022.com.laplaza.Repository.IProducerRepository;

public class ProducerService implements IProducerService{

    private IProducerRepository producerRepository;

    public ProducerService(IProducerRepository producerRepository){
        this.producerRepository = producerRepository;
    }

    @Override
    public List<Producer> getAllProducer() {
        return producerRepository.findAll();
    }

    @Override
    public List<Producer> getProducerByName(String name) {

        return producerRepository.findByNameContaining(name);
    }

    @Override
    public List<Producer> getProducerByCelular(Integer celular) {
        return producerRepository.findByCelular(celular);
    }

    @Override
    public Producer saveProducer(Producer producer) {

        return producerRepository.save(producer);
    }

    @Override
    public Producer getProducerById(Long id) {
        return producerRepository.findById(id).get();
    }

    @Override
    public Producer updatProducer(Producer producer) {
        return producerRepository.save(producer);
    }

    @Override
    public void deleteProducerById(Long id) {
        producerRepository.deleteById(id);
        
    }
    
}


