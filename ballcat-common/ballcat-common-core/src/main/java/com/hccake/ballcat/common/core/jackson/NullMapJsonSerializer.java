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
package com.hccake.ballcat.common.core.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.io.Serializable;

/**
 * 空 Map 序列化处理器 Map 为 null，则序列化为 {}
 *
 * @author Hccake
 * @version 1.0
 * @date 2019/10/17 23:17
 */
public class NullMapJsonSerializer extends JsonSerializer<Object> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public void serialize(Object value, JsonGenerator jsonGenerator, SerializerProvider provider) throws IOException {
		if (value == null) {
			jsonGenerator.writeStartObject();
			jsonGenerator.writeEndObject();
		}
		else {
			jsonGenerator.writeObject(value);
		}
	}

}
