package org.biblioteca.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.biblioteca.model.Author;
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class AuthorDAO {
	JdbcTemplate dataSource;

	
	
	public int save(Author author){
		String sql="INSERT INTO Author  (aName,lastName,DOB,nationality) VALUES(:aName,:lastName,:DOB,:nationality);";
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("aName", author.getaName());
		parameters.put("lastName", author.getLastName());
		parameters.put("DOB", author.getDOB());
		parameters.put("nationality", author.getNationality());

		return dataSource.update(sql,parameters);  
	}
	
	public int Update(Author author){
		String sql="UPDATE Author SET aName=:aName,lastName=:lastName,DOB=:DOB,nationality=:nationality ;";
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("aName", author.getaName());
		parameters.put("lastName", author.getLastName());
		parameters.put("DOB", author.getDOB());
		parameters.put("nationality", author.getNationality());

		return dataSource.update(sql,parameters);  
	}

	public int delete(int id){  
	    String sql="delete from Author where ID=:id";  
	    Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("id", id);
	    return dataSource.update(sql,parameters);
	}  
	
	public Author getAuthorByID(int id){
		String sql="select * from Author where id=?"; 
	    return dataSource.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Author>(Author.class));  
	}
	
	public List<Author> getAll(){
		return dataSource.query("select ID, aName,lastName,DOB,nationality from Author",new RowMapper<Author>(){  
	        public Author mapRow(ResultSet rs, int row) throws SQLException {  
	        	Author author=new Author();  
	        	author.setID(rs.getInt(1));
	        	author.setaName(rs.getString(2));
	        	author.setLastName(rs.getString(3));
	        	author.setDOB(rs.getDate(4));
	        	author.setNationality(rs.getString(5));
	            return author;  
	        }  
	    });  
	}
	
	
	public JdbcTemplate getdataSource() {
		return dataSource;
	}

	public void setdataSource(JdbcTemplate dataSource) {
		this.dataSource = dataSource;
	}
}
