/*
 * Licensed to Metamarkets Group Inc. (Metamarkets) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. Metamarkets licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package io.druid.cli;

import java.util.Properties;

/**
 * 该类是使用java spi服务需要设置的接口
 * The PropertyChecker classes are loaded by ServiceLoader at the very start of the program and as such MUST be on the
 * initial classpath and cannot be loaded via extensions at runtime. (Or more precisely, they are ignored if present
 * in an extension at runtime, but not on the initial classpath)
 *
 * The PropertyChecker should ONLY try and set very specific properties and any class loading should be done in an
 * isolated class loader to not pollute the general class loader
 *    翻译:
 *  PropertyChecker类由ServiceLoader在程序启动时加载，因此必须在初始类路径上，不能在运行时通过扩展加载。(或者更确切地说，如果存在，它们会被忽略。
 *  在运行时的扩展中，但不是在初始类路径上
 *  PropertyChecker应该只尝试设置非常特定的属性，并且任何类装入都应该在隔离类装入器中完成，以不污染通用类装入器。
 *  */
public interface PropertyChecker
{
  /**
   * Check the given properties to make sure any unset values are properly configured. 检查给定的属性，以确保正确配置了任何未设置的值。
   * @param properties The properties to check, usually System.getProperties() 要检查的属性，通常是System.getProperties()
   */
  void checkProperties(Properties properties);
}
