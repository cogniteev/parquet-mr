/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.parquet.column.statistics;

import org.apache.parquet.io.api.Binary;
import org.apache.parquet.schema.PrimitiveType;

public class NoOpStatistics<T extends Comparable<T>> extends Statistics<T> {

  NoOpStatistics(PrimitiveType type) {
    super(type);
  }

  public NoOpStatistics(NoOpStatistics<T> other) {
    super(other.type());
    if (other.hasNonNullValue()) {
      markAsNotEmpty();;
    }
    setNumNulls(other.getNumNulls());
  }

  @Override
  protected void mergeStatisticsMinMax(Statistics stats) {
    if (stats.hasNonNullValue()) {
      markAsNotEmpty();
    }
  }

  @Override
  public void setMinMaxFromBytes(byte[] minBytes, byte[] maxBytes) {
    markAsNotEmpty();
  }

  @Override
  public T genericGetMin() {
    return null;
  }

  @Override
  public T genericGetMax() {
    return null;
  }

  @Override
  public byte[] getMaxBytes() {
    return null;
  }

  @Override
  public byte[] getMinBytes() {
    return null;
  }

  @Override
  String stringify(T value) {
    return "N/A";
  }

  @Override
  public boolean isSmallerThan(long size) {
    return false;
  }

  /**
   * updates statistics min and max using the passed value
   * @param value value to use to update min and max
   */
  public void updateStats(int value) {
    markAsNotEmpty();
  }

  /**
   * updates statistics min and max using the passed value
   * @param value value to use to update min and max
   */
  public void updateStats(long value) {
    markAsNotEmpty();
  }

  /**
   * updates statistics min and max using the passed value
   * @param value value to use to update min and max
   */
  public void updateStats(float value) {
    markAsNotEmpty();
  }

  /**
   * updates statistics min and max using the passed value
   * @param value value to use to update min and max
   */
  public void updateStats(double value) {
    markAsNotEmpty();
  }

  /**
   * updates statistics min and max using the passed value
   * @param value value to use to update min and max
   */
  public void updateStats(boolean value) {
    markAsNotEmpty();
  }

  /**
   * updates statistics min and max using the passed value
   * @param value value to use to update min and max
   */
  public void updateStats(Binary value) {
    markAsNotEmpty();
  }

  @Override
  public Statistics<T> copy() {
    return new NoOpStatistics<>(this);
  }
}
