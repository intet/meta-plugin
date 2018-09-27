package com.sbrf.meta.plugin.launch;

import org.apache.maven.artifact.Artifact;
import org.json.JSONObject;

import java.util.Objects;

public class GAV {
    public final String group;
    public final String artifact;
    public final String version;

    public GAV(String group, String artifact, String version) {
        this.group = group;
        this.artifact = artifact;
        this.version = version;
    }

    public GAV(Artifact artifact) {
        this(artifact.getGroupId(), artifact.getArtifactId(), artifact.getVersion());
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
        return result;
    }
}
