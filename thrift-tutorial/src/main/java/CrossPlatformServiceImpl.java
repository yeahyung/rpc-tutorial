import org.apache.thrift.TException;
import yea.thrift.impl.CrossPlatformResource;
import yea.thrift.impl.CrossPlatformService;
import yea.thrift.impl.InvalidOperationException;

import java.util.Collections;
import java.util.List;

public class CrossPlatformServiceImpl implements CrossPlatformService.Iface {

    public CrossPlatformResource get(int id) throws InvalidOperationException, TException {
        return new CrossPlatformResource();
    }

    public void save(CrossPlatformResource resource) throws InvalidOperationException, TException {
        System.out.println("save");
    }

    public List<CrossPlatformResource> getList() throws InvalidOperationException, TException {
        return Collections.emptyList();
    }

    public boolean ping() throws InvalidOperationException, TException {
        return true;
    }
}
