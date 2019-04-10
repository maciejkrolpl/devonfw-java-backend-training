package com.devonfw.app.java.order.orderservice.logic.impl;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import com.devonfw.app.java.order.orderservice.common.base.ItemTestData;
import com.devonfw.app.java.order.orderservice.logic.api.OrderService;
import com.devonfw.app.java.order.orderservice.logic.api.to.ItemEto;
import com.devonfw.module.test.common.base.ComponentTest;

@Transactional
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class OrderServiceImplTest extends ComponentTest {

  @Inject
  private OrderService orderService;

  @Test
  public void shouldFindNamesLikeEE() {
	  //given
	  prepareItems();
	  String name = "Ee";

	  //when
	  Page<ItemEto> foundItems = orderService.findItemsWithNameLikeOrdered(name);

	  //then
	  assertThat(foundItems).isNotEmpty();



  }

  private void prepareItems() {
	  orderService.saveItem(ItemTestData.BEER.build());
	  orderService.saveItem(ItemTestData.CORN.build());
	  orderService.saveItem(ItemTestData.CHEESE.build());
  }

}
