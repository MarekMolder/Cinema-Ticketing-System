package com.cinema.Cinema_Ticketing.util;

import org.springframework.security.oauth2.jwt.Jwt;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class JwtHelper {

    private JwtHelper() {
    }

    public static UUID parseUserId(Jwt jwt) {
        return UUID.fromString(jwt.getSubject());
    }

    @SuppressWarnings("unchecked")
    public static boolean hasRole(Jwt jwt, String role) {
        Object realmAccess = jwt.getClaim("realm_access");
        if (realmAccess instanceof Map) {
            Object roles = ((Map<?, ?>) realmAccess).get("roles");
            if (roles instanceof List) {
                return ((List<?>) roles).contains(role);
            }
        }
        return false;
    }
}
