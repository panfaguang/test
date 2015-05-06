package xianpan.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import com.vmware.vim25.HostVirtualNic;
import com.vmware.vim25.PhysicalNic;
import com.vmware.vim25.VirtualMachineCapability;
import com.vmware.vim25.mo.Folder;
import com.vmware.vim25.mo.HostNetworkSystem;
import com.vmware.vim25.mo.HostSystem;
import com.vmware.vim25.mo.InventoryNavigator;
import com.vmware.vim25.mo.ManagedEntity;
import com.vmware.vim25.mo.ServiceInstance;
import com.vmware.vim25.mo.VirtualMachine;

public class Test1 {
    public static void main(String[] args) {
        String urlStr = "https://192.168.2.42/sdk";
        String username = "root";
        String password = "antrol&support";
        try {
            ServiceInstance si = new ServiceInstance(new URL(urlStr), username, password, true);
            Folder rootFolder = si.getRootFolder();
            VirtualMachine vm = (VirtualMachine) new InventoryNavigator(rootFolder)
                    .searchManagedEntities("VirtualMachine")[0];
            HostSystem host = null;
            ManagedEntity[] hosts = new InventoryNavigator(rootFolder).searchManagedEntities("HostSystem");
            for (int n = 0; n < hosts.length; n++) {
                HostNetworkSystem hns = ((HostSystem) hosts[n]).getHostNetworkSystem();
                PhysicalNic[] phys = ((HostSystem) hosts[n]).getHostNetworkSystem().getNetworkInfo().getPnic();
                for (int i = 0; i < phys.length; i++) {
                    System.out.println(phys[i].getDevice());
                }
                HostVirtualNic[] hvns = hns.getNetworkInfo().getVnic();
                System.out.println(((HostSystem) hosts[n]).getVms()[0].getName());
                for (int i = 0; i < hvns.length; i++) {
                    System.out.println(hvns[0].spec.mac);
                    System.out.println(hvns[0].spec.ip.ipAddress);
                }
            }
            VirtualMachineCapability vmc = vm.getCapability();
            System.out.println("Hello " + vm.getName());
            System.out.println();
            System.out.println(vm.getGuest().net[0].getMacAddress());
            System.out.println("VM Version:" + vm.getConfig());
            System.out.println("Multiple snapshot supported: " + vmc.isMultipleSnapshotsSupported());
            si.getServerConnection().logout();
        } catch (RemoteException | MalformedURLException e) {
            System.out.println(e);
        }
        // VirtualMachineCapability vmc = vm.getCapability();
        // System.out.println("Hello " + vm.getName());
        // vm.rebootGuest();
        // System.out.println();
        // System.out.println(vm.getGuest().net[0].getMacAddress());
        // System.out.println("VM Version:" + vm.getConfig());
        // System.out.println("Multiple snapshot supported: " + vmc.isMultipleSnapshotsSupported());
    }
}
