package ksp.borealis.authservice.config.security;

import lombok.NoArgsConstructor;

import static javax.management.timer.Timer.ONE_DAY;

@NoArgsConstructor
public class SecurityConstants {

    public static final String SECRET = "ParitexAlwaysWins";

    public static final long JWT_EXPIRATION_TIME = 180 * ONE_DAY;
    public static final long EXPIRATION_TIME = ONE_DAY; // 300000 5 minutes // 864000000 // 10 days
    public static final long EXPIRATION_TIME_WEB = 15 * ONE_DAY;
    public static final long EXPIRATION_TIME_MOBILE_WEB = 15 * ONE_DAY;
    public static final long EXPIRATION_TIME_MOBILE_BOT = 90 * ONE_DAY;
    public static final long EXPIRATION_TIME_MOBILE_APP = 90 * ONE_DAY;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";

}
