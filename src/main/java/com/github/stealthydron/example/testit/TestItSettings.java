package com.github.stealthydron.example.testit;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:testit.properties",
        "system:env"})
public interface TestItSettings extends Config {

    String endpoint();

    String projectId();

    String token();

    @Key("testRunId")
    String testRunId();

    @Key("testPlanId")
    String testPlanId();

    @Key("configurationId")
    String configurationId();

}
