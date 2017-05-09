package cn.itcast.zt.domain;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zhangtian on 2017/4/13.
 */
@CacheConfig(cacheNames = "users")
public interface UserRepository extends JpaRepository<User, Long> {
    @Cacheable(key = "#p0") //#p0表示第一个参数其实就是name
    User findByName(String name) ;

    @CachePut(key = "#p0.name")//也可以写成#user.name
    User save(User user);
}
