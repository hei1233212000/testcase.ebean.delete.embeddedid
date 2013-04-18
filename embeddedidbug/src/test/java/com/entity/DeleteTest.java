package com.entity;

import static org.junit.Assert.assertEquals;

import javax.persistence.PersistenceException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.EbeanServerFactory;
import com.avaje.ebean.LogLevel;
import com.avaje.ebean.config.DataSourceConfig;
import com.avaje.ebean.config.ServerConfig;
import com.google.common.collect.Lists;

public class DeleteTest {
	static EbeanServer eb;

	@BeforeClass public static void setUpBeforeClass() throws Exception {
		ServerConfig config = new ServerConfig();
		config.setName("test");

		// Define DataSource parameters
		DataSourceConfig h2 = new DataSourceConfig();
		h2.setDriver("org.h2.Driver");
		h2.setUsername("sa");
		h2.setPassword("");
		h2.setUrl("jdbc:h2:mem:tests;DB_CLOSE_DELAY=-1");
		h2.setHeartbeatSql("select 1");

		config.setDataSourceConfig(h2);

		// set DDL options
		config.setDdlGenerate(true);
		config.setDdlRun(true);

		config.setDebugSql(true);
		config.setDefaultServer(true);
		config.setRegister(true);
		config.setDebugLazyLoad(true);
		config.setLoggingLevel(LogLevel.SQL);

		// add entity
		config.addClass(User.class);
		config.addClass(UserRole.class);
		config.addClass(UserRolePK.class);
		config.addClass(Role.class);

		eb = EbeanServerFactory.create(config);
	}

	@Before public void setUp() throws Exception {
		eb.delete(eb.find(User.class).findList());
		eb.save(Lists.newArrayList(new User(1L, "Tom"), new User(2L, "Peter")));
	}

	@Test public void testDeleteSingleEntityById() {
		assertEquals("There should have 2 user records", 2, eb.find(User.class).findList().size());
		eb.delete(User.class, 1L);
		assertEquals("Now, there should have 1 user record remained", 1, eb.find(User.class).findList().size());
	}

	@Test(expected = PersistenceException.class) public void testDeleteListOfEntityById() {
		assertEquals("There should have 2 user records", 2, eb.find(User.class).findList().size());
		eb.delete(User.class, Lists.newArrayList(1L, 2L));
	}

}
