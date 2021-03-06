package com.sbrf.meta.plugin.launch;


import com.sbrf.meta.plugin.Parser;
import com.sbrf.meta.plugin.dto.api.ApiStorage;
import com.sbrf.meta.plugin.dto.api.GAV;
import org.apache.maven.execution.MavenSession;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.BuildPluginManager;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.*;
import org.apache.maven.project.MavenProject;
import org.eclipse.aether.RepositorySystem;
import org.eclipse.aether.RepositorySystemSession;
import org.eclipse.aether.repository.RemoteRepository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.twdata.maven.mojoexecutor.MojoExecutor.*;

@Mojo(name = "findApi", requiresDependencyResolution = ResolutionScope.NONE,
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

    @Parameter(defaultValue = "${project.remoteProjectRepositories}")
    private List<RemoteRepository> repositories;

    @Parameter(defaultValue = "${repositorySystemSession}")
    private RepositorySystemSession repoSession;

    @Component
    private RepositorySystem repoSystem;

    public void execute() {
        getLog().info("Start parse");
        Map<GAV, File> jars = FileUtil.getJars(this.project, repoSystem, repoSession, repositories);
        collectSource();
        Collection<File> source = FileUtil.collectFileFromDir(new File(sourceDir));
        Collection<File> jarSource = FileUtil.getDependencySource(project);

        ApiStorage storage = Parser.parse(jars, source, jarSource);
        saveToFile(storage.toXml());

        // storage.toUfs();
    }


    private void saveToFile(String json) {
        try (FileWriter file = new FileWriter(directory + "/api.xml")) {
            file.write(json);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        getLog().info("Finish parse");
        getLog().info(json);
    }

    private void collectSource() {
        executeGoal("maven-source-plugin", "3.0.1", "aggregate");
        executeGoal("maven-dependency-plugin", "3.1.1", "sources");
    }

    private void executeGoal(String artifactId, String version, String goal) {
        try {
            executeMojo(
                    plugin(
                            groupId("org.apache.maven.plugins"),
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
