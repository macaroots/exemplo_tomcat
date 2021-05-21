/**
 * LEA - Live Editing Applications
 * by Renato Lenz Costalima
 * This work is licensed under the Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License. To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-sa/4.0/.
 * Permissions beyond the scope of this license may be available at macaroots@gmail.com.
 */
package controllers;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;
import java.util.ArrayList;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import br.ifce.brain.MySQLBrain;
import br.ifce.mind.actions.AbstractAction;
import br.ifce.mind.Agent;
import br.ifce.mind.Ceed;

/**
 * Application Lifecycle Listener implementation class ContextListener
 *
 */
@WebListener
public class ContextListener implements ServletContextListener {

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event) {
    	
		String agentName, publicPath, rootPath, binPath, classpath;
    	String host, user, password, db;
		boolean debug;

    	ServletContext context = event.getServletContext();
        agentName = context.getInitParameter("agentName");
        publicPath = context.getInitParameter("publicPath");
        rootPath = context.getInitParameter("rootPath");
        binPath = context.getInitParameter("binPath");
        classpath = context.getInitParameter("classpath");
        host = System.getenv("MYSQL_HOST");
        user = System.getenv("MYSQL_USER");
        password = System.getenv("MYSQL_PASSWORD");
        db = System.getenv("MYSQL_DATABASE");
        debug = Boolean.parseBoolean(context.getInitParameter("debug"));
		
		List<Object> questions = new ArrayList<Object>();
		context.setAttribute("questions", questions);
		Ceed.getInstance().see("set", new Object [] {"askFor", new AbstractAction() {
            @Override
            public void act(Object o, Object o1) {
                Object [] args = (Object []) o;
                System.out.println("ASKING - " + args[0] + ", " + args[1]);
				questions.add(o);
            }
        }});
        Agent agent = Ceed.getAgent(agentName);
        agent.see("set", new Object [] {"publicPath", publicPath});
        agent.see("set", new Object [] {"srcPath", rootPath});
		agent.see("set", new Object [] {"binPath", binPath});
		agent.see("set", new Object [] {"classpath", classpath});
		agent.see("set", new Object [] {"host", host});
		agent.see("set", new Object [] {"user", user});
		agent.see("set", new Object [] {"password", password});
		agent.see("set", new Object [] {"db", db});
		
		try {
			PoolProperties p = new PoolProperties();
			p.setUrl("jdbc:mysql://" + host + ":3306/" + db);
			p.setDriverClassName("com.mysql.cj.jdbc.Driver");
			p.setUsername(user);
			p.setPassword(password);
			p.setJmxEnabled(true);
			p.setTestWhileIdle(false);
			p.setTestOnBorrow(true);
			p.setValidationQuery("SELECT 1");
			p.setTestOnReturn(false);
			p.setValidationInterval(30000);
			p.setTimeBetweenEvictionRunsMillis(30000);
			p.setMaxActive(100);
			p.setInitialSize(10);
			p.setMaxWait(10000);
			p.setRemoveAbandonedTimeout(60);
			p.setMinEvictableIdleTimeMillis(30000);
			p.setMinIdle(10);
			p.setLogAbandoned(true);
			p.setRemoveAbandoned(true);
			p.setJdbcInterceptors(
					"org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"+
					"org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
			DataSource datasource = new DataSource();
			datasource.setPoolProperties(p);
			MySQLBrain brain = new MySQLBrain(datasource);
			brain.debug = debug;
			agent.see("addLibrary", brain);			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		context.setAttribute("front", agent);
		agent.see("live", event);
		System.out.println(agent + " lived!");
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent event) {
        Agent agent = (Agent) event.getServletContext().getAttribute("front");
        
    }
	
}
