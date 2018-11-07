package com.example.demo.dto.cloud;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonaDomicilioDTO {
	
	
	private Long id;
	private String fecha;
	private String cadena;
	@JsonProperty("persona")
	private PersonaDTO personaDto;
	@JsonProperty("acto")
	private ActoDTO actoDto;
	@JsonProperty("participante")
	private ParticipanteDTO participanyteDto;
	@JsonProperty("ubicacion")
	private UbicacionDTO ubicacionDto;
	@JsonProperty("mensaje")
	private String mensaje;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getCadena() {
		return cadena;
	}
	public void setCadena(String cadena) {
		this.cadena = cadena;
	}
	public PersonaDTO getPersonaDto() {
		return personaDto;
	}
	public void setPersonaDto(PersonaDTO personaDto) {
		this.personaDto = personaDto;
	}
	public ActoDTO getActoDto() {
		return actoDto;
	}
	public void setActoDto(ActoDTO actoDto) {
		this.actoDto = actoDto;
	}
	public ParticipanteDTO getParticipanyteDto() {
		return participanyteDto;
	}
	public void setParticipanyteDto(ParticipanteDTO participanyteDto) {
		this.participanyteDto = participanyteDto;
	}
	public UbicacionDTO getUbicacionDto() {
		return ubicacionDto;
	}
	public void setUbicacionDto(UbicacionDTO ubicacionDto) {
		this.ubicacionDto = ubicacionDto;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
