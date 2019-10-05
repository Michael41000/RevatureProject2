package com.revature.models;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "porder")
public class POrder {
	@Id
	@Column(name = "po_id")
	@SequenceGenerator(sequenceName = "porder_id_maker", name = "po_seq")
	@GeneratedValue(generator = "po_seq", strategy = GenerationType.SEQUENCE)
	private int porderId;

	@ManyToOne
	@JoinColumn(name = "person_id")
	private Person person;

	@ManyToOne
	@JoinColumn(name = "store_id")
	private Store store;

	@Column(name = "minutes_to_make")
	private int minutesToMake;

	@Column(name = "time")
	private Timestamp timeOrdered;

	@ManyToOne
	@JoinColumn(name = "coupon_id")
	private Coupon coupon;

	@ManyToMany
	@JoinTable(name = "porder_pizza", joinColumns = @JoinColumn(name = "porder_id"), inverseJoinColumns = @JoinColumn(name = "pizza_id"))
	private List<Pizza> pizzasInOrder;

	public POrder() {
		super();
	}

	public POrder(Person person, Store store, int minutesToMake, Timestamp timeOrdered, Coupon coupon,
			List<Pizza> pizzasInOrder) {
		super();
		this.person = person;
		this.store = store;
		this.minutesToMake = minutesToMake;
		timeOrdered.setNanos(0);
		this.timeOrdered = timeOrdered;
		this.coupon = coupon;
		this.pizzasInOrder = pizzasInOrder;
	}

	public POrder(int porderId, Person person, Store store, int minutesToMake, Timestamp timeOrdered, Coupon coupon,
			List<Pizza> pizzasInOrder) {
		super();
		this.porderId = porderId;
		this.person = person;
		this.store = store;
		this.minutesToMake = minutesToMake;
		timeOrdered.setNanos(0);
		this.timeOrdered = timeOrdered;
		this.coupon = coupon;
		this.pizzasInOrder = pizzasInOrder;
	}

	public int getPorderId() {
		return porderId;
	}

	public void setPorderId(int porderId) {
		this.porderId = porderId;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public int getMinutesToMake() {
		return minutesToMake;
	}

	public void setMinutesToMake(int minutesToMake) {
		this.minutesToMake = minutesToMake;
	}

	public Timestamp getTimeOrdered() {
		return timeOrdered;
	}

	public void setTimeOrdered(Timestamp timeOrdered) {
		timeOrdered.setNanos(0);
		this.timeOrdered = timeOrdered;
	}

	public Coupon getCoupon() {
		return coupon;
	}

	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}

	public List<Pizza> getPizzasInOrder() {
		return pizzasInOrder;
	}

	public void setPizzasInOrder(List<Pizza> pizzasInOrder) {
		this.pizzasInOrder = pizzasInOrder;
	}

	@Override
	public String toString() {
		return "POrder [porderId=" + porderId + ", person=" + person + ", store=" + store + ", minutesToMake="
				+ minutesToMake + ", timeOrdered=" + timeOrdered + ", coupon=" + coupon + ", pizzasInOrder="
				+ pizzasInOrder + "]";
	}
}
