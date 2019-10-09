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
	
	public List<POrder> customerViewOrders(Person person);

	public List<POrder> getPOrdersByStore(int storeId);
}
