package org.little.spring.beans;

import org.little.spring.beans.factory.ApplicationContextTest;
import org.little.spring.beans.factory.BeanFactoryTest;
import org.little.spring.resource.ResourceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by shiyifan on 2018/6/19.
 *
 * @author shiyifan
 * @date 2018/06/19
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ApplicationContextTest.class, BeanFactoryTest.class, ResourceTest.class})
public class FactorySuite {
}
