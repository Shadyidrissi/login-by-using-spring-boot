package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // تعريف Bean باستخدام @Bean
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // تكوين إعدادات الأمن
        http
                .csrf(csrf -> csrf.disable()) // تعطيل الحماية من CSRF أثناء التطوير فقط
                .authorizeHttpRequests(authz -> authz // استخدام authorizeHttpRequests بدلاً من authorizeRequests
                        .requestMatchers("/login").permitAll() // السماح لنقطة /login بالوصول دون توثيق
                        .anyRequest().authenticated()); // طلب التوثيق لأي طلب آخر

        return http.build(); // إرجاع الكائن المُكون
    }
}
