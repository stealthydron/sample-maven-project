package com.github.stealthydron.example.testit.client.enums;

public enum EntityType {

    TEST_CASE("TestCases");

    private final String entityType;

    EntityType(final String entityType) {
        this.entityType = entityType;
    }

    public String type() {
        return entityType;
    }
}
