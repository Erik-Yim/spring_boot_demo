package org.erik.spring.boot.demo.vo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Erik_Yim on 2017/5/2.
 */

//ConfigurationProperties这个加上去配置文件的前缀而已省略
@Component
@ConfigurationProperties(prefix = "people")
public class People {

    //age 可以是String或者数字都可以，属性文件不区分类型
    private String age; //和配置文件中属性名相同即可，就是prefix + fieldname

    private String name;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"age\":\"")
                .append(age).append('\"');
        sb.append(",\"name\":\"")
                .append(name).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
