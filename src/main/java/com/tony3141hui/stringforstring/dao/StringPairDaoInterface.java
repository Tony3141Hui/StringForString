package com.tony3141hui.stringforstring.dao;

import com.tony3141hui.stringforstring.pojo.StringPair;

public interface StringPairDaoInterface {

    void post(String key, String value);

    void put(String key, String value);

    String get(String key);

    void remove(String key);

    boolean containsKey(String key);

}
