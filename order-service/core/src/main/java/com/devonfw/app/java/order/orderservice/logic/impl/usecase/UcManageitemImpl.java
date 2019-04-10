package com.devonfw.app.java.order.orderservice.logic.impl.usecase;

import java.util.Objects;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.devonfw.app.java.order.orderservice.dataaccess.api.ItemEntity;
import com.devonfw.app.java.order.orderservice.logic.api.to.ItemEto;
import com.devonfw.app.java.order.orderservice.logic.api.usecase.UcManageItem;
import com.devonfw.app.java.order.orderservice.logic.base.usecase.AbstractItemUc;

@Named
@Validated
@Transactional
public class UcManageitemImpl extends AbstractItemUc implements UcManageItem {

	/** Logger instance. */
	private static final Logger LOG = LoggerFactory.getLogger(UcManageCustomerImpl.class);

	@Override
	public boolean deleteItem(long itemId) {
		ItemEntity item = getItemRepository().find(itemId);
		getItemRepository().delete(item);
		LOG.debug("The item with id '{}' has been deleted.", itemId);
		return true;
	}



	@Override
	public ItemEto saveItem(ItemEto item) {
		Objects.requireNonNull(item, "item");
		ItemEntity itemEntity = getBeanMapper().map(item, ItemEntity.class);

		ItemEntity resultEntity = getItemRepository().save(itemEntity);
		LOG.debug("Item with id '{}' has been created.", resultEntity.getId());

		return getBeanMapper().map(resultEntity, ItemEto.class);
	}


}
