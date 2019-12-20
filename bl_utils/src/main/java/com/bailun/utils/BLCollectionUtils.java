package com.bailun.utils;

import android.support.annotation.Nullable;

import java.util.Collection;


/**
 * 集合工具类
 *
 * @author yh
 * @date 2019/11/29
 */
public class BLCollectionUtils {

    private BLCollectionUtils() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Returns the size of the given collection, or 0 if null
     */
    public static int size(@Nullable Collection<?> cur) {
        return cur != null ? cur.size() : 0;
    }

    /**
     * Returns whether the given collection {@link Collection#isEmpty is empty} or {@code null}
     */
    public static boolean isEmpty(@Nullable Collection<?> cur) {
        return cur == null || cur.isEmpty();
    }
}
