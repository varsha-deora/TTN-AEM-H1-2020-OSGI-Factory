package PracticeApp6OsgiFactory.core.services.impl;


import java.util.ArrayList;
import java.util.List;

import PracticeApp6OsgiFactory.core.services.SiteConfigService;
import PracticeApp6OsgiFactory.core.services.SiteConfigServiceConsumer;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate = true, service = SiteConfigServiceConsumer.class, enabled = true)

public class SiteConfigServiceConsumerImpl implements SiteConfigServiceConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(SiteConfigServiceConsumer.class);
    private List configurationList;

    @Reference(name = "configurationFactory", cardinality = ReferenceCardinality.MULTIPLE, policy = ReferencePolicy.DYNAMIC)
    protected synchronized void bindConfigurationFactory(final SiteConfigService config) {
        LOGGER.info("bindConfigurationFactory: {}", config.getSiteId());
        if (configurationList == null) {
            configurationList = new ArrayList<>();
        }
        configurationList.add(config);
    }

    protected synchronized void unbindConfigurationFactory(final SiteConfigService config) {
        LOGGER.info("unbindConfigurationFactory: {}", config.getSiteId());
        configurationList.remove(config);
    }

    public List getConfigurationList() {
        return configurationList;
    }

    public void setConfigurationList(List configurationList) {
        this.configurationList = configurationList;
    }
}