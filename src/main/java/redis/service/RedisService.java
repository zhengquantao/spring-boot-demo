package redis.service;

import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedisService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //封装  方法重载
    public void setString(String key, String value){
        this.setObject(key, value, null);
    }
    public void setString(String key, String value, Long time){
        this.setObject(key, value, time);
    }

    public void setList(String key, List<String> listValue){
        this.setObject(key, listValue, null);
    }

    public void setObject(String key, Object value, Long time){
        //redis 有几种string list set zset hash
        if (StringUtils.isEmptyOrWhitespaceOnly(key)|| value==null){
            return;
        }
        //判断类型 存放string类型
        if (value instanceof String){
            String strValue = (String) value;
            if (time != null){
                stringRedisTemplate.opsForValue().set(key, strValue, time);
            }else{
                stringRedisTemplate.opsForValue().set(key, strValue);
            }

            return;
        }
        //存放list 类型
        if (value instanceof List){
            List<String> listValue = (List<String>) value;
            for (String string: listValue){
                stringRedisTemplate.opsForList().leftPush(key, string);
            }
            return;
        }
    }

    public String getStringKey(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }
    //取值还不会
//    public List<String> getListKey(String key){
//        return stringRedisTemplate.opsForList();
//    }
}