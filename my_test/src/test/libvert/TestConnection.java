package test.libvert;

import org.libvirt.Connect;
import org.libvirt.Domain;
import org.libvirt.LibvirtException;

public class TestConnection {
    public static void testGetXenVMs() {
        try {
            System.setProperty("jna.library.path", "D:/Libvirt/bin");
            Connect conn = new Connect("kvm+tcp://192.168.2.248/");
            System.out.println(conn.nodeInfo().cores);
            for (String name : conn.listDefinedDomains()) {
                System.out.println(name);
                if (name != null) {
                    Domain domain = conn.domainLookupByName(name);
                    System.out.println(domain.getMaxMemory());
                    System.out.println(domain.getUUIDString());
                    System.out.println(domain.getInfo().maxMem);
                    System.out.println(domain.getInfo().state);
                    System.out.println(conn.listDomains().length);
                }
            }
        } catch (LibvirtException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        testGetXenVMs();
    }
}
