package com.qualityplus.automatizacao;


import org.openqa.selenium.server.RemoteControlConfiguration;
import org.openqa.selenium.server.SeleniumServer;

public class SeleniumServerStart {

	private static boolean situacao = false;
	public static Integer port=4444;
	public static void iniciar() throws Exception {

		if (situacao == false) {

			RemoteControlConfiguration rc = new RemoteControlConfiguration();
			//rc.setTrustAllSSLCertificates(true);
			rc.setPort(port);
			rc.setReuseBrowserSessions(false);
			SeleniumServer seleniumServer = new SeleniumServer(rc);
			seleniumServer.start();
			situacao = true;

		}

	}

	public static boolean isIniciado() {

		return situacao;

	}

}