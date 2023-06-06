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
package com.hccake.starter.pay.virtual;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import live.lingting.virtual.currency.tronscan.endpoints.TronscanEndpoints;

/**
 * @author lingting 2021/1/22 17:47
 */
@Data
@ConfigurationProperties(prefix = "ballcat.pay.tronscan")
public class TronscanProperties {

	/**
	 * 是否开启
	 */
	private Boolean enabled = true;

	/**
	 * 节点
	 */
	private TronscanEndpoints endpoints;

}
