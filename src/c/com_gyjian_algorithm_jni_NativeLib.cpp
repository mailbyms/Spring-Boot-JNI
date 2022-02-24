#include "com_gyjian_algorithm_jni_NativeLib.h"

#include <iostream>
#include <string.h>

extern "C" {
    #include "core/register.h"
}


#define AUTH_CODE_MAX_LEN 1024

/*
 * Class:     com_gyjian_algorithm_jni_NativeLib
 * Method:    getAuthCode
 * Signature: (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIIJ)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_gyjian_algorithm_jni_NativeLib_getAuthCode
  (JNIEnv *env, 
   jclass type, 
   jstring appName, 
   jstring appVersion, 
   jstring windowsGuid, 
   jstring diskSerial, 
   jstring biosUUID, 
   jstring machineId, 
   jstring agentId, 
   jint isPeriodically, 
   jint authType, 
   jint authPeriod, 
   jint authCount, 
   jlong authTime){

	 const char *cAppName = env->GetStringUTFChars(appName, 0);
	 const char *cAppVersion = env->GetStringUTFChars(appVersion, 0);
	 const char *cWindowsGuid = env->GetStringUTFChars(windowsGuid, 0);
	 const char *cDiskSerial = env->GetStringUTFChars(diskSerial, 0);
	 const char *cBiosUUID = env->GetStringUTFChars(biosUUID, 0);
	 const char *cMachineId = env->GetStringUTFChars(machineId, 0);
	 const char *cAgentId = env->GetStringUTFChars(agentId, 0);

	 std::cout << cAppName << std::endl;
	 std::cout << cAppVersion << std::endl;
	 std::cout << cWindowsGuid << std::endl;
	 std::cout << cDiskSerial << std::endl;
	 std::cout << cBiosUUID << std::endl;
	 std::cout << cMachineId << std::endl;
	 std::cout << cAgentId << std::endl;


	 // env->ReleaseStringUTFChars(prompt, str);

    char* result = (char *)malloc(AUTH_CODE_MAX_LEN);
    memset(result, 0, AUTH_CODE_MAX_LEN);

    int ret = generate_register_code(
    cAppName,
    strlen(cAppName),
    cAppVersion,
    strlen(cAppVersion),
    cWindowsGuid,
    strlen(cWindowsGuid),
    cDiskSerial,
    strlen(cDiskSerial),
    cBiosUUID,
    strlen(cBiosUUID),
    cMachineId,
    strlen(cMachineId),
    cAgentId,
    strlen(cAgentId),
    isPeriodically,
    authType,
    authPeriod,
    authCount,
    authTime,
    result
    );

    // 释放
    env->ReleaseStringUTFChars(appName, cAppName);
    env->ReleaseStringUTFChars(appVersion, cAppVersion);
    env->ReleaseStringUTFChars(windowsGuid, cWindowsGuid);
    env->ReleaseStringUTFChars(diskSerial, cDiskSerial);
    env->ReleaseStringUTFChars(biosUUID, cBiosUUID);
    env->ReleaseStringUTFChars(machineId, cMachineId);
    env->ReleaseStringUTFChars(machineId, cAgentId);
    // 释放结束

    jstring rtstr = env->NewStringUTF(result);
    free(result);

    return rtstr;
  }

