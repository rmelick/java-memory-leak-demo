package com.github.rmelick.memory.api;

/**
 * Our web application
 */
public interface DeviceService {
  void receiveMessage(DeviceUpdateMessage deviceUpdateMessage);

  Double getCurrentValue(String deviceGuid, String tagName);
}
