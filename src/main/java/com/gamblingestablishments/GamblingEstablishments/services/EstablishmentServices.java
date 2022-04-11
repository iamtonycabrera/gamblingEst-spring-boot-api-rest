package com.gamblingestablishments.GamblingEstablishments.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

import com.gamblingestablishments.GamblingEstablishments.model.Establishment;

@Service
public class EstablishmentServices {

	private static List<Establishment> establishments;

	public List<Establishment> getEstablishment() {
		if (establishments == null)
			establishments = new ArrayList<>();
		return establishments;
	}

	public Establishment getEstablishmentById(int id) {
		Establishment establishment = null;
		int index = findEstablishmentIndexById(id);
		if (index != -1)
			establishment = establishments.get(index);
		return establishment;
	}

	public List<Establishment> getEstablishments() {
		if (establishments != null)
			return establishments;
		return null;
	}

	public void createEstablishment(Establishment estParam) {

		if (establishments == null)
			establishments = new ArrayList<>();

		Establishment est = new Establishment();
		est.setId(est.getId());
		est.setName(estParam.getName());
		est.setLocation(estParam.getLocation());

		Date date = new Date();
		est.setCreatedDate(date);

		establishments.add(est);
	}

	public void deleteEstablishmentById(int id) {
		if (findEstablishmentIndexById(id) != -1)
			establishments.remove(findEstablishmentIndexById(id));
	}

	public int findEstablishmentIndexById(int id) {
		int i = 0;
		int index = -1;
		boolean found = false;
		while (i < establishments.size() && !found) {
			if (establishments.get(i).getId() == id) {
				found = true;
				index = i;
			}
			i++;
		}
		return index;
	}
}
