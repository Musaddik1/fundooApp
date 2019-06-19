package com.bridgelabz.fundooApp.service;



import java.util.List;

import com.bridgelabz.fundooApp.dto.NoteDto;
import com.bridgelabz.fundooApp.model.Note;
import com.bridgelabz.fundooApp.response.Response;

public interface NoteService {

	Response createNote(NoteDto noteDto,String token);
	Response updateNote(NoteDto noteDto,String noteId,String token);
	Response deleteNote(String noteId,String token);
	Response archiveNote(String noteId,String token);
	Note getNote(String noteId,String token);
	List<Note> getAllNote(String token);
	List<Note> getTrash(String token);
	List<Note> getArchive(String token);
}
