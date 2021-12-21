package com.hyf.datacoreweb.util;


import java.util.HashMap;
import java.util.Map;


public class Result extends HashMap<String, Object> {

    public Result() {
        this.put((String)"code", 0);
        this.put((String)"msg", "success");
    }

    public static Result error(String msg) {
        return error(500, msg);
    }

    public static Result error(int code, String msg) {
        Result r = new Result();
        r.put((String)"code", code);
        r.put((String)"msg", msg);
        return r;
    }

    public static Result ok(String msg) {
        Result r = new Result();
        r.put((String)"msg", msg);
        return r;
    }

    public static Result ok(Map<String, Object> map) {
        Result r = new Result();
        r.putAll(map);
        return r;
    }

    public static Result ok() {
        return new Result();
    }

    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }

}
