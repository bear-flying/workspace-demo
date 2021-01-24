package com.founder.datamover;

import com.founder.datamover.biz.ConfigService;
import com.founder.datamover.biz.ExportService;

public class StartOracle {

	public static void main(String[] args) {
		
		
		ConfigService config = new ConfigService();
		
		ExportService export = new ExportService(config.getAttDir(),config.getOutputDir(),config.getBackupDir(),config.getSiteId(),config.getArticleType(),config.getHttpAddr(),config.getSourceList());
		
		export.execute();
	
		//ConfigService的26和27行选择
	}

}
