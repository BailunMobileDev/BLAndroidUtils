package com.bailun.utils.json;


import android.support.annotation.NonNull;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


/**
 * create by chl on 2019/12/12
 * description : 参考 https://www.jianshu.com/p/d62c2be60617
 */
class ImpParameterizedType implements ParameterizedType {

    private Class raw;
    private Type[] args;
    private Type owner;

    public ImpParameterizedType(Class raw, Type[] args, Type owner) {
        this.raw = raw;
        this.args = args != null ? args : new Type[0];
        this.owner = owner;
    }


    @NonNull
    @Override
    public Type[] getActualTypeArguments() {
        return args;
    }

    @NonNull
    @Override
    public Type getRawType() {
        return raw;
    }

    @Override
    public Type getOwnerType() {
        return owner;
    }
}
