package com.revature.services;

import java.util.List;

import com.revature.models.PSize;

public interface PSizeService {
	public PSize createPSize(PSize pSize);

	public PSize getPSizeById(int id);

	public PSize updatePSize(PSize pSize);

	public PSize deletePSize(PSize pSize);
	
	public List<PSize> getAllPSizes();
}
