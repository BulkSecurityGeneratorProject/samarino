package br.com.samarino.service;

import br.com.samarino.domain.Cliente;
import br.com.samarino.repository.ClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing Cliente.
 */
@Service
@Transactional
public class ClienteService {

    private final Logger log = LoggerFactory.getLogger(ClienteService.class);

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    /**
     * Save a cliente.
     *
     * @param cliente the entity to save
     * @return the persisted entity
     */
    public Cliente save(Cliente cliente) {
        log.debug("Request to save Cliente : {}", cliente);
        return clienteRepository.save(cliente);
    }

    /**
     * Get all the clientes.
     *
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        log.debug("Request to get all Clientes");
        return clienteRepository.findAllWithEagerRelationships();
    }

    /**
     * Get all the Cliente with eager load of many-to-many relationships.
     *
     * @return the list of entities
     */
    public Page<Cliente> findAllWithEagerRelationships(Pageable pageable) {
        return clienteRepository.findAllWithEagerRelationships(pageable);
    }
    

    /**
     * Get one cliente by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<Cliente> findOne(Long id) {
        log.debug("Request to get Cliente : {}", id);
        return clienteRepository.findOneWithEagerRelationships(id);
    }

    /**
     * Delete the cliente by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Cliente : {}", id);
        clienteRepository.deleteById(id);
    }
}
