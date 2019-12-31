grails.servlet.version = "3.0" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.work.dir = "target/work"
grails.project.target.level = 1.6
grails.project.source.level = 1.6

grails.plugin.location.'i18n-core'="plugins/i18n_core.git"
grails.plugin.location.'banner-core'="plugins/banner_core.git"
grails.plugin.location.'banner-ui-ss'="plugins/banner_ui_ss.git"
grails.plugin.location.'sghe-aurora'="plugins/sghe_aurora.git"
grails.plugin.location.'banner-general-common' = "plugins/banner_general_common.git"
grails.plugin.location.'banner-student-common' = "plugins/banner_student_common.git"
grails.plugin.location.'banner-student-validation' = "plugins/banner_student_validation.git"
grails.plugin.location.'banner-general-person' = "plugins/banner_general_person.git"
grails.plugin.location.'banner-accountsreceivable-common' = "plugins/banner_accountsreceivable_common.git"
grails.plugin.location.'banner-student-faculty' = "plugins/banner_student_faculty.git"
//BANNER 2.5.0 Support
grails.plugin.location.'grails-constraints' = "plugins/grails_constraints.git"
grails.plugin.location.'banner-spring-security-cas' = "plugins/banner_spring_security_cas.git"
grails.plugin.location.'banner-spring-security-saml'   = "plugins/banner_spring_security_saml.git"
//FOR UI and 2.5.0 configuration
grails.plugin.location.'web-app-extensibility'="plugins/web-app-extensibility.git"
grails.plugin.location.'banner_general_utility' = "plugins/banner_general_utility.git"
grails.plugin.location.'domain-extension'                 = "plugins/domain_extension.git"
grails.plugin.location.'banner-general-validation-common' = "plugins/banner_general_validation_common.git"

//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.fork = [
    // configure settings for compilation JVM, note that if you alter the Groovy version forked compilation is required
    //  compile: [maxMemory: 256, minMemory: 64, debug: false, maxPerm: 256, daemon:true],

    // configure settings for the test-app JVM, uses the daemon by default
    test: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, daemon:true],
    // configure settings for the run-app JVM
    run: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
    // configure settings for the run-war JVM
    war: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
    // configure settings for the Console UI JVM
    console: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256]
]

grails.project.dependency.resolver = "maven" // or ivy

grails.project.dependency.resolution = {
    inherits "global" // inherit Grails' default dependencies
    log "warn"   // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'

    legacyResolve true
    repositories {
        if (System.properties['PROXY_SERVER_NAME']) {
            mavenRepo "${System.properties['PROXY_SERVER_NAME']}"
        }
        grailsCentral()
        mavenCentral()
        mavenRepo "http://repository.jboss.org/maven2/"
        mavenRepo "http://repo.grails.org/grails/repo"
        mavenRepo "http://download.java.net/maven/2/"
    }

    plugins {
        compile ':zipped-resources:1.0'
        compile ':cached-resources:1.0'
        compile ':resources:1.2.8'
        compile ':yui-minify-resources:0.1.5'
        compile ':cache-headers:1.1.5'
        compile ':csv:0.3.1'
        compile ':feeds:1.5'
        compile ':restful-api:1.0.0'
        compile ":mail:1.0.7"
        compile ":tomcat:7.0.70"
    }
}
