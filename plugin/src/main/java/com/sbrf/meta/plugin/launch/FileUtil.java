package com.sbrf.meta.plugin.launch;

import com.sbrf.meta.plugin.dto.api.GAV;
import org.apache.maven.artifact.Artifact;
import org.apache.maven.artifact.repository.ArtifactRepository;
import org.apache.maven.project.MavenProject;
import org.eclipse.aether.RepositorySystem;
import org.eclipse.aether.RepositorySystemSession;
import org.eclipse.aether.artifact.DefaultArtifact;
import org.eclipse.aether.repository.RemoteRepository;
import org.eclipse.aether.resolution.ArtifactRequest;
import org.eclipse.aether.resolution.ArtifactResolutionException;
import org.eclipse.aether.resolution.ArtifactResult;

import java.io.File;
import java.util.*;

public class FileUtil {
    static Map<GAV, File> getJars(MavenProject project, RepositorySystem repoSystem, RepositorySystemSession repoSession, List<RemoteRepository> repositories) {
        Map<GAV, File> result = new HashMap<>();
        project.setArtifactFilter(artifact -> true);
        for (Artifact artifact : project.getArtifacts()) {
            File file = artifact.getFile();
            if (file == null)
                continue;

            String repository = getRepositoryUrl(repoSystem, repoSession, repositories, artifact, project.getDistributionManagementArtifactRepository());
            result.put(new GAV(artifact, repository, artifact.getClassifier()), file);

        }
        if (project.getArtifact().getFile() != null) {
            String repository = project.getDistributionManagementArtifactRepository() != null ? project.getDistributionManagementArtifactRepository().getUrl() : "";
            result.put(new GAV(project.getArtifact(), repository, ""), project.getArtifact().getFile());
        }
        return result;
    }

    private static String getRepositoryUrl(RepositorySystem repoSystem, RepositorySystemSession repoSession, List<RemoteRepository> repositories, Artifact artifact, ArtifactRepository defaultRepository) {
        ArtifactResult artifactResult = null;
        org.eclipse.aether.artifact.Artifact aetherArtifact = new DefaultArtifact(
                artifact.getGroupId(),
                artifact.getArtifactId(),
                artifact.getClassifier(),
                artifact.getType(),
                artifact.getVersion(), null);
        ArtifactRequest req = new ArtifactRequest().setRepositories(repositories).setArtifact(aetherArtifact);
        try {
            artifactResult = repoSystem.resolveArtifact(repoSession, req);
        } catch (ArtifactResolutionException e) {
            e.printStackTrace();
        }

        String repository = null;
        if (artifactResult != null && artifactResult.getRepository() instanceof RemoteRepository) {
            repository = ((RemoteRepository) artifactResult.getRepository()).getUrl();
        } else if (defaultRepository != null) {
            repository = defaultRepository.getUrl();
        }
        return repository;
    }

    public static Collection<File> collectFileFromDir(File dir) {
        Collection<File> result = new ArrayList<>();
        collectFileFromDir(dir, result);
        return result;
    }

    static void collectFileFromDir(File dir, Collection<File> result) {
        if (dir == null)
            return;
        File[] files = dir.listFiles();
        if (files == null)
            return;
        for (File file : files) {
            if (file.isDirectory())
                collectFileFromDir(file, result);
            if (file.isFile()) {
                if (file.getPath().endsWith(".java"))
                    result.add(file);
            }
        }
    }

    static Collection<File> getDependencySource(MavenProject project) {
        Set<File> result = new HashSet<>();
        for (Artifact jarA : project.getArtifacts()) {
            if (!(jarA.getGroupId().startsWith("com.sbt") || jarA.getGroupId().startsWith("ru")))
                continue;
            File jar = jarA.getFile();
            if (jar == null) continue;
            String path = jar.getPath();
            File source = new File(path.substring(0, path.length() - 4) + "-sources.jar");
            if (!source.exists()) continue;
            result.add(source);

        }
        return result;
    }
}
