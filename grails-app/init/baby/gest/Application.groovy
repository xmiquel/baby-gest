package baby.gest

import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration
import org.springframework.context.EnvironmentAware
import org.springframework.core.env.Environment
import org.springframework.core.env.MapPropertySource

class Application extends GrailsAutoConfiguration implements EnvironmentAware {
    static void main(String[] args) {
        GrailsApp.run(Application)
    }

    @Override
    void setEnvironment(Environment environment) {
        //Set up Configuration directory
        def configHome = System.getenv('EXTCONFIG_HOME') ?: System.getProperty('EXTCONFIG_HOME') ?: "/Users/xavi/repos/baby-gest/externalConfig"

        println ""
        println "Loading configuration from ${configHome}"
        def appConfigured = new File(configHome, 'babygestConfig.groovy').exists()
        println "Loading configuration file ${new File(configHome, 'babygestConfig.groovy')}"
        println "Config file found : " + appConfigured

        if (appConfigured) {
            def config = new ConfigSlurper()
            config.setEnvironment(grails.util.Environment.current.name)
            def configur = config.parse(new File(configHome, 'babygestConfig.groovy').toURL())
            environment.propertySources.addFirst(new MapPropertySource("babygestConfig", configur))
        }
    }
}
