package br.com.fiveseconds.quiz.controller;

import org.springframework.core.convert.converter.Converter;

import br.com.fiveseconds.quiz.dao.DisciplinaDao;
import br.com.fiveseconds.quiz.model.Disciplina;

public class DisciplinaConverter implements Converter<String, Disciplina> {

	public Disciplina convert(String id) {

		if (id != null && !id.equals("")) {
			DisciplinaDao dao = new DisciplinaDao();
			return dao.buscarPorId(Integer.valueOf(id));
		} else {
			return null;
		}
	}
}
