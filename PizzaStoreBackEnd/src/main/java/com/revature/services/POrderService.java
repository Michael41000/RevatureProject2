package com.revature.services;

import java.util.List;

import com.revature.models.POrder;

public interface POrderService {
	public POrder createPOrder(POrder pOrder);

	public POrder getPOrderById(int id);

	public POrder updatePOrder(POrder pOrder);

	public POrder deletePOrder(POrder pOrder);
	
	public List<POrder> findAllPOrders();
}
