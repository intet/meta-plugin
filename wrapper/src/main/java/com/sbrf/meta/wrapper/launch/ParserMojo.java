package com.sbrf.meta.wrapper.launch;


import org.apache.maven.execution.MavenSession;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.BuildPluginManager;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.*;
import org.apache.maven.project.MavenProject;

import static org.twdata.maven.mojoexecutor.MojoExecutor.*;

@Mojo(name = "findApi", requiresDependencyResolution = ResolutionScope.COMPILE,
        defaultPhase = LifecyclePhase.PACKAGE, executionStrategy = "always")
@Execute(phase = LifecyclePhase.PACKAGE, goal = "findApi")
public class ParserMojo extends AbstractMojo {

    @Parameter(defaultValue = "${project}")
    private MavenProject project;

    @Parameter(defaultValue = "${project.build.sourceDirectory}")
    private String sourceDir;

    @Parameter(defaultValue = "${project.build.directory}")
    private String directory;

    @Component
    private MavenSession mavenSession;

    @Component
    private BuildPluginManager pluginManager;

    public void execute() {

        executeGoal("plugin", "LATEST", "findApi");

    }

    private void executeGoal(String artifactId, String version, String goal) {
        try {
            executeMojo(
                    plugin(
                            groupId("com.sbt.meta"),
                            artifactId(artifactId),
                            version(version)
                    ),
                    goal(goal),
                    configuration(),
                    executionEnvironment(
                            project,
                            mavenSession,
                            pluginManager
                    )
            );
        } catch (MojoExecutionException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
