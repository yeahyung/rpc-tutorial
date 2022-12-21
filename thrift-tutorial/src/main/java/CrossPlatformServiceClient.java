import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import yea.thrift.impl.CrossPlatformResource;
import yea.thrift.impl.CrossPlatformService;

import java.util.List;

public class CrossPlatformServiceClient {
    public boolean ping() {
        try {
            TTransport transport;
            transport = new TSocket("localhost", 9090);
            transport.open();

            TProtocol protocol = new TBinaryProtocol(transport);
            CrossPlatformService.Client client = new CrossPlatformService.Client(protocol);

            System.out.println("Calling remote method..");

            boolean result = client.ping();
            System.out.println("done. result:" + result);

            List<CrossPlatformResource> crossPlatformResources = client.getList();
            System.out.println("done. result: " + crossPlatformResources);

            transport.close();

            return result;
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
