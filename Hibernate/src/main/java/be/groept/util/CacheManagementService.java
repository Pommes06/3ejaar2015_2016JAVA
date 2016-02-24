package be.groept.util;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.management.CacheManager;

public class CacheManagementService extends CacheManager implements
		CacheManagementServiceMBean {

	public CacheManagementService(net.sf.ehcache.CacheManager cacheManager)
			throws CacheException {
		super(cacheManager);
	}

}