package com.twitter.demo.modules.core.exception;

public final class ErrorStatus {
    public static int BASIC = 0;
    public static int NOTFOUND = 1;
    public static int PHONE_NOTFOUND = 2;
    public static int DUPLICATE = 3;
    public static int PHONE_DUPLICATE = 4;
    public static int USERNAME_DUPLICATE = 5;
    public static int RELATED = 6;
    public static int RELATION_NOTFOUND = 7;
    public static int VALIDATION = 8;
    public static int UNAUTHENTICATED = 9;
    public static int UNAUTHORIZED = 10;
    public static int FILE_STORAGE = 11;
    public static int EXPIRE = 12;
    public static int TIME_LIMITATION = 13;
    public static int CAPTCHA = 14;
    public static int INVALID_OTP_CODE = 15;
    public static int INVALID_DATA = 16;
    public static int FAILED_TRANSACTION = 17;
    public static int FAILED_COMMAND = 18;
    public static int ACCOUNT_NOT_REGISTERED = 19;
    public static int TRANSACTION_EXCEPTION = 20;
    public static int USER_HAVE_SUBSCRIPTION = 21;
    public static int SUBSCRIPTION_EXPIRED = 22;
    public static int VOUCHER_NOT_VALID = 23;
    public static int VOUCHER_EXPIRED = 24;
    public static int OAUTH_OPERATION_ERROR = 25;
}
