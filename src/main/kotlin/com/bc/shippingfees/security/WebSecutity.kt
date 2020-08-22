//package com.bc.shippingfees.security
//
//
//import org.springframework.context.annotation.Configuration
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity
//import org.springframework.security.provisioning.InMemoryUserDetailsManager
//import org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder
//import org.apache.tomcat.jni.User.username
//import org.springframework.context.annotation.Bean
//import org.springframework.security.core.userdetails.User
//import org.springframework.security.core.userdetails.UserDetails
//import org.springframework.security.core.userdetails.UserDetailsService
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.http.HttpMethod
//import org.springframework.security.authentication.AuthenticationManager
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
//import org.springframework.security.config.http.SessionCreationPolicy
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
//import org.springframework.security.crypto.password.NoOpPasswordEncoder
//import org.springframework.security.crypto.password.PasswordEncoder
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
//import javax.servlet.Filter
//
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(
//        // securedEnabled = true,
//        // jsr250Enabled = true,
//        prePostEnabled = true)
//class WebSecurityConfig : WebSecurityConfigurerAdapter() {
//
//
//    @Throws(Exception::class)
//    protected override fun configure(http: HttpSecurity) {
//        http.cors().and().csrf().disable()
//                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//                .authorizeRequests().antMatchers("/auth/**").permitAll()
//                .antMatchers("/server").permitAll()
//                .antMatchers(HttpMethod.POST, "/user-submit").permitAll()
//                .anyRequest().authenticated()
//
//        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter::class.java as Class<out Filter>?)
//    }
//}
