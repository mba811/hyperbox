package org.altherian.hboxc.front.gui.action.machine;

import org.altherian.hbox.comm.HypervisorTasks;
import org.altherian.hbox.hypervisor._MachineLogFile;
import org.altherian.hboxc.front.gui.Gui;
import org.altherian.hboxc.front.gui.builder.IconBuilder;
import org.altherian.hboxc.front.gui.builder.JDialogBuilder;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MachineLogGetAction extends AbstractAction {

   private String _srvId;
   private String _vmId;
   private String _logId;

   public MachineLogGetAction(String srvId, String vmId, String logId) {
      super("View Log Files", IconBuilder.getTask(HypervisorTasks.MachineLogFileGet));

      _srvId = srvId;
      _vmId = vmId;
      _logId = logId;

      setEnabled(true);
   }

   @Override
   public void actionPerformed(ActionEvent ae) {
      _MachineLogFile logIo = Gui.getServer(_srvId).getHypervisor().getLogFile(_vmId, "0");

      JDialog dialog = JDialogBuilder.get("VM Log viewer");

      JTextArea text = new JTextArea();
      for (String line : logIo.getLog()) {
         text.append(line + "\n");
      }
      dialog.getContentPane().add(new JScrollPane(text));

      dialog.setSize(800, 600);
      dialog.setLocationRelativeTo(dialog.getParent());

      dialog.setVisible(true);
   }

}
