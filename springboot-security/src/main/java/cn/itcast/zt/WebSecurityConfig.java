package cn.itcast.zt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by zhangtian on 2017/4/13.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{


//                   ANT通配符有三种：
//
//                   通配符	说明
//               ?	匹配任何单字符
//               *	匹配0或者任意数量的字符
//               **	匹配0或者更多的目录
//                   例子：
//
//                   URL路径	说明
//               /app/*.x	匹配(Matches)所有在app路径下的.x文件
//               /app/p?ttern	匹配(Matches) /app/pattern 和 /app/pXttern,但是不包括/app/pttern
//               /**/example	匹配(Matches) /app/example, /app/foo/example, 和 /example
//               /app/**/dir/file.*	匹配(Matches) /app/dir/file.jsp, /app/foo/dir/file.html,/app/foo/bar/dir/file.pdf, 和 /app/dir/file.java
//               /**/*.jsp	匹配(Matches)任何的.jsp 文件


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//                .antMatchers("/", "/home","/js/**").permitAll()
                .antMatchers("/", "/home","/**/*.js").permitAll() //允许所有人都可以访问的路径
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .inMemoryAuthentication()
                .withUser("user")
                .password("11111")
                .roles("USER") ;
    }
}
