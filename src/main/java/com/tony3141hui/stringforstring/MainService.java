package com.tony3141hui.stringforstring;

import org.nutz.lang.util.NutMap;
import org.nutz.mvc.adaptor.JsonAdaptor;
import org.nutz.mvc.annotation.*;

import java.util.HashMap;

public class MainService {

    private static final HashMap<String, String> fakeDao = new HashMap<String, String>();

    static {

        fakeDao.put("hello", "Hello Nutz!");
        fakeDao.put("test", "testvalue");

    }

    @AdaptBy(type = JsonAdaptor.class)
    @At("/strings")
    @GET
    @Ok("json:full")
    public NutMap get(@Param(value = "key") String key) {

        NutMap jsonMap = new NutMap();

        jsonMap.put("value", fakeDao.get(key));

        return jsonMap;

    }

    @AdaptBy(type = JsonAdaptor.class)
    @At("/strings")
    @POST
    @Ok("json:full")
    public NutMap post(@Param(value = "key") String key, @Param(value = "value") String value) {

        NutMap jsonMap = new NutMap();

        if (key == null || fakeDao.containsKey(key)) {

            jsonMap.put("value", "Error: key == null || containsKey");

        } else if (value == null) {

            jsonMap.put("value", "Done: nothing");

        } else {

            fakeDao.put(key, value);
            jsonMap.put("value", "Done: create");

        }

        return jsonMap;

    }

    @AdaptBy(type = JsonAdaptor.class)
    @At("/strings")
    @PUT
    @Ok("json:full")
    public NutMap put(@Param(value = "key") String key, @Param(value = "value") String value) {

        NutMap jsonMap = new NutMap();

        if (key == null || !fakeDao.containsKey(key)) {

            jsonMap.put("value", "Error: key == null || !containsKey");

        } else {

            fakeDao.put(key, value);
            jsonMap.put("value", "Done: update");

        }

        return jsonMap;

    }

    @AdaptBy(type = JsonAdaptor.class)
    @At("/strings")
    @DELETE
    @Ok("json:full")
    public NutMap delete(@Param(value = "key") String key) {

        NutMap jsonMap = new NutMap();

        if (key == null || !fakeDao.containsKey(key)) {

            jsonMap.put("value", "Error: key == null || !containsKey");

        } else {

            fakeDao.remove(key);
            jsonMap.put("value", "Done: delete");

        }

        return jsonMap;

    }

}
