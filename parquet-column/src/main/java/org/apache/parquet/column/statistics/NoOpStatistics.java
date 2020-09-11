package org.apache.parquet.column.statistics;

import org.apache.parquet.schema.PrimitiveType;

public class NoOpStatistics<T extends Comparable<T>> extends Statistics<T> {

  NoOpStatistics(PrimitiveType type) {
    super(type);
  }

  @Override
  public boolean isEmpty() {
    return true;
  }

  @Override
  protected void mergeStatisticsMinMax(Statistics stats) {
    // NoOp
  }

  @Override
  public void setMinMaxFromBytes(byte[] minBytes, byte[] maxBytes) {
    // NoOp
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

  @Override
  public Statistics<T> copy() {
    return this;
  }
}
