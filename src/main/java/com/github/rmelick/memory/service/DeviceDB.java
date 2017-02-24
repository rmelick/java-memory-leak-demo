package com.github.rmelick.memory.service;

import com.github.rmelick.memory.api.DeviceUpdateMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 */
public class DeviceDB {
  private static final Logger LOGGER = LoggerFactory.getLogger(DeviceDB.class);
  private static final boolean initialized = initialize();

  private static boolean initialize() {
    try {
      Class.forName("org.h2.Driver");
      return true;
    } catch (ClassNotFoundException e) {
      LOGGER.error("h2 error", e);
    }
    return false;
  }

  public void updateFromMessage(DeviceUpdateMessage deviceUpdateMessage) {
    try {
      Connection dbConnection = DriverManager.getConnection("jdbc:h2:./test");
      Statement update = dbConnection.createStatement();
      String guid = deviceUpdateMessage.getDeviceGuid();
      long timestamp = deviceUpdateMessage.getTimestampMs();
      update.executeUpdate(String.format("INSERT INTO DEVICE_TIMESTAMPES VALUES (%s, %s)", guid, timestamp));
      dbConnection.close();
    } catch (SQLException e) {

    }
  }
}
