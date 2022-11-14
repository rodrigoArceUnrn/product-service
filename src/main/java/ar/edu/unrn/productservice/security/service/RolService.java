package ar.edu.unrn.productservice.security.service;

import ar.edu.unrn.productservice.security.entity.Role;
import ar.edu.unrn.productservice.security.enums.RolName;
import ar.edu.unrn.productservice.security.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public Optional<Role> getByName(RolName rolName){
        return rolRepository.findByName(rolName);
    }

    public void save(Role role){
        rolRepository.save(role);
    }
}
