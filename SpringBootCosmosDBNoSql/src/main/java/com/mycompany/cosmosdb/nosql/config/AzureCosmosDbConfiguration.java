package com.mycompany.cosmosdb.nosql.config;

import org.springframework.beans.factory.annotation.Value;

import com.azure.spring.data.cosmos.config.AbstractCosmosConfiguration;

//@Configuration
//@EnableCosmosRepositories
public class AzureCosmosDbConfiguration extends AbstractCosmosConfiguration	{
	@Value("${spring.cloud.azure.cosmos.endpoint}")
	private String uri;
	
	@Value("${spring.cloud.azure.cosmos.database}")
	private String dbname;
	
	@Value("${spring.cloud.azure.cosmos.key}")
	private String key;
	
	//private CosmosKeyCredential cosmosKeyCredential;

	@Override
	protected String getDatabaseName() {
		// TODO Auto-generated method stub
		return null;
	}
}
