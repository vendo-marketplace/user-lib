package com.vendo.user_lib.service;

import com.vendo.user_lib.dto.UserActivityViewImpl;
import com.vendo.user_lib.exception.UserBlockedException;
import com.vendo.user_lib.exception.UserEmailNotVerifiedException;
import com.vendo.user_lib.exception.UserIsUnactiveException;
import com.vendo.user_lib.type.UserStatus;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class UserActivityPolicyTest {

    @Test
    public void testValidateActivity_shouldValidateUserActivity() {
        UserActivityView userActivityView = UserActivityViewImpl.builder()
                .userStatus(UserStatus.ACTIVE)
                .emailVerified(true)
                .build();

        UserActivityPolicy.validateActivity(userActivityView);
    }

    @Test
    public void testValidateActivity_shouldThrowException_whenUserBlocked() {
        UserActivityView userActivityView = UserActivityViewImpl.builder()
                .userStatus(UserStatus.BLOCKED)
                .emailVerified(true)
                .build();

        UserBlockedException exception = assertThrows(UserBlockedException.class, () -> UserActivityPolicy.validateActivity(userActivityView));
        assertEquals("User is blocked.", exception.getMessage());
    }

    @Test
    public void testValidateActivity_shouldThrowException_whenEmailNotVerified() {
        UserActivityView userActivityView = UserActivityViewImpl.builder()
                .userStatus(UserStatus.ACTIVE)
                .emailVerified(false)
                .build();

        UserEmailNotVerifiedException exception = assertThrows(UserEmailNotVerifiedException.class, () -> UserActivityPolicy.validateActivity(userActivityView));
        assertEquals("User email is not verified.", exception.getMessage());
    }

    @Test
    public void testValidateActivity_shouldThrowException_whenUserIsUnactive() {
        UserActivityView userActivityView = UserActivityViewImpl.builder()
                .userStatus(UserStatus.INCOMPLETE)
                .emailVerified(true)
                .build();

        UserIsUnactiveException exception = assertThrows(UserIsUnactiveException.class, () -> UserActivityPolicy.validateActivity(userActivityView));
        assertEquals("User is unactive.", exception.getMessage());
    }

    @Test
    public void testValidateActivity_shouldThrowUserBlockedExceptionFirst_whenStatusBlockedAndEmailNotVerified() {
        UserActivityView userActivityView = UserActivityViewImpl.builder()
                .userStatus(UserStatus.BLOCKED)
                .emailVerified(false)
                .build();

        UserBlockedException exception = assertThrows(UserBlockedException.class, () -> UserActivityPolicy.validateActivity(userActivityView));
        assertEquals("User is blocked.", exception.getMessage());
    }

    @Test
    public void testValidateActivity_shouldThrowUserEmailNotVerifiedFirst_whenStatusIncompleteAndEmailNotVerified() {
        UserActivityView userActivityView = UserActivityViewImpl.builder()
                .userStatus(UserStatus.INCOMPLETE)
                .emailVerified(false)
                .build();

        UserEmailNotVerifiedException exception = assertThrows(UserEmailNotVerifiedException.class, () -> UserActivityPolicy.validateActivity(userActivityView));
        assertEquals("User email is not verified.", exception.getMessage());
    }

    @Test
    public void testValidateActivity_shouldThrowException_whenUserStatusIsNotProvided() {
        UserActivityView userActivityView = UserActivityViewImpl.builder()
                .emailVerified(true)
                .build();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> UserActivityPolicy.validateActivity(userActivityView));
        assertEquals("UserStatus or EmailVerified fields must not be null.", exception.getMessage());
    }

    @Test
    public void testValidateActivity_shouldThrowException_whenEmailVerifiedIsNotProvided() {
        UserActivityView userActivityView = UserActivityViewImpl.builder()
                .userStatus(UserStatus.ACTIVE)
                .build();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> UserActivityPolicy.validateActivity(userActivityView));
        assertEquals("UserStatus or EmailVerified fields must not be null.", exception.getMessage());
    }
}