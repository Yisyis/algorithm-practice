package com.yis.freqLeet;

import java.util.LinkedHashMap;

/**
 * LRU缓存
 *
 * @author YeShuai
 * @date 2021/5/13
 * <p>
 * // LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * // int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * // void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
 * //限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 */
public class LRUCache {

    int capacity;
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        // 更新到近期使用
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            // 更新节点，加入到队尾
            cache.put(key, value);
            makeRecently(key);
            return;
        }
        if (capacity <= cache.size()) {
            // 删除表头 最久未使用的key
            int oldKey = cache.keySet().iterator().next();
            cache.remove(oldKey);
        }
        // 将新的key添加到队尾
        cache.put(key, value);
    }

    public void makeRecently(int key) {
        int val = cache.get(key);
        // 删除key，加入到队尾
        cache.remove(key);
        cache.put(key, val);
    }

}
