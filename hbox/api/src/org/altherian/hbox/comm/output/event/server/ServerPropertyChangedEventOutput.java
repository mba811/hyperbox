/*
 * Hyperbox - Enterprise Virtualization Manager
 * Copyright (C) 2014 Maxime Dor
 * 
 * http://hyperbox.altherian.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */

package org.altherian.hbox.comm.output.event.server;

import org.altherian.hbox.comm.output.ServerOutput;
import org.altherian.hbox.event.HyperboxEvents;

import java.util.Date;

public class ServerPropertyChangedEventOutput extends ServerEventOutput {
   
   private Object property;
   private String newValue;
   
   protected ServerPropertyChangedEventOutput() {
      // Used for (de)serialization
   }
   
   public ServerPropertyChangedEventOutput(Date time, ServerOutput srvOut, Object property, String newValue) {
      super(time, HyperboxEvents.ServerPropertyChanged, srvOut);
      this.property = property;
      this.newValue = newValue;
   }
   
   public Object getProperty() {
      return property;
   }
   
   public String getValue() {
      return newValue;
   }
   
}