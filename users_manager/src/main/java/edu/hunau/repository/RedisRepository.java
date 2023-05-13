package edu.hunau.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Redis操作层
 *
 * @author ND_LJQ
 * @date 2023/05/13
 */
public interface RedisRepository {
    /**
     * 给一个指定的key添加过期事件
     *
     * @param key  键
     * @param time 时间
     * @return boolean
     */
    public boolean addExpirationTime(String key, long time);

    /**
     * 获取指定key的过期时间
     *
     * @param key 键
     * @return long
     */
    public long getExpirationTime(String key);

    /**
     * 根据key 获取过期时间
     *
     * @param key 关键
     * @return boolean
     */
    public boolean hasKey(String key);

    /**
     * 移除指定key的过期时间
     *
     * @param key 关键
     * @return boolean
     */
    public boolean removeExpirationTime(String key);

    //- - - - - - - - - - - - - - - - - - - - -  String类型 - - - - - - - - - - - - - - - - - - - -

    /**
     * 得到String类型的key的值
     *
     * @param key 关键
     * @return {@link Object}
     */
    public Object getStringValue(String key);

    /**
     * 设置字符串键
     *
     * @param key   关键
     * @param value 价值
     */
    public void setStringKey(String key, String value);


    /**
     * 设置字符串键
     *
     * @param key   关键
     * @param value 价值
     * @param time  时间
     */
    public void setStringKey(String key, String value, long time);


    /**
     * 批处理设置
     *
     * @param keyAndValue 键和值
     */
    public void batchSetStringKey(Map<String, String> keyAndValue);


    /**
     * 批量添加 key-value 只有在键不存在时,才添加
     * map 中只要有一个key存在,则全部不添加
     *
     * @param keyAndValue 键和值
     */
    public void batchSetStringKeyIfAbsent(Map<String, String> keyAndValue);


    /**
     * 对一个 key-value 的值进行加减操作,
     * 如果该 key 不存在 将创建一个key 并赋值该 number
     * 如果 key 存在,但 value 不是长整型 ,将报错
     *
     * @param key    关键
     * @param number 数量
     * @return {@link Long}
     */
    public Long increment(String key, long number);


    /**
     * 对一个 key-value 的值进行加减操作,
     * 如果该 key 不存在 将创建一个key 并赋值该 number
     * 如果 key 存在,但 value 不是长整型 ,将报错
     *
     * @param key    关键
     * @param number 数量
     * @return {@link Double}
     */
    public Double increment(String key, double number);


    //- - - - - - - - - - - - - - - - - - - - -  set类型 - - - - - - - - - - - - - - - - - - - -

    /**
     * 设置set类型的键
     *
     * @param key   关键
     * @param value 价值
     */
    public void setSetKey(String key, String value);


    /**
     * 获取变量中的值
     *
     * @param key 关键
     * @return {@link Set}<{@link Object}>
     */
    public Set<Object> getSetMembers(String key);

    /**
     * 得到指定数目的Set随机成员
     *
     * @param key   关键
     * @param count 数
     */
    public void getSetRandomMembers(String key, long count);

    /**
     * 得到Set随机成员
     *
     * @param key 关键
     * @return {@link Object}
     */
    public Object getSetRandomMembers(String key);


    /**
     * 弹出变量中的元素
     *
     * @param key 关键
     * @return {@link Object}
     */
    public Object pop(String key);

    /**
     * 获取变量中值的长度
     *
     * @param key 关键
     * @return long
     */
    public long size(String key);

    /**
     * 根据value从一个set中查询,是否存在
     *
     * @param key   关键
     * @param value 价值
     * @return boolean
     */
    public boolean checkSetHasKey(String key, Object value);


    /**
     * 检查给定的元素是否在变量中。
     *
     * @param key 关键
     * @param obj obj
     * @return boolean
     */
    public boolean isMember(String key, Object obj);


    /**
     * 转移变量的元素值到目的变量。
     *
     * @param key     关键
     * @param value   价值
     * @param destKey 关键不在座位上
     * @return boolean
     */
    public boolean move(String key, String value, String destKey);

    /**
     * 批量移除set缓存中元素
     *
     * @param key    关键
     * @param values 值
     */
    public void remove(String key, Object... values);


