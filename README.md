# user-lib

## Overview
`user-lib` is a shared library for the Vendo ecosystem that provides common user-domain building blocks used across microservices. It centralizes user-related exceptions, status enums, role enums, and provider type enums, ensuring consistent user domain handling across the platform.

## Features

* Exceptions dedicated to user-related error scenarios (e.g. user not found, user already exists, invalid user state)
* Enums for user statuses (e.g. active, blocked, pending)
* Enums for user roles used across services for authorization purposes
* Enums for provider types (e.g. local, Google) for authentication provider handling
* Easy integration into any module of the Vendo ecosystem via a Maven dependency

## Installation
Add the dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>io.github.vendo-marketplace-be</groupId>
    <artifactId>user-lib</artifactId>
    <version>latest-version</version>
    <packaging>jar</packaging>
</dependency>
```

## Usage
Once the dependency is added, the exceptions, enums, and related classes from `user-lib` become available for direct import in any module of the project.

Example:

```java
import com.vendo.user_lib.exception.UserNotFoundException;
import com.vendo.user_lib.type.UserStatus;
import com.vendo.user_lib.type.UserRole;
import com.vendo.user_lib.type.ProviderType;

// Example usage
if (user.getStatus() == UserStatus.BLOCKED) {
    throw new UserNotFoundException("User not found.");
}

boolean isAdmin = user.getRoles().contains(UserRole.ADMIN);
boolean isGoogleUser = user.getProviderType() == ProviderType.GOOGLE;
```

## Requirements

* Java 17

## Notes
This library is intended solely for internal use within the Vendo ecosystem (`com.vendo`). It focuses exclusively on user-domain cross-cutting concerns (exceptions, statuses, roles, provider types) and should not contain service-specific business logic.