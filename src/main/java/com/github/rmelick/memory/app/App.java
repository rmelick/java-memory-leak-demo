package com.github.rmelick.memory.app;

import com.github.rmelick.memory.api.DeviceService;
import com.github.rmelick.memory.service.DeviceServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class App {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws InterruptedException {
        new App().run();
    }

    public void run() throws InterruptedException {
        LOGGER.info("Starting application");

        DeviceService deviceService = new DeviceServiceImpl();

        List<DeviceSimulator> devices = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            devices.add(DeviceSimulator.random());
        }

        AtomicLong batchCounter = new AtomicLong(0);

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleWithFixedDelay(
          () -> {
              long batch = batchCounter.incrementAndGet();
              try {
                  LOGGER.info("Updating devices batch " + batch);
                  for (DeviceSimulator device : devices) {
                      deviceService.receiveMessage(device.getUpdate());
                  }
                  LOGGER.info("Completed update batch " + batch);
              } catch (Throwable t) {
                  LOGGER.error("Failed to update batch " + batch, t);
              }
          },
          0,
          1,
          TimeUnit.SECONDS
        );

        new CountDownLatch(1).await(30, TimeUnit.MINUTES);
    }
}
