package com.hyf.datacoreweb.util;

import java.util.HashMap;
import java.util.Map;

public class R extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public R() {
        this.put((String)"code", 0);
        this.put((String)"msg", "success");
    }

    public static R error() {
        return error(500, "鏈\ue046煡寮傚父锛岃\ue1ec鑱旂郴绠＄悊鍛 ");
    }

    public static R accessError() {
        return error(500, "缃戠粶瓒呮椂");
    }

    public static R accessError(String message) {
        return error(500, message);
    }

    public static R error(String msg) {
        return error(500, msg);
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.put((String)"code", code);
        r.put((String)"msg", msg);
        return r;
    }

    public static R ok(String msg) {
        R r = new R();
        r.put((String)"msg", msg);
        return r;
    }

    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R ok() {
        return new R();
    }

    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public static void main(String[] args) {
    }
}