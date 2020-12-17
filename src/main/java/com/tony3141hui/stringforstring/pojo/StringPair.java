package com.tony3141hui.stringforstring.pojo;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

@Table("string_pair")
public class StringPair {

    @Name
    private String string_pair_key;

    @Column
    private String string_pair_value;

    public StringPair() { }
    public StringPair(String string_pair_key, String string_pair_value) {

        this.string_pair_key = string_pair_key;
        this.string_pair_value = string_pair_value;

    }

    public String getString_pair_key() {
        return string_pair_key;
    }

    public void setString_pair_key(String string_pair_key) {
        this.string_pair_key = string_pair_key;
    }

    public String getString_pair_value() {
        return string_pair_value;
    }

    public void setString_pair_value(String string_pair_value) {
        this.string_pair_value = string_pair_value;
    }

}
