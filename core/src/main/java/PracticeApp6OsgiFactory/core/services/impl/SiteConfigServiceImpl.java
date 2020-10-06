package PracticeApp6OsgiFactory.core.services.impl;


import PracticeApp6OsgiFactory.core.configs.SiteConfigs;
import PracticeApp6OsgiFactory.core.services.SiteConfigService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Component(service = SiteConfigService.class, immediate = true)
@Designate(ocd = SiteConfigs.class, factory = true)
public class SiteConfigServiceImpl implements SiteConfigService {
    private static final Logger log = LoggerFactory.getLogger(SiteConfigService.class);
    private SiteConfigs config;

    @Activate
    protected void activate(SiteConfigs config) {
        log.info("In activate");
        this.config = config;
    }

    @Override
    public String getSiteId() {
        return config.getSiteId();
    }

    @Override
    public String getSiteName() {
        return config.getSiteName();
    }

}