package com.ty.hospital_app.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Observation 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int oid;
	private String doctor_name;
	private String reason_observation;
	@ManyToOne
	@JoinColumn
	private Encounter encounters;
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getDoctor_name() {
		return doctor_name;
	}
	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}
	public String getReason_observation() {
		return reason_observation;
	}
	public void setReason_observation(String reason_observation) {
		this.reason_observation = reason_observation;
	}
	public Encounter getEncounters() {
		return encounters;
	}
	public void setEncounters(Encounter encounters) {
		this.encounters = encounters;
	}

}
