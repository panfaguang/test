// package xianpan.test;
//
// import java.net.URL;
//
// import com.vmware.vim25.GuestNicInfo;
// import com.vmware.vim25.mo.Folder;
// import com.vmware.vim25.mo.InventoryNavigator;
// import com.vmware.vim25.mo.ServiceInstance;
//
// public class TestSNMP {
// public static void main(String[] args) throws Exception {
// String urlStr = "https://192.168.2.41/sdk";
// String username = "root";
// String password = "antrol&support";
// ServiceInstance si = new ServiceInstance(new URL(urlStr), username, password, true);
// Folder rootFolder = si.getRootFolder();
// GuestNicInfo host = null;
// host = (GuestNicInfo) new InventoryNavigator(rootFolder).searchManagedEntities("GuestNicInfo")[0];
// // HostSnmpSystem hss = host.getHostSnmpSystem();
// // HostSnmpConfigSpec spec = new HostSnmpConfigSpec();
// // spec.setEnabled(true);
// // spec.setReadOnlyCommunities(new String[] {"public" });
// // HostSnmpDestination dest = new HostSnmpDestination();
// // dest.setCommunity("public");
// // dest.setHostName("192.168.2.41");
// // dest.setPort(162);
// // spec.setTrapTargets(new HostSnmpDestination[] {dest });
// // hss.reconfigureSnmpAgent(spec);
// // si.getServerConnection().logout();
// }
// }
