package com.github.robertsawyer.ItApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private DataSource dataSource;

    public SecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)                                      //z czm ma sie jdbc łączyć, żeby się połączyć - w pliku properties
                .passwordEncoder(passwordEncoder())                          //bo chcmy szyfrowac hasło
                .usersByUsernameQuery("SELECT login, password, true FROM users WHERE login = ?")              //sluzy do procesu logowania
                .authoritiesByUsernameQuery("SELECT login, 'ROLE_USER' FROM users WHERE login = ?");  //będzie zwracało info o tym, jakie prawa ma user
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/register").permitAll()               //dostep dla wszystkich
                .antMatchers("/login").anonymous()               // dostęp tylko dla niezalogowanych
                .antMatchers("/user", "/user/**").hasRole("USER")           //dostęp do tych scieżek tylko dla userów
                .antMatchers("/admin", "/admin/**").hasRole("ADMIN")     //tylko dla adminów
                .antMatchers("/media/**").permitAll()               //dopuszcza do katalogu ze stylami
                .anyRequest().authenticated()                               //to jest jak blok try catch, gdzie obsługujemy wyjątki od ogółu do szczegółu
                .and()
            .formLogin()                            //konfiguracja formularza logowania
                .loginPage("/login")                 //na jaką stronę trzeba wejśc, żęby się zalogowac
                .usernameParameter("login")
                .passwordParameter("password")
                .defaultSuccessUrl("/")          //jeśli zaloguje sie poprawnie to kieruje go na te strone
                .and()
            .logout()
                .logoutUrl("/logout")                   //
                .logoutSuccessUrl("/login?logout")
                .and()
            .csrf()
                .disable()                              //wyłącza wylogowanie przez link - tylko przez formularz
            .rememberMe()                               //nie wiem co to robi :(((
                .key("mójKlucz")                        //klucz do odszyfrowania ciastka, które posiada user po zapamiętaniu przy logowaniu
                .rememberMeParameter("remember-me")        //w formularzy logowaniu jest checkbox i ma name i ustawiamy parametr pola rememberMe
                .tokenValiditySeconds(7*24*60);          //ustawiamy termin ważności remember me czyli to samo co max age


    }
}
