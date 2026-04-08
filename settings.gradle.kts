pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Demonstrations"
include(":app")
include(":mod2")
include(":mod2poo")
include(":mod3demo2")
include(":mod4recomposition")
include(":mod4viewmodel")
include(":mod5intents")
include(":mod5permissions")
include(":mod5test")
include(":mod5navigation")
include(":mod6datastore")
include(":mod6sqlite")
include(":mod6room")
include(":mod7apirest")
