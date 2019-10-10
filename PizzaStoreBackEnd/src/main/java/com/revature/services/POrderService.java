package com.revature.services;

import java.util.List;

import com.revature.models.POrder;
import com.revature.models.Person;

public interface POrderService {
	public POrder createPOrder(POrder pOrder);

	public POrder getPOrderById(int id);

	public POrder updatePOrder(POrder pOrder);

	public POrder deletePOrder(POrder pOrder);
	
	public List<POrder> findAllPOrders();

	public List<POrder> getPOrdersByStore(int storeId);
	public List<POrder> customerViewOrders(int personId);
	
	public List<POrder> findAllPOrderByStoreId(int storeId);
}
