package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
			@Id
			private int hno;
			private String street;
			private String city;
			public int getHno() {
				return hno;
			}
			public void setHno(int hno) {
				this.hno = hno;
			}
			public String getStreet() {
				return street;
			}
			public void setStreet(String street) {
				this.street = street;
			}
			public String getCity() {
				return city;
			}
			public void setCity(String city) {
				this.city = city;
			}
}
