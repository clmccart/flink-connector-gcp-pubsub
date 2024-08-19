/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.flink.streaming.connectors.gcp.pubsub.v2.internal.source.split;

import org.apache.flink.core.io.SimpleVersionedSerializer;
import org.apache.flink.streaming.connectors.gcp.pubsub.proto.SubscriptionSplitProto;

import java.io.IOException;

public final class SubscriptionSplitSerializer
        implements SimpleVersionedSerializer<SubscriptionSplit> {
    @Override
    public int getVersion() {
        return 0;
    }

    @Override
    public byte[] serialize(SubscriptionSplit subscriptionSplit) {
        return subscriptionSplit.toProto().toByteArray();
    }

    @Override
    public SubscriptionSplit deserialize(int i, byte[] bytes) throws IOException {
        return SubscriptionSplit.fromProto(SubscriptionSplitProto.parseFrom(bytes));
    }
}
