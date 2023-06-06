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
package com.hccake.ballcat.common.redis.operation;

import org.aspectj.lang.ProceedingJoinPoint;

import java.lang.reflect.Type;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author Hccake
 * @version 1.0
 * @date 2019/9/2 15:19
 */
public class CachedOps extends AbstractCacheOps {

	/**
	 * 数据类型
	 */
	private final Type returnType;

	/**
	 * 缓存分布式锁的key
	 */
	private final String lockKey;

	/**
	 * 从Redis中获取缓存数据的操作
	 */
	private final Supplier<String> cacheQuery;

	/**
	 * 向缓存写入数据
	 */
	private final Consumer<Object> cachePut;

	/**
	 * 基本构造函数
	 * @param joinPoint 织入方法
	 * @param lockKey 分布式锁key
	 * @param cacheQuery 查询缓存函数
	 * @param cachePut 更新缓存函数
	 * @param returnType 返回数据类型
	 */
	public CachedOps(ProceedingJoinPoint joinPoint, String lockKey, Supplier<String> cacheQuery,
			Consumer<Object> cachePut, Type returnType) {
		super(joinPoint);
		this.lockKey = lockKey;
		this.cacheQuery = cacheQuery;
		this.cachePut = cachePut;
		this.returnType = returnType;
	}

	public Supplier<String> cacheQuery() {
		return cacheQuery;
	}

	public Consumer<Object> cachePut() {
		return cachePut;
	}

	public Type returnType() {
		return returnType;
	}

	public String lockKey() {
		return lockKey;
	}

}
