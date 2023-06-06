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
package com.hccake.common.excel.annotation;

import com.hccake.common.excel.head.HeadGenerator;

import java.lang.annotation.*;

/**
 * 用于指定导入导出的 excel 的 sheet 属性
 *
 * @author Yakir 2021/4/29 15:03
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Sheet {

	int sheetNo() default -1;

	/**
	 * sheet name
	 */
	String sheetName();

	/**
	 * 包含字段
	 */
	String[] includes() default {};

	/**
	 * 排除字段
	 */
	String[] excludes() default {};

	/**
	 * 头生成器
	 */
	Class<? extends HeadGenerator> headGenerateClass() default HeadGenerator.class;

}
