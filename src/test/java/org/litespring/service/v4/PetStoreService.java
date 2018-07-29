package org.litespring.service.v4;

import org.litespring.beans.factory.annotation.Autowired;
import org.litespring.dao.v3.AccountDao;
import org.litespring.dao.v3.ItemDao;
import org.litespring.stereotype.Component;
import org.litespring.stereotype.TestMy;

@Component(value="petStore")
@TestMy(value = "hahaha")
public class PetStoreService {
	@Autowired
	private AccountDao accountDao;
	@Autowired
	private ItemDao itemDao;
	
	public AccountDao getAccountDao() {
		return accountDao;
	}

	public ItemDao getItemDao() {
		return itemDao;
	}
	
	
}