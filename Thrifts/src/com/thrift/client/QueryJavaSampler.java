package com.thrift.client;

import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.thrift.TException;

public class QueryJavaSampler extends AbstractJavaSamplerClient {

	@Override
	public SampleResult runTest(JavaSamplerContext arg0) {
		// TODO Auto-generated method stub
		
		SampleResult result = new SampleResult();
		result.sampleStart();
		try {
			ThriftClientDemo.start();
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result.setSuccessful(true);
		result.sampleEnd();
		return null;
	}

}
