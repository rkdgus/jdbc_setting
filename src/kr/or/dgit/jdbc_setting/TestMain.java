package kr.or.dgit.jdbc_setting;

import java.sql.Connection;

import kr.or.dgit.jdbc_setting.jdbc.DBCon;
import kr.or.dgit.jdbc_setting.jdbc.JdbcUtil;
import kr.or.dgit.jdbc_setting.service.DbService;
import kr.or.dgit.jdbc_setting.service.InitService;

public class TestMain {

	public static void main(String[] args) {
		DBCon dbCon = DBCon.getInstance();
		
		Connection connection  = dbCon.getConnection();
		System.out.println(connection);
		
		DbService service = InitService.getInstance();
		service.service();
		
		service = ImportService.getInstance();
		service.service();
		
		service = ExportService.getInstance();
		service.service();
		
		JdbcUtil.close(connection);

	}

}
