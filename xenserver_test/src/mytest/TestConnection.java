package mytest;

import java.net.URL;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import samples.TargetServer;

import com.xensource.xenapi.APIVersion;
import com.xensource.xenapi.Connection;
import com.xensource.xenapi.Host;
import com.xensource.xenapi.Session;
import com.xensource.xenapi.VIF;
import com.xensource.xenapi.VM;

public class TestConnection {
    public static void main(String[] args) {
        TargetServer target = new TargetServer("192.168.2.79", "root", "WWW.antrol.net$2014");
        Set<String> set = new HashSet<String>();
        try {
            Connection connection = new Connection(new URL("http://" + target.Hostname));
            Session.loginWithPassword(connection, target.Username, target.Password, APIVersion.latest().toString());
            for (Host host : Host.getAll(connection)) {
                System.out.println(host.getMetrics(connection).getMemoryFree(connection));
                System.out.println(host.getMetrics(connection).getMemoryTotal(connection) / 1024 / 1024 / 1024);
            }
            Map<VM, VM.Record> vms = VM.getAllRecords(connection);
            for (VM.Record record : vms.values()) {
                for (VIF vif : record.VIFs) {
                    System.out.println(vif.getMAC(connection));
                    set.add(vif.getMAC(connection));
                }
            }
            System.out.println(set.size());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
