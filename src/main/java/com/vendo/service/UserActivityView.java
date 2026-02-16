package com.vendo.service;


import com.vendo.type.UserStatus;

public interface UserActivityView {

    UserStatus getStatus();

    Boolean getEmailVerified();

}
