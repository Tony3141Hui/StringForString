package com.tony3141hui.stringforstring;

import org.nutz.lang.util.NutMap;
import org.nutz.mvc.adaptor.JsonAdaptor;
import org.nutz.mvc.annotation.*;

public class MainService {

    @AdaptBy(type = JsonAdaptor.class)
    @At("/string")
    @Ok("json:full")
    @GET
    public NutMap hello(@Param(value = "key") String key) {
        NutMap jsonMap = new NutMap();

        if (key.equals("hello")) {

            jsonMap.put("Test", "Hello Nutz!");

        } else {

            jsonMap.put("Test", "Please GET '/?key=hello'.");

        }

        return jsonMap;
    }

}
