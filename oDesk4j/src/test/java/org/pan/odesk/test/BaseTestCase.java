package org.pan.odesk.test;

import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * Base unit test case
 * 
 * @author Pance.Isajeski
 *
 */
@RunWith(BlockJUnit4ClassRunner.class)
public abstract class BaseTestCase {
	
	protected static Properties props;
	@BeforeClass
	public static void baseInit() {
		
	}

}
