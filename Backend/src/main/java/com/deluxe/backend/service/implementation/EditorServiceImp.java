package com.deluxe.backend.service.implementation;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deluxe.backend.model.Editor;
import com.deluxe.backend.repository.IEditorRepository;
import com.deluxe.backend.service.IEditorService;


@Service
public class EditorServiceImp implements IEditorService {
	
	@Autowired
	IEditorRepository editorRepository;
	
	@Override
	public List<Editor> getAll() {
		// TODO Auto-generated method stub
		return (List<Editor>) editorRepository.findAll();
	}

	@Override
	public Editor getByID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Editor getEmpty() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Editor setObject(Editor o) {
		Editor editor = new Editor();
		editor = o;
		//Si cargo la fecha desde el front da error
		o.setFechaCreacion(LocalDate.now());
		return editorRepository.save(editor);
		
	}

	@Override
	public void modObject(Editor o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delObject(Long id) {
		// TODO Auto-generated method stub

	}

}
