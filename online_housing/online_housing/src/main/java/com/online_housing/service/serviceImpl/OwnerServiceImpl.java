package com.online_housing.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.online_housing.model.Owner;
import com.online_housing.repository.OwnerRepository;
import com.online_housing.service.OwnerService;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public Owner saveOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public Owner getOwnerByUsername(String username) {
        return ownerRepository.findByOwnerUserName(username);
    }
}
