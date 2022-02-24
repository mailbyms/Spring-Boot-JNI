package com.gyjian.algorithm.bean.result;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "统一数据返回对象", description = "所有数据经此包装")
public class Result<T> {
	@ApiModelProperty("是否成功: true or false")
	protected boolean success = true;

	@ApiModelProperty("描述性原因")
	protected String msg = null;

	@ApiModelProperty("业务数据")
	protected T data = null;

	@ApiModelProperty("错误码")
	protected Integer code = 0;

	public Result(boolean success, String msg) {
		this.success = success;
		this.msg = msg;
	}

	public Result(boolean success, String msg, Integer code ) {
		this.success = success;
		this.msg = msg;
		this.code = code;
	}

	public Result(boolean success, String msg, T data) {
		this.success = success;
		this.msg = msg;
		this.data = data;
	}

	public Result(boolean success, String msg, T data, Integer code ) {
		this.success = success;
		this.msg = msg;
		this.data = data;
		this.code = code;
	}

	public static<T> Result<T> success(T data) {
		return new Result<>(true, "SUCCESS", data,200);
	}

	public static Result success() {
		return new Result(true,"SUCCESS",200);
	}

	public static Result failure() {
		return new Result(false,"FAILED");
	}

	public static Result failure(String msg) {
		return new Result(false,msg);
	}

	public T getData() {
		return data;
	}

	public Result<T> setData(T data) {
		this.data = data;
		return this;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public Result setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	public Result setMsg(String msg,Integer code) {
		this.msg = msg;
		this.code = code;
		return this;
	}

	public Integer getCode() {
		return code;
	}

	public Result setCode(Integer code) {
		this.code = code;
		return this;
	}


	@Override
	public String toString(){
		return JSON.toJSONString(this);
	}
	
}
