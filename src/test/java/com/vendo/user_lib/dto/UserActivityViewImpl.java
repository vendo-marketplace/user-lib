package com.vendo.user_lib.dto;

import com.vendo.user_lib.service.UserActivityView;
import com.vendo.user_lib.type.UserStatus;
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