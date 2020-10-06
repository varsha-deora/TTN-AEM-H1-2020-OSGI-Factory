package PracticeApp6OsgiFactory.core.configs;

/*
Interface whose public methods will represent the fields in the configuration.
*/

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "My Test Quickstart Site Configs")
public @interface SiteConfigs {

    @AttributeDefinition(name="Site Id", description="Site ID")
    String getSiteId() default "aemquickstart";
    @AttributeDefinition(name="Site Name", description="Site Name")
    String getSiteName() default "AEM Quickstart";
}
