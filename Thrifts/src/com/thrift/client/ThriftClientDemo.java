package com.thrift.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import com.thrift.QryResult;
import com.thrift.TestQry;

public class ThriftClientDemo {

	public static final String SERVER_IP = "127.0.0.1";  
    public static final int SERVER_PORT = 8900;  
    public static final int TIMEOUT = 30000;  
    private final static int DEFAULT_QRY_CODE = 1;
  
    public static void start() throws TException {  
        //���ô���ͨ�������ڷ�����������Ҫʹ��TFramedTransport���������ݷֿ鷢��    
        TTransport transport = new TFramedTransport(new TSocket(SERVER_IP, SERVER_PORT, TIMEOUT));  
        // Э��Ҫ�ͷ����һ��  
        //HelloTNonblockingServer  
        ////ʹ�ø��ܶȶ�����Э��   
        TProtocol protocol = new TCompactProtocol(transport);  
        //HelloTHsHaServer  
        ////ʹ�ö�����Э��   
        //TProtocol protocol = new TBinaryProtocol(transport);  
        TestQry.Client client = new TestQry.Client(protocol);  
        transport.open();  
        QryResult result = client.qryTest(DEFAULT_QRY_CODE);  
        System.out.println("result : " + result);  
        //�ر���Դ  
        transport.close();  
    }  
}
