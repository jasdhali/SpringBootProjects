package com.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.example.model.ProductInfo;
import com.example.repository.ProductInfoRepository;

public class ProductInfoRepositoryIntegrationTest {
	private DynamoDBMapper dynamoDBMapper;
	@Autowired
	private AmazonDynamoDB amazonDynamoDB;

	@Autowired
	ProductInfoRepository repository;

	private static final String EXPECTED_COST = "20";
	private static final String EXPECTED_PRICE = "50";

	@BeforeAll
	public void setup() throws Exception {
		dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
		CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(ProductInfo.class);
		tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));
		amazonDynamoDB.createTable(tableRequest);

		Iterable<ProductInfo> productInfos = repository.findAll();

		productInfos.forEach(product -> System.out.println(product.getCost()));

		dynamoDBMapper.batchDelete((List<ProductInfo>) repository.findAll());

	}
	
	@Test
	public void  givenItemWithExpectedCost_whenRunFindAll_thenItemIsFound() {
		ProductInfo productInfo = new ProductInfo(EXPECTED_COST, EXPECTED_PRICE);
		repository.save( productInfo );
		List<ProductInfo> result = (List<ProductInfo>) repository.findAll();
		//assertThat( result.size() , is(greaterThan(0)));
		assertTrue( result.size() > 0 );
	}
}
