package com.Nakka.DMS.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Trainer {
	@Id
	private int TrainerId;
	private String trainerName;
	private String trainerAddress;

	public int getTrainerId() {
		return TrainerId;
	}

	public void setTrainerId(int trainerId) {
		TrainerId = trainerId;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public String getTrainerAddress() {
		return trainerAddress;
	}

	public void setTrainerAddress(String trainerAddress) {
		this.trainerAddress = trainerAddress;

	}

	@Override
	public String toString() {
		return "Trainer [TrainerId=" + TrainerId + ", trainerName=" + trainerName + ", trainerAddress=" + trainerAddress
				+ "]";
	}

}
