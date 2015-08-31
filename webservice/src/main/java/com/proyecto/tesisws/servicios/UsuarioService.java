package com.proyecto.tesisws.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.tesisws.dao.TelefonosMapper;
import com.proyecto.tesisws.dao.UsuariosMapper;
import com.proyecto.tesisws.modelos.Telefonos;
import com.proyecto.tesisws.modelos.TelefonosExample;
import com.proyecto.tesisws.modelos.Usuarios;
import com.proyecto.tesisws.modelos.UsuariosExample;

@Service
public class UsuarioService {

	@Autowired
	private UsuariosMapper usuariosMapper;
	@Autowired
	private TelefonosMapper telefonosMapper;
	
	@Transactional(rollbackFor=Exception.class)
	public int registrarUsuario(Usuarios usuario, String telefonoRegistro)throws Exception{
		if(obtenerUsuario(usuario.getUsuario())==null && telefonoRegistro != null){
			usuariosMapper.insert(usuario);
			Telefonos telefono = new Telefonos();
			telefono.setIdUsuario(usuario.getId());
			telefono.setTelefono(telefonoRegistro);
			telefonosMapper.insert(telefono);
			return usuario.getId();
		}
		return -1;
	}
	
	public Usuarios obtenerUsuarioPorId(Integer idUsuario){
		if(idUsuario != null){
			return usuariosMapper.selectByPrimaryKey(idUsuario);
		}
		return new Usuarios();
	}
	
	public Usuarios obtenerUsuario(String usuario){
		if(usuario != null){
			UsuariosExample exUser = new UsuariosExample();
			exUser.createCriteria().andUsuarioEqualTo(usuario);
			List<Usuarios> usuarios = usuariosMapper.selectByExample(exUser);
			if(usuarios.size() > 0){
				return usuarios.get(0);
			}
		}
		return null;
	}
	
	@Transactional(rollbackFor=Exception.class)
	public boolean actualizarUsuario(Usuarios usuario, List<Telefonos> telefonos) throws Exception{
		int exto = 0;
		if(usuario != null){
			exto = usuariosMapper.updateByPrimaryKeySelective(usuario);
		}
		if(telefonos != null && telefonos.size() > 0 && exto > 0){
			actualizarTelefonos(telefonos, usuario.getId());
			return true;
		}
		return false;
	}
	
	private void actualizarTelefonos(List<Telefonos> telefonos, Integer idUsuario)throws Exception{
		TelefonosExample exTel = new TelefonosExample();
		exTel.createCriteria().andIdUsuarioEqualTo(idUsuario);
		telefonosMapper.deleteByExample(exTel);
		for(Telefonos telefono : telefonos){
			telefono.setId(0);
			telefono.setIdUsuario(idUsuario);
			telefonosMapper.insert(telefono);
		}
	}
	
	
	
}// fin service
