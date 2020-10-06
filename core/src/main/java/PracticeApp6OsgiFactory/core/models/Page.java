package PracticeApp6OsgiFactory.core.models;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import PracticeApp6OsgiFactory.core.services.SiteConfigService;
import PracticeApp6OsgiFactory.core.services.SiteConfigServiceConsumer;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Page {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @Inject
    SiteConfigServiceConsumer service;

    @PostConstruct
    private void initModel() {
        log.info("Page is loaded");
        List<SiteConfigService> configurationList;
        configurationList = service.getConfigurationList();
        log.info("Service: {}", configurationList);
        for (int i = 0; i < configurationList.size(); i++) {
            log.info("Site ID: {}", (configurationList.get(i)).getSiteId());
            log.info("Site Name: {}", (configurationList.get(i)).getSiteId());
        }
    }
}
