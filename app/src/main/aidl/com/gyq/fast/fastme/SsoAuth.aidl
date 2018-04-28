// SsoAuth.aidl
package com.gyq.fast.fastme;

// Declare any non-default types here with import statements

interface SsoAuth {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

     /**
     * 实现SSO授权
     */
     void ssoAuth(String userName, String pwd);
}
