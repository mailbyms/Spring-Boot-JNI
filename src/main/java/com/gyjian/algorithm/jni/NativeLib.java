package com.gyjian.algorithm.jni;

public class NativeLib {
    static {
        LibLoader.loadLib("libNativeLib.so");
    }

    /**
     *
     * @param appName 程序名称
     * @param appVersion 版本
     * @param windowsGuid
     * @param diskSerial
     * @param biosUUID
     * @param machineId
     * @param agentId 代理商ID
     * @param isPeriodically 是否分期,1 分期， 0 不分期
     * @param authType 授权类型
     * @param authPeriod 授权周期
     * @param authCount 授权分期数
     * @param authTime 授权开始时间，或过期时间，时间戳
     * @return register_code 注册码
     */
    public static native String getAuthCode(String appName,
                                            String appVersion,
                                            String windowsGuid,
                                            String diskSerial,
                                            String biosUUID,
                                            String machineId,
                                            String agentId,
                                            int isPeriodically,
                                            int authType,
                                            int authPeriod,
                                            int authCount,
                                            long authTime);


}
