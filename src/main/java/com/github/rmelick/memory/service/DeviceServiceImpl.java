package com.github.rmelick.memory.service;

import com.github.rmelick.memory.api.DeviceService;
import com.github.rmelick.memory.api.DeviceUpdateMessage;

/**
 *
 */
public class DeviceServiceImpl implements DeviceService {
  private final DeviceCache deviceCache = new DeviceCache();
  private final DeviceDB deviceDB = new DeviceDB();

  @Override
  public void receiveMessage(DeviceUpdateMessage deviceUpdateMessage) {
    deviceCache.updateFromMessage(deviceUpdateMessage);
    deviceDB.updateFromMessage(deviceUpdateMessage);
  }

  @Override
  public Double getCurrentValue(String deviceGuid, String tagName) {
    return deviceCache.getCurrentValue(deviceGuid, tagName);
  }
}
