package gob.df.sds.sinai.common.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;

public abstract class AbstractDAO {
	
	  private JdbcTemplate jdbcTemplate;

	  protected final JdbcTemplate getJdbcTemplate() {
	    return jdbcTemplate;
	  }

	  public final void setJdbcTemplate(final JdbcTemplate jdbcTemplate) {
	    this.jdbcTemplate = jdbcTemplate;
	  }
	  
	  @SuppressWarnings({ "rawtypes", "unchecked" })
	  protected ParameterizedBeanPropertyRowMapper<?> getMapperFor(Class type){
		  return ParameterizedBeanPropertyRowMapper.newInstance(type);
	  }

}
