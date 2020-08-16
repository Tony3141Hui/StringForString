package com.tony3141hui.stringforstring;

import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;

public class MainService {

    @At("/hello")
    @Ok("jsp:jsp.hello")
    public String hello() {
        return "Hello Nutz!";
    }

}
