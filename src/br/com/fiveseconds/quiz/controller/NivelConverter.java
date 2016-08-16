package br.com.fiveseconds.quiz.controller;

import org.springframework.core.convert.converter.Converter;

import br.com.fiveseconds.quiz.dao.DisciplinaDao;
import br.com.fiveseconds.quiz.dao.NivelDao;
import br.com.fiveseconds.quiz.model.Disciplina;
import br.com.fiveseconds.quiz.model.Nivel;

public class NivelConverter implements Converter<String, Nivel> {

	public Nivel convert(String id) {
		NivelDao dao = new NivelDao();
		return dao.buscarPorId(Integer.valueOf(id));
	}

}
