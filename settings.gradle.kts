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
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "PokePlayground"
include(":app")
include(":poke-sdk")
include(":poke-sdk:poke-sdk-domain")
include(":poke-sdk:poke-sdk-data")
include(":poke-sdk:poke-sdk-core")
include(":poke-sdk:poke-sdk-core-android")
include(":poke-sdk:poke-sdk-data-remote")
include(":poke-sdk:poke-sdk-data-local")
include(":poke-sdk:poke-sdk-feature-list")
