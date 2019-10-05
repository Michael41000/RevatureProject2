package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.PSize;
import com.revature.repositories.PSizeRepository;

@Service
public class PSizeServiceImpl implements PSizeService {

	@Autowired
	PSizeRepository psizer;
	
	@Override
	public PSize createPSize(PSize pSize) {
		psizer.save(pSize);
		return pSize;
	}

	@Override
	public PSize getPSizeById(int id) {
		return psizer.findById(id).get();
	}

	@Override
	public PSize updatePSize(PSize pSize) {
		psizer.save(pSize);
		return pSize;
	}

	@Override
	public PSize deletePSize(PSize pSize) {
		psizer.delete(pSize);
		return pSize;
	}

	@Override
	public List<PSize> getAllPSizes() {
		return (List<PSize>) psizer.findAll();
	}


}
