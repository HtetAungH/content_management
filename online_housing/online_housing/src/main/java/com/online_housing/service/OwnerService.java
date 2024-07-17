package com.online_housing.service;

import com.online_housing.model.Owner;

public interface OwnerService {
    Owner saveOwner(Owner owner);
    Owner getOwnerByUsername(String username);
}
