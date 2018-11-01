package com.example.demo.service.impl.cloud;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.cloud.ActoDTO;
import com.example.demo.dto.cloud.AsentamientoDTO;
import com.example.demo.dto.cloud.EntidadDTO;
import com.example.demo.dto.cloud.LocalidadDTO;
import com.example.demo.dto.cloud.MunicipioDTO;
import com.example.demo.dto.cloud.PaisDTO;
import com.example.demo.dto.cloud.ParticipanteDTO;
import com.example.demo.dto.cloud.PersonaDTO;
import com.example.demo.dto.cloud.PersonaDomicilioDTO;
import com.example.demo.dto.cloud.TipoAsentamientoDTO;
import com.example.demo.dto.cloud.TipoLocalidadDto;
import com.example.demo.dto.cloud.UbicacionDTO;
import com.example.demo.service.cloud.IPersonaDomicilioCloud;

import feign.FeignException;

@Service
public class PersonaDomicilioService {
	
	@Autowired
	IPersonaDomicilioCloud personaDomicilioCloud;
	
	public List<PersonaDomicilioDTO> findByDomiciliosService(String curp) throws FeignException{
		
			List<PersonaDomicilioDTO> listPersonaDomicilioDTO = null;
			
			String StringJSON = personaDomicilioCloud.findByDomiciliosCloud(curp);
			System.out.println("StringJSON: " + StringJSON);
			
			if(StringJSON != null) {
				
				listPersonaDomicilioDTO = new ArrayList<PersonaDomicilioDTO>();
				JSONArray arrayJSON = new JSONArray(StringJSON);
				
				if(arrayJSON != null) {
					for(int i=0; i<arrayJSON.length(); i++) {
						
						JSONObject psdomiJSON = arrayJSON.getJSONObject(i);
						
						if(psdomiJSON != null) {
							PersonaDomicilioDTO personaDomicilioDTO = new PersonaDomicilioDTO();
							personaDomicilioDTO.setId(psdomiJSON.isNull("fecha") ? -1 : psdomiJSON.getLong("id"));
							personaDomicilioDTO.setFecha(psdomiJSON.isNull("fecha") ? "" : psdomiJSON.getString("fecha"));
							personaDomicilioDTO.setCadena(psdomiJSON.isNull("cadena") ? "" : psdomiJSON.getString("cadena"));
							
							
							if(!psdomiJSON.isNull("personaDto")) {
								JSONObject personaJSON = psdomiJSON.getJSONObject("personaDto");
								
								PersonaDTO personaDTO = new PersonaDTO();
								personaDTO.setId(personaJSON.isNull("id") ? -1 : personaJSON.getLong("id"));
								personaDTO.setNombre(personaJSON.isNull("nombre") ? "" : personaJSON.getString("nombre"));
								personaDTO.setPrimerApellido(personaJSON.isNull("primerApellido") ? "" : personaJSON.getString("primerApellido"));
								personaDTO.setSegundoApellido(personaJSON.isNull("segundoApellido") ? "" : personaJSON.getString("segundoApellido"));
								personaDTO.setSexo(personaJSON.isNull("sexo") ? "" : personaJSON.getString("sexo"));
								if(!personaJSON.isNull("sexo"))	personaDTO.setFinado(personaJSON.getBoolean("finado"));
								
								personaDomicilioDTO.setPersonaDto(personaDTO);
							}
							
							if(!psdomiJSON.isNull("actoDto")) {
								JSONObject actoJSON = psdomiJSON.getJSONObject("actoDto");
								
								ActoDTO actoDTO = new ActoDTO();
								actoDTO.setId(actoJSON.isNull("id") ? -1 : actoJSON.getInt("id"));
								actoDTO.setNombre(actoJSON.isNull("nombre") ? "" : actoJSON.getString("nombre"));
								
								personaDomicilioDTO.setActoDto(actoDTO);
							}
							
							if(!psdomiJSON.isNull("participanyteDto")) {
								JSONObject participanteJSON = psdomiJSON.getJSONObject("participanyteDto");
								
								ParticipanteDTO participanteDTO = new ParticipanteDTO();
								participanteDTO.setId(participanteJSON.isNull("id") ? -1 : participanteJSON.getInt("id"));
								participanteDTO.setNombre(participanteJSON.isNull("nombre") ? "" : participanteJSON.getString("nombre"));
								
								personaDomicilioDTO.setParticipanyteDto(participanteDTO);
							}
							
							if(!psdomiJSON.isNull("ubicacionDto")) {
								JSONObject ubicacionJSON = psdomiJSON.getJSONObject("ubicacionDto");
								
								UbicacionDTO ubicacionDTO = new UbicacionDTO();
								ubicacionDTO.setId(ubicacionJSON.isNull("id") ? -1 : ubicacionJSON.getLong("id"));
								ubicacionDTO.setCalle(ubicacionJSON.isNull("calle") ? "" : ubicacionJSON.getString("calle"));
								ubicacionDTO.setNumeroExt(ubicacionJSON.isNull("numeroExt") ? "" : ubicacionJSON.getString("numeroExt"));
								ubicacionDTO.setNumeroInt(ubicacionJSON.isNull("numeroInt") ? "" : ubicacionJSON.getString("numeroInt"));
								ubicacionDTO.setCp(ubicacionJSON.isNull("cp") ? "" : ubicacionJSON.getString("cp"));
								ubicacionDTO.setAsentamiento_text(ubicacionJSON.isNull("asentamiento_text") ? "" : ubicacionJSON.getString("asentamiento_text"));
								ubicacionDTO.setLocalidad_text(ubicacionJSON.isNull("localidad_text") ? "" : ubicacionJSON.getString("localidad_text"));
								ubicacionDTO.setMunicipio_text(ubicacionJSON.isNull("municipio_text") ? "" : ubicacionJSON.getString("municipio_text"));
								ubicacionDTO.setEntidad_text(ubicacionJSON.isNull("entidad_text") ? "" : ubicacionJSON.getString("entidad_text"));
								
								if(!ubicacionJSON.isNull("paisDto")) {
									JSONObject paisJSON = ubicacionJSON.getJSONObject("paisDto");
									
									PaisDTO paisDTO = new PaisDTO();
									paisDTO.setId(paisJSON.isNull("id") ? -1: paisJSON.getInt("id"));
									paisDTO.setNombre(paisJSON.isNull("nombre") ? "" : paisJSON.getString("nombre"));
									paisDTO.setNacionalidad(paisJSON.isNull("nacionalidad") ? "" : paisJSON.getString("nacionalidad"));
									
									ubicacionDTO.setPaisDto(paisDTO);
								}
								
								if(!ubicacionJSON.isNull("entidadDto")) {
									JSONObject entidadJSON = ubicacionJSON.getJSONObject("entidadDto");
									
									EntidadDTO entidadDTO = new EntidadDTO();
									entidadDTO.setId(entidadJSON.isNull("id") ? -1 : entidadJSON.getInt("id"));
									entidadDTO.setNombre(entidadJSON.isNull("nombre") ? "" : entidadJSON.getString("nombre"));
									
									ubicacionDTO.setEntidadDto(entidadDTO);
								}
								
								if(!ubicacionJSON.isNull("municipioDto")) {
									JSONObject municipioJSON = ubicacionJSON.getJSONObject("municipioDto");
									
									MunicipioDTO municipioDTO = new MunicipioDTO();
									municipioDTO.setId(municipioJSON.isNull("id")? -1 : municipioJSON.getInt("id"));
									municipioDTO.setIdRenapo(municipioJSON.isNull("idRenapo")? -1 : municipioJSON.getInt("idRenapo"));
									municipioDTO.setNombre(municipioJSON.isNull("nombre")? "" : municipioJSON.getString("nombre"));
									
									ubicacionDTO.setMunicipioDto(municipioDTO);
								}
								
								if(!ubicacionJSON.isNull("localidadDto")) {
									JSONObject localidadJSON = ubicacionJSON.getJSONObject("localidadDto");
									
									LocalidadDTO localidadDTO = new LocalidadDTO();
									localidadDTO.setId(localidadJSON.isNull("id") ? -1: localidadJSON.getInt("id"));
									localidadDTO.setNombre(localidadJSON.isNull("nombre") ? "" : localidadJSON.getString("nombre"));
									
									if(!localidadJSON.isNull("tipoLocalidadDto")) {
										JSONObject tipoLocalidadJSON = localidadJSON.getJSONObject("tipoLocalidadDto");
										
										TipoLocalidadDto tipoLocalidadDTO = new TipoLocalidadDto();
										tipoLocalidadDTO.setId(tipoLocalidadJSON.isNull("id") ? -1 : tipoLocalidadJSON.getInt("id"));
										tipoLocalidadDTO.setNombre(tipoLocalidadJSON.isNull("nombre") ? "" : tipoLocalidadJSON.getString("nombre"));
										
										localidadDTO.setTipoLocalidadDto(tipoLocalidadDTO);
									}
									
									ubicacionDTO.setLocalidadDto(localidadDTO);
								}
								
								if(!ubicacionJSON.isNull("asentamientoDto")) {
									JSONObject asentamientoJSON = ubicacionJSON.getJSONObject("asentamientoDto");
									
									AsentamientoDTO asentamientoDTO = new AsentamientoDTO();
									asentamientoDTO.setId(asentamientoJSON.isNull("id") ? -1 : asentamientoJSON.getInt("id"));
									asentamientoDTO.setNombre(asentamientoJSON.isNull("nombre") ? "" : asentamientoJSON.getString("nombre"));
									
									if(!asentamientoJSON.isNull("tipoAsentamientoDto")) {
										JSONObject tipoAsentamientoJSON = asentamientoJSON.getJSONObject("tipoAsentamientoDto");
										
										TipoAsentamientoDTO tipoAsentamientoDTO = new TipoAsentamientoDTO();
										tipoAsentamientoDTO.setId(tipoAsentamientoJSON.isNull("id") ? -1 : tipoAsentamientoJSON.getInt("id"));
										tipoAsentamientoDTO.setNombre(tipoAsentamientoJSON.isNull("nombre") ? "" : tipoAsentamientoJSON.getString("nombre"));
										
										asentamientoDTO.setTipoAsentamientoDto(tipoAsentamientoDTO);
									}
									
									ubicacionDTO.setAsentamientoDto(asentamientoDTO);
								}
								
								personaDomicilioDTO.setUbicacionDto(ubicacionDTO);
								
							}
							
							listPersonaDomicilioDTO.add(personaDomicilioDTO);
						}	
					}
				}
			}
			
			return listPersonaDomicilioDTO;
	}
}
