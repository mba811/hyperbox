/*
 * Hyperbox - Enterprise Virtualization Manager
 * Copyright (C) 2015 - Kamax.io
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

package org.altherian.hboxc.front.gui.vm;

import java.util.List;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import org.altherian.hbox.hypervisor._MachineLogFile;
import org.altherian.hboxc.front.gui.Gui;
import org.altherian.hboxc.front.gui.builder.JDialogBuilder;

public class MachineLogFileViewer {

   private String _srvId;
   private String _vmId;

   private JDialog dialog;

   public MachineLogFileViewer(String srvId, String vmId) {
      _srvId = srvId;
      _vmId = vmId;

      List<String> logList = Gui.getServer(_srvId).getHypervisor().getLogFileList(_vmId);

      dialog = JDialogBuilder.get("VM Log viewer");
      JTabbedPane tabs = new JTabbedPane();
      for (String logName : logList) {
         _MachineLogFile logIo = Gui.getServer(_srvId).getHypervisor().getLogFile(_vmId, logName);
         JTextArea text = new JTextArea();
         for (String line : logIo.getLog()) {
            text.append(line + "\n");
         }
         tabs.addTab(logName, new JScrollPane(text));
      }

      dialog.getContentPane().add(tabs, "grow,push");
      dialog.setSize(800, 600);
      dialog.setLocationRelativeTo(dialog.getParent());
   }

   public void show() {
      dialog.setVisible(true);
   }

   public static void show(String srvId, String vmId) {
      (new MachineLogFileViewer(srvId, vmId)).show();
   }

}
