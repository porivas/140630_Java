package org.zerock.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

@FunctionalInterface
public interface DAOFunction{

	public ResultSet apply(PreparedStatement ps)throws Exception;
}
