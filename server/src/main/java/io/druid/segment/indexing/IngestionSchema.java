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

/**
 */
public class IngestionSchema
{
  private final DataSchema dataSchema;
  private final IOConfig ioConfig;
  private final DriverConfig driverConfig;

  @JsonCreator
  public IngestionSchema(
      @JsonProperty("dataSchema") DataSchema dataSchema,
      @JsonProperty("io") IOConfig ioConfig,
      @JsonProperty("driverConfig") DriverConfig driverConfig
  )
  {
    this.dataSchema = dataSchema;
    this.ioConfig = ioConfig;
    this.driverConfig = driverConfig;
  }

  @JsonProperty("dataSchema")
  public DataSchema getDataSchema()
  {
    return dataSchema;
  }

  @JsonProperty("io")
  public IOConfig getIoConfig()
  {
    return ioConfig;
  }

  @JsonProperty("config")
  public DriverConfig getDriverConfig()
  {
    return driverConfig;
  }
}
