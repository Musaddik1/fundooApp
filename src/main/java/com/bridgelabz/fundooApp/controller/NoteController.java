package com.bridgelabz.fundooApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.fundooApp.dto.NoteDto;
import com.bridgelabz.fundooApp.model.Note;
import com.bridgelabz.fundooApp.response.Response;
import com.bridgelabz.fundooApp.service.NoteService;

@RestController
@RequestMapping("/Note")
public class NoteController {

	@Autowired
	private NoteService noteService;

	@PostMapping("/create")
	public ResponseEntity<Response> createNote(@RequestBody NoteDto noteDto, @RequestParam String token)

	{
		Response response = noteService.createNote(noteDto, token);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Response> updateNote(@RequestBody NoteDto noteDto, @RequestParam String noteId,
			@RequestParam String token) {
		Response response = noteService.updateNote(noteDto, noteId, token);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Response> deleteNote(@RequestParam String noteId, @RequestParam String token) {
		Response response = noteService.deleteNote(noteId, token);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@GetMapping("/getNote")
	public Note getNote(@RequestParam String noteId, @RequestParam String token) {
		Note note = noteService.getNote(noteId, token);
		return note;
	}

	@GetMapping("/getAll")
	public List<Note> getAllNote(@RequestParam String token) {
		List<Note> noteList = noteService.getAllNote(token);
		return noteList;
	}

	@GetMapping("/getTrash")
	public List<Note> getTrash(@RequestParam String token) {
		List<Note> noteslist = noteService.getTrash(token);
		return noteslist;
	}

	@GetMapping("/getArchive")
	public List<Note> getArchive(@RequestParam String token) {
		List<Note> noteslist = noteService.getArchive(token);
		return noteslist;
	}
}
