package com.devonfw.app.java.order.orderservice.logic.impl.usecase;

import java.util.Set;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.devonfw.app.java.order.orderservice.dataaccess.api.ItemEntity;
import com.devonfw.app.java.order.orderservice.logic.api.to.ItemEto;
import com.devonfw.app.java.order.orderservice.logic.api.to.ItemSearchCriteriaTo;
import com.devonfw.app.java.order.orderservice.logic.api.usecase.UcFindItem;
import com.devonfw.app.java.order.orderservice.logic.base.usecase.AbstractItemUc;
import com.devonfw.app.java.order.orderservice.logic.impl.util.ItemSearchCriteriaUtil;

@Named
@Validated
@Transactional
public class UcFindItemImpl extends AbstractItemUc implements UcFindItem {

	/**
	 * Logger instance.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(UcFindItemImpl.class);

	@Override
	public ItemEto findItem(long id) {
		LOG.debug("Get item with id {} from database", id);
		ItemEntity foundEntity = getItemRepository().getOne(id);
		return getBeanMapper().map(foundEntity, ItemEto.class);
	}

	@Override
	public Page<ItemEto> findItems(ItemSearchCriteriaTo criteria) {
		Page<ItemEntity> items = getItemRepository().findByCriteria(criteria);
		return mapPaginatedEntityList(items, ItemEto.class);
	}

	@Override
	public Set<ItemEto> findByName(String name) {
		Set<ItemEntity> foundByName = getItemRepository().findByName(name);
		return getBeanMapper().mapSet(foundByName, ItemEto.class);
	}

	  @Override
	  public Page<ItemEto> findItemsWithNameLikeOrdered(String name) {
	    ItemSearchCriteriaTo criteria = ItemSearchCriteriaUtil.createDefaultSearchCriteria(name);
	    return this.findItems(criteria);
	  }

}
