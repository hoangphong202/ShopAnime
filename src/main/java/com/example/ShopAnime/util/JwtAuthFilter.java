package com.example.ShopAnime.util;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    @Autowired
    private JWTUtils jwtUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        // 🔹 Lấy header Authorization từ request
        String authHeader = request.getHeader("Authorization");

        // 🔹 Nếu header tồn tại và bắt đầu bằng "Bearer "
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7); // cắt "Bearer " để lấy token

            // 🔹 Kiểm tra token hợp lệ
            if (jwtUtils.validateToken(token)) {
                // 🔹 Lấy username từ token
                String username = jwtUtils.extractUsername(token);

                // 🔹 Tạo đối tượng user giả (vì chưa có database ở đây)
                User user = new User(username, "", Collections.emptyList());

                // 🔹 Tạo Authentication để Spring Security hiểu là user đã đăng nhập
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

                // 🔹 Lưu vào SecurityContext để các phần khác (controller) biết user này
                SecurityContextHolder.getContext().setAuthentication(authToken);
            } else {
                // 🔹 Token không hợp lệ hoặc hết hạn → trả lỗi 401
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("❌ Invalid or expired JWT token");
                return;
            }
        }

        // 🔹 Cho phép request đi tiếp nếu hợp lệ hoặc không cần token
        filterChain.doFilter(request, response);
    }
}
