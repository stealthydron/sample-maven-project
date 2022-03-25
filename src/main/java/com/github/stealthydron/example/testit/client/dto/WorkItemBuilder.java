package com.github.stealthydron.example.testit.client.dto;

import com.github.stealthydron.example.testit.client.enums.EntityType;
import com.github.stealthydron.example.testit.client.enums.Priority;
import com.github.stealthydron.example.testit.client.enums.State;

import java.util.List;
import java.util.Map;

public class WorkItemBuilder {

    public WorkItemBuilder() {
    }

    public static Builder create() {
        return new Builder();
    }

    public static class Builder {

        private final WorkItem workItem;

        public Builder() {
            this.workItem = new WorkItem();
        }

        public Builder entityType(EntityType entityType) {
            this.workItem.setEntityTypeName(entityType.type());
            return this;
        }

        public Builder priority(Priority priority) {
            this.workItem.setPriority(priority.value());
            return this;
        }

        public Builder state(State state) {
            this.workItem.setState(state.value());
            return this;
        }

        public Builder name(String name) {
            this.workItem.setName(name);
            return this;
        }

        public Builder description(String description) {
            this.workItem.setDescription(description);
            return this;
        }

        public Builder projectId(String projectId) {
            this.workItem.setProjectId(projectId);
            return this;
        }

        public Builder sectionId(String sectionId) {
            this.workItem.setSectionId(sectionId);
            return this;
        }

        public Builder steps(List<WorkItemTestStep> testSteps) {
            this.workItem.setSteps(testSteps);
            return this;
        }

        public Builder attributes(Map<String, String> attributes) {
            this.workItem.setAttributes(attributes);
            return this;
        }

        public Builder autotests(List<Autotest> autotests) {
            this.workItem.setAutoTests(autotests);
            return this;
        }

        public WorkItem build() {
            return this.workItem;
        }

    }
}