    /**
     * 通过给定的key求2个set变量的差值
     *
     * @param key     关键
     * @param destKey 关键不在座位上
     * @return {@link Set}<{@link Set}>
     */
    public Set<Set> difference(String key, String destKey);

    //- - - - - - - - - - - - - - - - - - - - -  hash类型 - - - - - - - - - - - - - - - - - - - -

    /**
     * 加入缓存
     *
     * @param key 键
     * @param map 键
     * @return
     */
    public void add(String key, Map<String, String> map);

    /**
     * 获取 key 下的 所有  hashkey 和 value
     *
     * @param key 键
     * @return
     */
    public Map<Object, Object> getHashEntries(String key);

    /**
     * 验证指定 key 下 有没有指定的 hashkey
     *
     * @param key
     * @param hashKey
     * @return
     */
    public boolean hashKey(String key, String hashKey);

    /**
     * 获取指定key的值string
     *
     * @param key  键
     * @param key2 键
     * @return
     */
    public String getMapString(String key, String key2);

    /**
     * 获取指定的值Int
     *
     * @param key  键
     * @param key2 键
     * @return
     */
    public Integer getMapInt(String key, String key2);

    /**
     * 弹出元素并删除
     *
     * @param key 键
     * @return
     */
    public String popValue(String key);

    /**
     * 删除指定 hash 的 HashKey
     *
     * @param key
     * @param hashKeys
     * @return 删除成功的 数量
     */
    public Long delete(String key, String... hashKeys);

    /**
     * 给指定 hash 的 hashkey 做增减操作
     *
     * @param key
     * @param hashKey
     * @param number
     * @return
     */
    public Long increment(String key, String hashKey, long number);

    /**
     * 给指定 hash 的 hashkey 做增减操作
     *
     * @param key
     * @param hashKey
     * @param number
     * @return
     */
    public Double increment(String key, String hashKey, Double number);

    /**
     * 获取 key 下的 所有 hashkey 字段
     *
     * @param key
     * @return
     */
    public Set<Object> hashKeys(String key);

    /**
     * 获取指定 hash 下面的 键值对 数量
     *
     * @param key
     * @return
     */
    public Long hashSize(String key);

    //- - - - - - - - - - - - - - - - - - - - -  list类型 - - - - - - - - - - - - - - - - - - - -

    /**
     * 在变量左边添加元素值
     *
     * @param key
     * @param value
     * @return
     */
    public void leftPush(String key, Object value);

    /**
     * 获取集合指定位置的值。
     *
     * @param key
     * @param index
     * @return
     */
    public Object index(String key, long index);

    /**
     * 获取指定区间的值。
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public List<Object> range(String key, long start, long end);

    /**
     * 把最后一个参数值放到指定集合的第一个出现中间参数的前面，
     * 如果中间参数值存在的话。
     *
     * @param key
     * @param pivot
     * @param value
     * @return
     */
    public void leftPush(String key, String pivot, String value);

    /**
     * 向左边批量添加参数元素。
     *
     * @param key
     * @param values
     * @return
     */
    public void leftPushAll(String key, String... values);

    /**
     * 向集合最右边添加元素。
     *
     * @param key
     * @param value
     * @return
     */
    public void leftPushAll(String key, String value);

    /**
     * 向左边批量添加参数元素。
     *
     * @param key
     * @param values
     * @return
     */
    public void rightPushAll(String key, String... values);

    /**
     * 向已存在的集合中添加元素。
     *
     * @param key
     * @param value
     * @return
     */
    public void rightPushIfPresent(String key, Object value);

    /**
     * 向已存在的集合中添加元素。
     *
     * @param key
     * @return
     */
    public long listLength(String key);

    /**
     * 移除集合中的左边第一个元素。
     *
     * @param key
     * @return
     */
    public void leftPop(String key);

    /**
     * 移除集合中左边的元素在等待的时间里，如果超过等待的时间仍没有元素则退出。
     *
     * @param key
     * @return
     */
    public void leftPop(String key, long timeout, TimeUnit unit);

    /**
     * 移除集合中右边的元素。
     *
     * @param key
     * @return
     */
    public void rightPop(String key);

    /**
     * 移除集合中右边的元素在等待的时间里，如果超过等待的时间仍没有元素则退出。
     *
     * @param key
     * @return
     */
    public void rightPop(String key, long timeout, TimeUnit unit);

}
