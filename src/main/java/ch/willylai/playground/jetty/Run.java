package ch.willylai.playground.jetty;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.webapp.WebAppContext;

public class Run {

	public static void main(String[] args) throws Exception {

		String webappDirLocation = "src/main/webapp/";
		
		Server server = new Server();

		Connector connector = new SelectChannelConnector();
		connector.setPort(8080);
		server.setConnectors(new Connector[] { connector });

		WebAppContext webappcontext = new WebAppContext();
		
		webappcontext.setDescriptor(webappDirLocation + "/WEB-INF/web.xml");
		webappcontext.setResourceBase(webappDirLocation);
		webappcontext.setContextPath("/");

		webappcontext.setParentLoaderPriority(true);
		 
        server.setHandler(webappcontext);
 
        server.start();
        server.join();
	}
}
