package org.example;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import java.security.Key;
import java.util.Date;

public class TokenUtils {

    // Тот же ключ, который использовался при генерации токена
    private static final Key SECRET_KEY = LdapAuth.SECRET_KEY;

    public static boolean isValid(String token) {
        try {
            Jws<Claims> jws = Jwts.parserBuilder()
                    .setSigningKey(SECRET_KEY)
                    .build()
                    .parseClaimsJws(token);

            Claims claims = jws.getBody();

            Date now = new Date();
            Date expiration = claims.getExpiration();

            if (expiration != null && expiration.before(now)) {
                System.out.println("❌ Токен просрочен (exp: " + expiration + ")");
                return false;
            }

            System.out.println("✅ Токен валиден по времени");
            System.out.println("Пользователь (sub): " + claims.getSubject());
            System.out.println("DN: " + claims.get("dn"));
            System.out.println("Выдан: " + claims.getIssuedAt());
            System.out.println("Истекает: " + expiration);

            return true;

        } catch (Exception e) {
            System.out.println("❌ Ошибка при проверке токена: " + e.getMessage());
            return false;
        }
    }
}

