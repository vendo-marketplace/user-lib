package com.vendo.dto;

import com.vendo.service.UserActivityView;
import com.vendo.type.UserStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserActivityViewImpl implements UserActivityView {

    private UserStatus userStatus;

    private Boolean emailVerified;

    @Override
    public UserStatus getStatus() {
        return userStatus;
    }

    @Override
    public Boolean getEmailVerified() {
        return emailVerified;
    }

}