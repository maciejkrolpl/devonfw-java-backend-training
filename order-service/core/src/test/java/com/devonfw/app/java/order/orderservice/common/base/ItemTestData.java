package com.devonfw.app.java.order.orderservice.common.base;

public interface ItemTestData {


	  ItemEtoBuilder CHEESE = ItemEtoBuilder.anItemEto()
	      .withName("cheese")
	      .withPrice(12.50);

	  ItemEtoBuilder CORN = ItemEtoBuilder.anItemEto()
			  .withName("corn")
			  .withPrice(7.49);

	  ItemEtoBuilder BEER = ItemEtoBuilder.anItemEto()
			  .withName("beer")
			  .withPrice(5.00);



}
