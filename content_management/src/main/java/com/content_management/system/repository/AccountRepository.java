package com.content_management.system.repository;

import org.apache.ibatis.annotations.Mapper;
import com.content_management.system.model.AccountModel;

@Mapper
public interface AccountRepository {
    AccountModel loginProcess(String username);
}
