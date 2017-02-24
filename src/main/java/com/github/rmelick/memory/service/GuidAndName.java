package com.github.rmelick.memory.service;

/**
 * Internal representation of the guid plus name to be used in the device cache map
 */
public class GuidAndName {
  private final String guid;
  private final String name;

  public GuidAndName(String guid, String name) {
    this.guid = guid;
    this.name = name;
  }

  public String getGuid() {
    return guid;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "GuidAndName{" +
      "guid='" + guid + '\'' +
      ", name='" + name + '\'' +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    return toString().equals(o.toString());
  }

  @Override
  public int hashCode() {
    return toString().hashCode();
  }
}
