package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "topping_type")
public class ToppingType {
	@Id
	@SequenceGenerator(sequenceName = "tt_id_maker", name = "tt_seq")
	@GeneratedValue(generator = "tt_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "tt_id")
	private int ttId;
	@Column(name = "type")
	private String type;

	public ToppingType() {
		super();
	}

	public ToppingType(String type) {
		super();
		this.type = type;
	}

	public ToppingType(int ttId, String type) {
		super();
		this.ttId = ttId;
		this.type = type;
	}

	public int getTtId() {
		return ttId;
	}

	public void setTtId(int ttId) {
		this.ttId = ttId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ToppingType [ttId=" + ttId + ", type=" + type + "]";
	}

}
