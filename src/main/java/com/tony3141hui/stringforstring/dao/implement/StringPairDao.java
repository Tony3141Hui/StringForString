package com.tony3141hui.stringforstring.dao.implement;

import com.tony3141hui.stringforstring.dao.StringPairDaoInterface;
import com.tony3141hui.stringforstring.pojo.StringPair;
import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.impl.SimpleDataSource;

public class StringPairDao implements StringPairDaoInterface {

    private SimpleDataSource dataSource;
    private Dao dao;

    public StringPairDao() {

        dataSource = new SimpleDataSource();

        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/string_for_string");
        dataSource.setUsername("root");
        dataSource.setPassword("abc248abc248");

        dao = new NutDao(dataSource);

        dao.create(StringPair.class, true);

        dao.insert(new StringPair("hello", "Hello Nutz!"));
        dao.insert(new StringPair("test", "testvalue"));

    }

    public void post(String key, String value) {

        dao.insert(new StringPair(key, value));

    }

    public void put(String key, String value) {

        dao.update(new StringPair(key, value));

    }



    public String get(String key) {

        return dao.fetch(StringPair.class, key).getString_pair_value();

    }

    public void remove(String key) {

        dao.delete(StringPair.class, key);

    }

    public boolean containsKey(String key) {

        return dao.fetch(StringPair.class, key) != null;

    }

}
