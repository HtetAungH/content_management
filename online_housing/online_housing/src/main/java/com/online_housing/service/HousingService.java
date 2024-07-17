package com.online_housing.service;

import java.util.List;
import com.online_housing.model.Housing;

public interface HousingService {
    Housing saveHousing(Housing housing);
    List<Housing> getHousingsByOwner(Long ownerId);
}
