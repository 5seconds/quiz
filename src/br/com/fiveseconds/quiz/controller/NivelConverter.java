package br.com.fiveseconds.quiz.controller;

import org.springframework.core.convert.converter.Converter;

import br.com.fiveseconds.quiz.dao.NivelDao;
import br.com.fiveseconds.quiz.model.Nivel;

public class NivelConverter implements Converter<String, Nivel> {

	public Nivel convert(String id) {

		if (id != null && !id.equals("")) {
			NivelDao dao = new NivelDao();
			return dao.buscarPorId(Integer.valueOf(id));
		} else {
			return null;
		}
	}

}
