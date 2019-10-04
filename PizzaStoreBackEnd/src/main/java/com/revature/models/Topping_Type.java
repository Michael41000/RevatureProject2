package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Topping_Type")
public class Topping_Type {
	@Id
	@SequenceGenerator(sequenceName = "tt_id_maker", name = "a_seq")
	@GeneratedValue(generator = "a_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "tt_id")
	private int tt_id;
	@Column(name = "type")
	private String type;

	public Topping_Type() {
		super();
	}

	public Topping_Type(int tt_id, String type) {
		super();
		this.tt_id = tt_id;
		this.type = type;
	}

	public int getTt_id() {
		return tt_id;
	}

	public void setTt_id(int tt_id) {
		this.tt_id = tt_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Topping_Type [tt_id=" + tt_id + ", type=" + type + "]";
	}
}
