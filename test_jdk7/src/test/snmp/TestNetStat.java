package test.snmp;

import java.io.IOException;
import java.util.List;

import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.Address;
import org.snmp4j.smi.GenericAddress;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;
import org.snmp4j.util.DefaultPDUFactory;
import org.snmp4j.util.TableEvent;
import org.snmp4j.util.TableUtils;

public class TestNetStat {
    public static void main(String[] args) throws IOException {
        String outinfo;
        // Socket socket = new Socket("112.136.10.44", 27);
        try {
            TcpUtil myutil = new TcpUtil();
            outinfo = myutil.printTcpConn();
            // System.out.println("socket=" + socket);
            // BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),
            // true);
            // if (outinfo != null)
            // out.println(outinfo + "M20");
            // System.out.println("发送的信息：");
            // System.out.println(outinfo + "M20");
            // System.out.println("接收的信息：");
            // String str = in.readLine();
            // System.out.println(str);
            // in.close();
            // out.close();
            // System.out.println("发送监听成功！！！！！！！！！！！1");
            // socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class NetStat {
    static String[] stat = {"???", "CLOSED", "LISTENING", "SYN_SENT", "SEN_RECEIVED", "ESTABLISHED", "FIN_WAIT",
            "FIN_WAIT2", "CLOSE_WAIT", "CLOSING", "LAST_ACK", "TIME_WAIT" };
}

class TcpUtil {
    public String printTcpConn() throws IOException {
        String str = null;
        TransportMapping<?> transport = new DefaultUdpTransportMapping();
        Snmp snmp = new Snmp(transport);
        transport.listen();
        Address targetAddress = GenericAddress.parse("udp:192.168.1.216/161");
        CommunityTarget target = new CommunityTarget();
        target.setCommunity(new OctetString("public"));
        target.setAddress(targetAddress);
        target.setRetries(2);
        target.setTimeout(1500);
        target.setVersion(SnmpConstants.version1);
        TableUtils tutils = new TableUtils(snmp, new DefaultPDUFactory(PDU.GETBULK));// GETNEXT or GETBULK
        tutils.setMaxNumRowsPerPDU(4);
        OID columnOID[] = new OID[4];
        // columnOID[0] = new OID("1.3.6.1.2.1.25.2.3.1.1");
        // columnOID[1] = new OID("1.3.6.1.2.1.25.2.3.1.2");
        // columnOID[2] = new OID("1.3.6.1.2.1.25.2.3.1.3");
        columnOID[0] = new OID("1.3.6.1.2.1.25.2.3.1.4");
        columnOID[1] = new OID("1.3.6.1.2.1.25.2.3.1.5");
        columnOID[2] = new OID("1.3.6.1.2.1.25.2.3.1.6");
        columnOID[3] = new OID("1.3.6.1.2.1.25.2.3.1.2");
        // columnOID[3] = new OID("1.3.6.1.2.1.25.2.3.1.7");
        List<TableEvent> tabEveList = tutils.getTable(target, columnOID, null, null);
        int tabEveNum = tabEveList.size();
        System.out.println("地址转发表数目：" + tabEveNum);
        // System.out.println(tabEveList);
        // System.out.print("State\t\tLocalAddress\tLocalPort\tRemAddress\tRemPort\n");
        for (int i = 0; i < tabEveNum; i++) {
            TableEvent tabEve = tabEveList.get(i);
            // System.out.print(tabEve + "\n");
            VariableBinding[] varBindings = tabEve.getColumns();
            System.out.print(varBindings[0].getVariable() + "\t");
            System.out.print(varBindings[1].getVariable() + "\t");
            System.out.print(varBindings[2].getVariable() + "\t");
            System.out.print(varBindings[3].getVariable() + "\n");
            // System.out.print(varBindings[4].getVariable() + "\t");
            // System.out.print(varBindings[5].getVariable() + "\t");
            // System.out.print(varBindings[6].getVariable() + "\n");
        }
        return str;
    }
}
