package edu.hunau.repository.Impl;

import edu.hunau.repository.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * RedisRepository实现类
 *
 * @author ND_LJQ
 * @date 2023/05/13
 */

@Component
public class RedisRepositoryImpl implements RedisRepository {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean addExpirationTime(String key, long time) {
        Boolean isExpired = redisTemplate.expire(key, time, TimeUnit.SECONDS);
        return isExpired != null && isExpired;
    }

    @Override
    public long getExpirationTime(String key) {
        return redisTemplate.getExpire(key);
    }

    @Override
    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    @Override
    public boolean removeExpirationTime(String key) {
        Boolean result = redisTemplate.boundValueOps(key).persist();
        return result!=null&&result;
    }

    @Override
    public Object getStringValue(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    @Override
    public void setStringKey(String key, String value) {
       redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public void setStringKey(String key, String value, long time) {
        if (time > 0) {
            redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
        } else {
            redisTemplate.opsForValue().set(key, value);
        }
    }

    @Override
    public void batchSetStringKey(Map<String, String> keyAndValue) {
        redisTemplate.opsForValue().multiSet(keyAndValue);
    }

    @Override
    public void batchSetStringKeyIfAbsent(Map<String, String> keyAndValue) {
        redisTemplate.opsForValue().multiSet(keyAndValue);
    }

    @Override
    public Long increment(String key, long number) {
        return redisTemplate.opsForValue().increment(key, number);
    }

    @Override
    public Double increment(String key, double number) {
        return redisTemplate.opsForValue().increment(key, number);
    }

    @Override
    public void setSetKey(String key, String value) {
        redisTemplate.opsForSet().add(key, value);
    }

    @Override
    public Set<Object> getSetMembers(String key) {
        return redisTemplate.opsForSet().members(key);
    }

    @Override
    public void getSetRandomMembers(String key, long count) {
        redisTemplate.opsForSet().randomMembers(key, count);
    }

    @Override
    public Object getSetRandomMembers(String key) {
        return redisTemplate.opsForSet().randomMember(key);
    }

    @Override
    public Object pop(String key) {
        return redisTemplate.opsForSet().pop(key);
    }

    @Override
    public long size(String key) {
        return redisTemplate.opsForSet().size(key);
    }

    @Override
    public boolean checkSetHasKey(String key, Object value) {
        return redisTemplate.opsForSet().isMember(key, value);
    }

    @Override
    public boolean isMember(String key, Object obj) {
        return redisTemplate.opsForSet().isMember(key, obj);
    }

    @Override
    public boolean move(String key, String value, String destKey) {
        return redisTemplate.opsForSet().move(key, value, destKey);
    }

    @Override
    public void remove(String key, Object... values) {
        redisTemplate.opsForSet().remove(key, values);
    }

    @Override
    public Set<Set> difference(String key, String destKey) {
        return redisTemplate.opsForSet().difference(key, destKey);
    }

    @Override
    public void add(String key, Map<String, String> map) {
        redisTemplate.opsForHash().putAll(key, map);
    }

    @Override
    public Map<Object, Object> getHashEntries(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    @Override
    public boolean hashKey(String key, String hashKey) {
        return redisTemplate.opsForHash().hasKey(key, hashKey);
    }

    @Override
    public String getMapString(String key, String key2) {
        return redisTemplate.opsForHash().get(key, key2).toString();
    }

    @Override
    public Integer getMapInt(String key, String key2) {
        return (Integer) redisTemplate.opsForHash().get(key, key2);
    }

    @Override
    public String popValue(String key) {
        return redisTemplate.opsForSet().pop(key).toString();
    }

    @Override
    public Long delete(String key, String... hashKeys) {
        return redisTemplate.opsForHash().delete(key, hashKeys);
    }

    @Override
    public Long increment(String key, String hashKey, long number) {
        return redisTemplate.opsForHash().increment(key, hashKey, number);
    }

    @Override
    public Double increment(String key, String hashKey, Double number) {
        return redisTemplate.opsForHash().increment(key, hashKey, number);
    }

    @Override
    public Set<Object> hashKeys(String key) {
        return redisTemplate.opsForHash().keys(key);
    }

    @Override
    public Long hashSize(String key) {
        return redisTemplate.opsForHash().size(key);
    }

    @Override
    public void leftPush(String key, Object value) {
        redisTemplate.opsForList().leftPush(key, value);
    }

    @Override
    public Object index(String key, long index) {
        return redisTemplate.opsForList().index(key, index);
    }

    @Override
    public List<Object> range(String key, long start, long end) {
        return redisTemplate.opsForList().range(key, start, end);
    }

    @Override
    public void leftPush(String key, String pivot, String value) {
        redisTemplate.opsForList().leftPush(key, pivot, value);
    }

    @Override
    public void leftPushAll(String key, String... values) {
        redisTemplate.opsForList().leftPushAll(key, values);
    }

    @Override
    public void leftPushAll(String key, String value) {
        redisTemplate.opsForList().rightPush(key, value);
    }

    @Override
    public void rightPushAll(String key, String... values) {
        redisTemplate.opsForList().rightPushAll(key, values);
    }

    @Override
    public void rightPushIfPresent(String key, Object value) {
        redisTemplate.opsForList().rightPushIfPresent(key, value);
    }

    @Override
    public long listLength(String key) {
        return redisTemplate.opsForList().size(key);
    }

    @Override
    public void leftPop(String key) {
        redisTemplate.opsForList().leftPop(key);
    }

    @Override
    public void leftPop(String key, long timeout, TimeUnit unit) {
        redisTemplate.opsForList().leftPop(key, timeout, unit);
    }

    @Override
    public void rightPop(String key) {
        redisTemplate.opsForList().rightPop(key);
    }

    @Override
    public void rightPop(String key, long timeout, TimeUnit unit) {

    }
}
