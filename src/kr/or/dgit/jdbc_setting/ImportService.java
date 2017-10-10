package kr.or.dgit.jdbc_setting;

import kr.or.dgit.jdbc_setting.dao.DatabaseDao;
import kr.or.dgit.jdbc_setting.service.DbService;

public class ImportService implements DbService{
	private static final ImportService Instance = new ImportService();
	
	
	public static ImportService getInstance() {
		return Instance;
	}


	public ImportService() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public void service() {
		DatabaseDao.getInstance().executeUpdateSQL("SET FOREIGN_KEY_CHECKS = 0");
		DatabaseDao.getInstance().executeUpdateSQL("use " + Config.DB_NAME);
		for (String tableName : Config.TABLE_NAME) {
			DatabaseDao.getInstance().executeUpdateSQL(String.format("LOAD DATA LOCAL INFILE '%s' INTO TABLE %s ",	 Config.getFilePath(tableName, false), tableName));
		}
		DatabaseDao.getInstance().executeUpdateSQL("SET FOREIGN_KEY_CHECKS = 1");
		
	}

}
