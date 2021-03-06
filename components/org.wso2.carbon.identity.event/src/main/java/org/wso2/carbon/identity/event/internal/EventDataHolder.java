/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.carbon.identity.event.internal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wso2.carbon.identity.event.EventService;

import java.util.concurrent.ExecutorService;

/**
 * Event data holder.
 */
public class EventDataHolder {

    private static Logger logger = LoggerFactory.getLogger(EventDataHolder.class);
    private static volatile EventDataHolder instance;
    private EventService eventService;
    private ExecutorService threadPool;

    private EventDataHolder() {

    }

    public static EventDataHolder getInstance() {
        if (instance == null) {
            synchronized (EventDataHolder.class) {
                if (instance == null) {
                    instance = new EventDataHolder();
                }
            }
        }
        return instance;
    }

    public ExecutorService getThreadPool() {
        return threadPool;
    }

    public void setThreadPool(ExecutorService threadPool) {
        this.threadPool = threadPool;
    }

    public EventService getEventMgtService() {
        return eventService;
    }

    public void setEventMgtService(EventService eventMgtService) {
        this.eventService = eventMgtService;
    }
}
