package com.vendo.user_lib.model;

import com.vendo.user_lib.type.UserRole;
import com.vendo.user_lib.type.UserStatus;

import java.util.Set;
import java.util.stream.Collectors;

public record User(
        String id,
        String email,
        UserStatus status,
        Set<UserRole> roles,
        boolean emailVerified
) {

    public Set<String> toRoleNames() {
        return roles.stream()
                .map(Enum::name)
                .collect(Collectors.toSet());
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String email;
        private UserStatus status;
        private Set<UserRole> roles;
        private boolean emailVerified;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder status(UserStatus status) {
            this.status = status;
            return this;
        }

        public Builder roles(Set<UserRole> roles) {
            this.roles = roles;
            return this;
        }

        public Builder emailVerified(boolean emailVerified) {
            this.emailVerified = emailVerified;
            return this;
        }

        public User build() {
            return new User(id, email, status, roles, emailVerified);
        }
    }

}