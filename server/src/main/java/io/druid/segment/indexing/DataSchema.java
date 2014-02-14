/*
 * Druid - a distributed column store.
 * Copyright (C) 2012, 2013  Metamarkets Group Inc.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package io.druid.segment.indexing;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Preconditions;
import io.druid.data.input.ByteBufferInputRowParser;
import io.druid.query.aggregation.AggregatorFactory;
import io.druid.timeline.partition.NoneShardSpec;
import io.druid.timeline.partition.ShardSpec;

/**
 */
public class DataSchema
{
  private final String dataSource;
  private final ByteBufferInputRowParser parser;
  private final AggregatorFactory[] aggregators;
  private final GranularitySpec granularitySpec;
  private final ShardSpec shardSpec;

  @JsonCreator
  public DataSchema(
      @JsonProperty("dataSource") String dataSource,
      @JsonProperty("parser") ByteBufferInputRowParser parser,
      @JsonProperty("metricsSpec") AggregatorFactory[] aggregators,
      @JsonProperty("granularitySpec") GranularitySpec granularitySpec,
      @JsonProperty("shardSpec") ShardSpec shardSpec
  )
  {
    Preconditions.checkNotNull(dataSource, "dataSource");
    Preconditions.checkNotNull(parser, "parser");
    Preconditions.checkNotNull(aggregators, "metrics");
    Preconditions.checkNotNull(granularitySpec, "granularitySpec");

    this.dataSource = dataSource;
    this.parser = parser;
    this.aggregators = aggregators;
    this.granularitySpec = granularitySpec;
    this.shardSpec = shardSpec == null ? new NoneShardSpec() : shardSpec;
  }

  @JsonProperty
  public String getDataSource()
  {
    return dataSource;
  }

  @JsonProperty
  public ByteBufferInputRowParser getParser()
  {
    return parser;
  }

  @JsonProperty("metricsSpec")
  public AggregatorFactory[] getAggregators()
  {
    return aggregators;
  }

  @JsonProperty
  public GranularitySpec getGranularitySpec()
  {
    return granularitySpec;
  }

  @JsonProperty
  public ShardSpec getShardSpec()
  {
    return shardSpec;
  }
}
