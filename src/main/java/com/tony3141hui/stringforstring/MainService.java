package com.tony3141hui.stringforstring;

import com.tony3141hui.stringforstring.dao.implement.StringPairDao;
import org.nutz.lang.util.NutMap;
import org.nutz.mvc.adaptor.JsonAdaptor;
import org.nutz.mvc.annotation.*;

public class MainService {

    private static final StringPairDao stringPairDao = new StringPairDao();

    @AdaptBy(type = JsonAdaptor.class)
    @At("/strings")
    @GET
    @Ok("json:full")
    public NutMap get(@Param(value = "key") String key) {

        NutMap jsonMap = new NutMap();

        if (key == null || !stringPairDao.containsKey(key)) {

            jsonMap.put("msg", "Error: key == null || !containsKey");

        } else {

            jsonMap.put("value", stringPairDao.get(key));

        }

        return jsonMap;

    }

    @AdaptBy(type = JsonAdaptor.class)
    @At("/strings")
    @POST
    @Ok("json:full")
    public NutMap post(@Param(value = "key") String key, @Param(value = "value") String value) {

        NutMap jsonMap = new NutMap();

        if (key == null || stringPairDao.containsKey(key)) {

            jsonMap.put("msg", "Error: key == null || containsKey");

        } else if (value == null) {

            jsonMap.put("msg", "Error: value == null");

        } else {

            stringPairDao.post(key, value);
            jsonMap.put("msg", "Done: create");

        }

        return jsonMap;

    }

    @AdaptBy(type = JsonAdaptor.class)
    @At("/strings")
    @PUT
    @Ok("json:full")
    public NutMap put(@Param(value = "key") String key, @Param(value = "value") String value) {

        NutMap jsonMap = new NutMap();

        if (key == null || !stringPairDao.containsKey(key)) {

            jsonMap.put("msg", "Error: key == null || !containsKey");

        } else if (value == null) {

            jsonMap.put("msg", "Error: value == null");

        } else {

            stringPairDao.put(key, value);
            jsonMap.put("msg", "Done: update");

        }

        return jsonMap;

    }

    @AdaptBy(type = JsonAdaptor.class)
    @At("/strings")
    @DELETE
    @Ok("json:full")
    public NutMap delete(@Param(value = "key") String key) {

        NutMap jsonMap = new NutMap();

        if (key == null || !stringPairDao.containsKey(key)) {

            jsonMap.put("msg", "Error: key == null || !containsKey");

        } else {

            stringPairDao.remove(key);
            jsonMap.put("msg", "Done: delete");

        }

        return jsonMap;

    }

}
