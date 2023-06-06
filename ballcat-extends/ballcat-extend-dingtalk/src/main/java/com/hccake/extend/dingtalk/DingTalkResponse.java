/*
 * Copyright 2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hccake.extend.dingtalk;

import cn.hutool.core.convert.Convert;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.experimental.Accessors;

import java.io.IOException;
import java.util.Map;

/**
 * 钉钉返回信息
 *
 * @author lingting 2020/6/11 0:23
 */
@Getter
@Setter
@Accessors(chain = true)
public class DingTalkResponse {

	public static final Long SUCCESS_CODE = 0L;

	@SneakyThrows({ StreamReadException.class, DatabindException.class, IOException.class })
	public DingTalkResponse(String res) {
		Map<?, ?> resMap = new ObjectMapper().readValue(res.getBytes(), Map.class);
		this.response = res;
		this.code = Convert.toLong(resMap.get("errcode"));
		this.message = Convert.toStr(resMap.get("errmsg"));
		this.success = SUCCESS_CODE.equals(this.code);
	}

	public static DingTalkResponse of(String res) {
		return new DingTalkResponse(res);
	}

	private Long code;

	/**
	 * 值为ok表示无异常
	 */
	private String message;

	/**
	 * 钉钉返回信息
	 */
	private String response;

	/**
	 * 是否发送成功
	 */
	private boolean success;

	@Override
	public String toString() {
		return response;
	}

}
