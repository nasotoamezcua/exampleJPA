package com.example.demo.dto.cloud;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UbicacionDTO {
	
	private Long id;
	@JsonProperty("pais")
	private PaisDTO paisDto;
	@JsonProperty("entidad")
	private EntidadDTO entidadDto;
	@JsonProperty("municipio")
	private MunicipioDTO municipioDto;
	@JsonProperty("localidad")
	private LocalidadDTO localidadDto;
	@JsonProperty("asentamiento")
	private AsentamientoDTO asentamientoDto;
	@JsonProperty("entidadExtrangero")
	private String entidad_text;
	@JsonProperty("municipioExtrangero")
	private String municipio_text;
	@JsonProperty("asentamientoExtrangero")
	private String asentamiento_text;
	@JsonProperty("localidadExtrangero")
	private String localidad_text;
	private String calle;
	private String numeroExt;
	private String numeroInt;
	private String cp;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public PaisDTO getPaisDto() {
		return paisDto;
	}
	public void setPaisDto(PaisDTO paisDto) {
		this.paisDto = paisDto;
	}
	public EntidadDTO getEntidadDto() {
		return entidadDto;
	}
	public void setEntidadDto(EntidadDTO entidadDto) {
		this.entidadDto = entidadDto;
	}
	public MunicipioDTO getMunicipioDto() {
		return municipioDto;
	}
	public void setMunicipioDto(MunicipioDTO municipioDto) {
		this.municipioDto = municipioDto;
	}
	public LocalidadDTO getLocalidadDto() {
		return localidadDto;
	}
	public void setLocalidadDto(LocalidadDTO localidadDto) {
		this.localidadDto = localidadDto;
	}
	public AsentamientoDTO getAsentamientoDto() {
		return asentamientoDto;
	}
	public void setAsentamientoDto(AsentamientoDTO asentamientoDto) {
		this.asentamientoDto = asentamientoDto;
	}
	public String getEntidad_text() {
		return entidad_text;
	}
	public void setEntidad_text(String entidad_text) {
		this.entidad_text = entidad_text;
	}
	public String getMunicipio_text() {
		return municipio_text;
	}
	public void setMunicipio_text(String municipio_text) {
		this.municipio_text = municipio_text;
	}
	public String getAsentamiento_text() {
		return asentamiento_text;
	}
	public void setAsentamiento_text(String asentamiento_text) {
		this.asentamiento_text = asentamiento_text;
	}
	public String getLocalidad_text() {
		return localidad_text;
	}
	public void setLocalidad_text(String localidad_text) {
		this.localidad_text = localidad_text;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumeroExt() {
		return numeroExt;
	}
	public void setNumeroExt(String numeroExt) {
		this.numeroExt = numeroExt;
	}
	public String getNumeroInt() {
		return numeroInt;
	}
	public void setNumeroInt(String numeroInt) {
		this.numeroInt = numeroInt;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
}
