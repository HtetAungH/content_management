package com.content_management.system.model;

import lombok.Getter;
import lombok.Setter;

public class AccountModel {
    @Getter 
    @Setter
    private String username;

    @Getter 
    @Setter
    private String password;

    @Getter 
    @Setter
    private boolean enabled;

    @Getter 
    @Setter
    private String authority;
}
