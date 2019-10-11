package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "psize")
public class PSize {
	@Id
	@Column(name = "ps_id")
	@SequenceGenerator(sequenceName = "psize_id_maker", name = "ps_seq", allocationSize = 1)
	@GeneratedValue(generator = "ps_seq", strategy = GenerationType.SEQUENCE)
	private int psizeId;

	@Column(name = "psize_name")
	private String psizeName;

	@Column(name = "multipler")
	private int multiplier;

	public PSize() {
		super();
	}

	public PSize(String psizeName, int multiplier) {
		super();
		this.psizeName = psizeName;
		this.multiplier = multiplier;
	}

	public PSize(int psizeId, String psizeName, int multiplier) {
		super();
		this.psizeId = psizeId;
		this.psizeName = psizeName;
		this.multiplier = multiplier;
	}

	public int getPsizeId() {
		return psizeId;
	}

	public void setPsizeId(int psizeId) {
		this.psizeId = psizeId;
	}

	public String getPsizeName() {
		return psizeName;
	}

	public void setPsizeName(String psizeName) {
		this.psizeName = psizeName;
	}

	public int getMultiplier() {
		return multiplier;
	}

	public void setMultiplier(int multiplier) {
		this.multiplier = multiplier;
	}

	@Override
	public String toString() {
		return "PSize [psizeId=" + psizeId + ", psizeName=" + psizeName + ", multiplier=" + multiplier + "]";
	}
}
