package com.sbrf.meta.plugin.dto.api;

import com.sbrf.meta.plugin.dto.xml.GavType;
import org.apache.maven.artifact.Artifact;
import org.json.JSONObject;

import java.util.Objects;

public class GAV {
    public final String group;
    public final String artifact;
    public final String version;
    public String component;
    public String system;
    private String repository;

    public GAV(String group, String artifact, String version) {
        this.group = group;
        this.artifact = artifact;
        this.version = version;
    }

    public GAV(Artifact artifact, String repository) {
        this(artifact.getGroupId(),
                artifact.getArtifactId(),
                artifact.getVersion());
        this.repository = repository;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GAV gav = (GAV) o;
        return Objects.equals(group, gav.group) &&
                Objects.equals(artifact, gav.artifact) &&
                Objects.equals(version, gav.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(group, artifact, version);
    }

    public JSONObject toJson() {
        JSONObject result = new JSONObject();
        result.put("group", group);
        result.put("artifact", artifact);
        result.put("version", version);
        result.put("component", component);
        return result;
    }

    public GavType toXml() {
        GavType result = new GavType();
        result.setArtifact(artifact);
        result.setGroup(group);
        result.setComponent(component);
        result.setSystem(system);
        result.setVersion(version);
        result.setRepository(repository);
        return result;
    }
}
