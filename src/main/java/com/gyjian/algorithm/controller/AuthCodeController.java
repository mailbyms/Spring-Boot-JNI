package com.gyjian.algorithm.controller;

import com.gyjian.algorithm.jni.NativeLib;
import com.gyjian.algorithm.annotation.ApiVersion;
import com.gyjian.algorithm.bean.param.AuthCodeRequestParams;
import com.gyjian.algorithm.bean.result.Result;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/authcode")
public class AuthCodeController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @ApiVersion(1)
    @ApiOperation("获取授权码")
    @PostMapping(value = "/apply")
    public Result<String> apply(@RequestBody @Validated AuthCodeRequestParams params, HttpServletRequest request) {
        String appName = "e-assist";
        String appVersion = "1.0.0";
        String windowsGuid = "aa-bb-cc-dd";
        String diskSerial = "ee-ff-gg-hh";
        String biosUUID = "aa-bb-cc-ii";
        String machineId = "aa-jj-cc-dd";
        String agentId = "aa-kk-cc-dd";
        int is_periodically = 0;
        int authType = 3;
        int authPeriod = 4;
        int authCount = 5;
        long authTime = 6;

        logger.info("params:{}", params);

        String authCode = NativeLib.getAuthCode(params.getAppName(),
                params.getAppVersion(),
                params.getWindowsGuid(),
                params.getDiskSerial(),
                params.getBiosUUID(),
                params.getMachineId(),
                params.getAgentId(),
                params.getIsPeriodically(),
                params.getAuthType(),
                params.getAuthPeriod(),
                params.getAuthCount(),
                params.getAuthTime());

        logger.info("authCode:{}", authCode);

        return Result.success(authCode);
    }

}
