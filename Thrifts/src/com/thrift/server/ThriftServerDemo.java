package com.thrift.server;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;

import com.thrift.QueryImp;
import com.thrift.TestQry;

public class ThriftServerDemo {

	TServer server = null;
	public static final int SERVER_PORT=8900;
	
	public static void main(String[] args) throws TTransportException{
		TProcessor tprocessor = new TestQry.Processor<TestQry.Iface>(new QueryImp());
		TNonblockingServerSocket serverSocket = new TNonblockingServerSocket(SERVER_PORT);
		TNonblockingServer.Args tArgs = new TNonblockingServer.Args(serverSocket);
		tArgs.processor(tprocessor);  
        tArgs.transportFactory(new TFramedTransport.Factory());  
        //ʹ�ø��ܶȶ�����Э��   
        tArgs.protocolFactory(new TCompactProtocol.Factory());  
        // ʹ�÷�����ʽIO������˺Ϳͻ�����Ҫָ��TFramedTransport���ݴ���ķ�ʽ  
        TServer server = new TNonblockingServer(tArgs);  
        System.out.println("QueryTestServer start....");  
        server.serve(); // ��������  
		
	}
}
