/*
 * Copyright 2013 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package io.netty.channel.group;

import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/**
 * {@link ChannelException} which holds {@link ChannelFuture}s that failed because of an error.
 * ChannelGroup提交后,有任务执行失败
 */
public class ChannelGroupException extends ChannelException implements Iterable<Map.Entry<Channel, Throwable>> {
    private static final long serialVersionUID = -4093064295562629453L;
    
    //存储每一个失败的channel集合,分别由Channel和Throwable组成
    private final Collection<Map.Entry<Channel, Throwable>> failed;

    public ChannelGroupException(Collection<Map.Entry<Channel, Throwable>> causes) {
        if (causes == null) {
            throw new NullPointerException("causes");
        }
        if (causes.isEmpty()) {
            throw new IllegalArgumentException("causes must be non empty");
        }
        failed = Collections.unmodifiableCollection(causes);
    }

    /**
     * Returns a {@link Iterator} which contains all the {@link Throwable} that was a cause of the failure and the
     * related id of the {@link Channel}.
     * 迭代每一个失败的渠道以及渠道信息
     */
    @Override
    public Iterator<Map.Entry<Channel, Throwable>> iterator() {
        return failed.iterator();
    }
}
