package dev.fringe.hibenate.reactive;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity @Table(name="T_ACCOUNT") @Data
public class Account {
	@Id
	private Long id;
	private double cashBalance;
	private String name;
}
