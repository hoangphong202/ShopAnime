package com.example.ShopAnime.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JWTUtils {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expirationMs}")
    private long expirationMs;

    // Tạo key từ chuỗi bí mật
    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    // 🔹 Tạo JWT từ username
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username) // gắn username vào token
                .setIssuedAt(new Date()) // thời gian tạo token
                .setExpiration(new Date(System.currentTimeMillis() + expirationMs)) // thời gian hết hạn
                .signWith(getSigningKey(), SignatureAlgorithm.HS256) // ký bằng thuật toán HS256
                .compact(); // gộp lại thành chuỗi JWT
    }

    // 🔹 Trích xuất username từ token
    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token) // giải mã token
                .getBody()
                .getSubject(); // lấy username
    }

    // 🔹 Kiểm tra token có hợp lệ không
    public boolean validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token);

            // Kiểm tra token hết hạn chưa
            Date expiration = claims.getBody().getExpiration();
            return !expiration.before(new Date());

        } catch (ExpiredJwtException e) {
            System.out.println("❌ Token đã hết hạn!");
        } catch (UnsupportedJwtException e) {
            System.out.println("❌ Token không được hỗ trợ!");
        } catch (MalformedJwtException e) {
            System.out.println("❌ Token bị sai cấu trúc!");
        } catch (SecurityException e) {
            System.out.println("❌ Chữ ký token không hợp lệ!");
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Token rỗng hoặc lỗi khác!");
        }
        return false;
    }
}
