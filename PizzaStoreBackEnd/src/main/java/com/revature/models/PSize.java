package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class PSize {
	@Id
	@Column(name = "ps_id")
	@SequenceGenerator(sequenceName="psize_id_maker", name="ps_seq")
    @GeneratedValue(generator="ps_seq", strategy=GenerationType.SEQUENCE)
	private int psize_id;
	
	private String psize_name;
	private int multiplier;
	
	public PSize() {
		super();
	}

	public PSize(int psize_id, String psize_name, int multiplier) {
		super();
		this.psize_id = psize_id;
		this.psize_name = psize_name;
		this.multiplier = multiplier;
	}

	public int getPsize_id() {
		return psize_id;
	}

	public void setPsize_id(int psize_id) {
		this.psize_id = psize_id;
	}

	public String getPsize_name() {
		return psize_name;
	}

	public void setPsize_name(String psize_name) {
		this.psize_name = psize_name;
	}

	public int getMultiplier() {
		return multiplier;
	}

	public void setMultiplier(int multiplier) {
		this.multiplier = multiplier;
	}

	@Override
	public String toString() {
		return "PSize [psize_id=" + psize_id + ", psize_name=" + psize_name + ", multiplier=" + multiplier + "]";
	}
	
}
