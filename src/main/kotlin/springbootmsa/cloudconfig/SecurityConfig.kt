package springbootmsa.cloudconfig

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig {

    @Bean
    fun securityFilterChain(http: HttpSecurity) // HttpSecurity 객체를 통해 보안 규칙을 설정
        : SecurityFilterChain { // SecurityFilterChain을 Bean으로 정의하여 Spring Security의 보안 설정을 적용

        http.authorizeHttpRequests { authz -> // authorizeHttpRequests 메서드를 사용하여 요청 권한을 설정
                // 모든 요청이 인증된 사용자만 접근 가능하도록 설정
                authz.anyRequest().authenticated()
            }
            // HTTP Basic 인증 방식을 활성화
            .httpBasic { basic ->
                // HTTP Basic 인증을 적용할 때의 Realm 이름을 "Config Server"로 설정
                basic.realmName("Config Server")
            }
        // 설정이 완료된 HttpSecurity 객체를 SecurityFilterChain으로 빌드하여 반환
        return http.build()
    }
}