package com.online_housing.service.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.online_housing.model.Housing;
import com.online_housing.model.Owner;
import com.online_housing.repository.HousingRepository;
import com.online_housing.repository.OwnerRepository;
import com.online_housing.service.HousingService;

@Service
public class HousingServiceImpl implements HousingService {

    @Autowired
    private HousingRepository housingRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public Housing saveHousing(Housing housing) {
        return housingRepository.save(housing);
    }

    @Override
    public List<Housing> getHousingsByOwner(Long ownerId) {
        Owner owner = ownerRepository.findById(ownerId).orElse(null);
        return housingRepository.findByOwner(owner);
    }
}
