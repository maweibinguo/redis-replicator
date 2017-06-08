/*
 * Copyright 2016 leon chen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.moilioncircle.redis.replicator.cmd.parser;

import com.moilioncircle.redis.replicator.cmd.CommandParser;
import com.moilioncircle.redis.replicator.cmd.impl.ZRemRangeByScoreCommand;

import static com.moilioncircle.redis.replicator.cmd.parser.CommandParsers.objToBytes;
import static com.moilioncircle.redis.replicator.cmd.parser.CommandParsers.objToString;

/**
 * @author Leon Chen
 * @since 2.1.1
 */
public class ZRemRangeByScoreParser implements CommandParser<ZRemRangeByScoreCommand> {

    @Override
    public ZRemRangeByScoreCommand parse(Object[] command) {
        int idx = 1;
        String key = objToString(command[idx]);
        byte[] rawKey = objToBytes(command[idx]);
        idx++;
        String min = objToString(command[idx]);
        byte[] rawMin = objToBytes(command[idx]);
        idx++;
        String max = objToString(command[idx]);
        byte[] rawMax = objToBytes(command[idx]);
        idx++;
        return new ZRemRangeByScoreCommand(key, min, max, rawKey, rawMin, rawMax);
    }
}
