package com.example.testsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    //password 해싱 암호화
    public BCryptPasswordEncoder bCryptPasswordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                //요청별 접근권한을 설정
                .authorizeHttpRequests((auth) -> auth
                        //권한 없이도 접근 가능
                        .requestMatchers("/", "/login","/join","/joinProc").permitAll()
                        //"ADMIN"role을 가지고 있는 사용자만 접근 가능
                        .requestMatchers("/admin").hasRole("ADMIN")
                        //"ADMIN","USER"같이 여러개의 권한을 설정가능
                        .requestMatchers("/my/**").hasAnyRole("ADMIN", "USER")
                        //나머지는 로그인 사용자만 접근 가능
                        .anyRequest().authenticated()
                );

        http
                .formLogin((auth)->auth.loginPage("/login")//사용자가 직접 접근하는 로그인 페이지
                        .loginProcessingUrl("/loginProc")//로그인 요청을 처리하는 엔드 포인트
                        .permitAll()
                );

        http
                .sessionManagement((auth) -> auth
                        //하나의 아이디에 대한 다중 로그인 허용 개수
                        .maximumSessions(1)
                        //다중 로그인 개수 초과하였을 경우 처리 방법
                        //true: 초과시 새로운 로그인 차단
                        //false: 초과시 기존 세션 하나 삭제
                        .maxSessionsPreventsLogin(true));


        //세션을 로그인시 마다 생성해서 미리 설정해놓은 세션 id로부터 보호하는 세션 고정 공격 보호 설정
        http
                .sessionManagement((auth) -> auth
                        .sessionFixation().changeSessionId());

        return http.build();

    }
}
