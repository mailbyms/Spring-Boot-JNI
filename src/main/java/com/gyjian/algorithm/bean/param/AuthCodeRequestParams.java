package com.gyjian.algorithm.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel(value = "请求授权码（激活设备）")
public class AuthCodeRequestParams {
    @ApiModelProperty(value = "程序名称",required = true)
    @NotNull
    private String appName;

    @ApiModelProperty(value = "版本",required = true)
    @NotNull
    private String appVersion;

    @ApiModelProperty(value = "windowsGuid",required = false)
    private String windowsGuid;

    @ApiModelProperty(value = "diskSerial",required = false)
    private String diskSerial;

    @ApiModelProperty(value = "biosUUID",required = false)
    private String biosUUID;

    @ApiModelProperty(value = "machineId",required = false)
    private String machineId;

    @ApiModelProperty(value = "代理商ID",required = true)
    @NotNull
    private String agentId;

    @ApiModelProperty(value = "是否分期,1 分期， 0 不分期",required = false)
    private Integer isPeriodically;

    @ApiModelProperty(value = "授权类型",required = false)
    private Integer authType;

    @ApiModelProperty(value = "授权周期",required = false)
    private Integer authPeriod;

    @ApiModelProperty(value = "授权分期数",required = false)
    private Integer authCount;

    @ApiModelProperty(value = "授权开始时间，或过期时间，时间戳",required = false)
    private Long authTime;
}
