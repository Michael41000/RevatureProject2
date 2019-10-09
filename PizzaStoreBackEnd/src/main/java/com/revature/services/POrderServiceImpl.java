package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.POrder;
import com.revature.models.Person;
import com.revature.repositories.POrderRepository;

@Service
public class POrderServiceImpl implements POrderService {

	@Autowired
	POrderRepository porderr;
	
	
	@Override
	public POrder createPOrder(POrder pOrder) {
		porderr.save(pOrder);
		return pOrder;
	}

	@Override
	public POrder getPOrderById(int id) {
		return porderr.findById(id).get();
	}

	@Override
	public POrder updatePOrder(POrder pOrder) {
		porderr.save(pOrder);
		return pOrder;
	}

	@Override
	public POrder deletePOrder(POrder pOrder) {
		porderr.delete(pOrder);
		return pOrder;
	}

	@Override
	public List<POrder> findAllPOrders() {
		return (List<POrder>) porderr.findAll();
	}

	@Override
	public List<POrder> customerViewOrders(int personId) {
		return porderr.findByPersonPersonId(personId);
	}

	@Override
	public List<POrder> findAllPOrderByStoreId(int storeId) {
		return porderr.findByStoreStoreId(storeId);
	}

	@Override
	public List<POrder> getPOrdersByStore(int storeId) {
		return porderr.findByStoreStoreIdOrderByTimeOrdered(storeId);
	}

}
